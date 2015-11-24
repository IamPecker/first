/**
 * Copyright (C) 2012-2015 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 as published
 * by the Free Software Foundation.
 *
 * If the program is linked with libraries which are licensed under one of
 * the following licenses, the combination of the program with the linked
 * library is not considered a "derivative work" of the program:
 *
 *     - Apache License, version 2.0
 *     - Apache Software License, version 1.0
 *     - GNU Lesser General Public License, version 3
 *     - Mozilla Public License, versions 1.0, 1.1 and 2.0
 *     - Common Development and Distribution License (CDDL), version 1.0
 *
 * Therefore the distribution of the program linked with libraries licensed
 * under the aforementioned licenses, is permitted by the copyright holders
 * if the distribution is compliant with both the GNU General Public
 * License version 2 and the aforementioned licenses.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 */
package org.n52.iceland.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Postpones a operation until a configurable amount of time is passed without
 * further requests for the operation.
 *
 * @since 1.0.0
 *
 * @author Christian Autermann
 */
public class Debouncer {

    private final ScheduledExecutorService executor = Executors
            .newScheduledThreadPool(1);
    private final Object lock = new Object();
    private final Runnable runnable;
    private final int interval;
    private DelayedTask delayed;

    /**
     * Creates a new {@code Debouncer}.
     *
     * @param interval the interval to wait for new {@linkplain #call() calls}.
     * @param runnable the task to execute
     */
    public Debouncer(int interval, Runnable runnable) {
        this.interval = interval;
        this.runnable = runnable;
    }

    /**
     * Request the execution of the operation.
     */
    public void call() {
        DelayedTask task = new DelayedTask();
        DelayedTask prev;
        do {
            synchronized (this.lock) {
                prev = this.delayed;
                this.delayed = task;
            }
            if (prev == null) {
                this.executor.schedule(task, this.interval, TimeUnit.MILLISECONDS);
            }

        } while (prev != null && !prev.postpone());
    }

    /**
     * Shut this {@code Debouncer} down by executing any pending request.
     *
     * Note: further calls to this class are undefined.
     */
    public void finish() {
        this.executor.shutdownNow().forEach(Runnable::run);
    }

    /**
     * Delayable task.
     */
    private class DelayedTask implements Runnable {
        private final Object lock = new Object();
        private long dueTime = 0;

        DelayedTask() {
            postpone();
        }

        /**
         * Postpone this task for {@code interval} milliseconds.
         *
         * @return {@code true} if this task was rescheduled, {@code false} if
         *         this task has already been executed
         */
        private boolean postpone() {
            synchronized (this.lock) {
                if (this.dueTime < 0) {
                    return false;
                }
                this.dueTime = System.currentTimeMillis() + interval;
                return true;
            }
        }

        /**
         * Executes the operations or reschedules itself if postponed.
         */
        @Override
        public void run() {
            synchronized (this.lock) {
                long remaining = this.dueTime - System.currentTimeMillis();
                if (remaining > 0) {
                    // Re-schedule task
                    Debouncer.this.executor
                            .schedule(this, remaining, TimeUnit.MILLISECONDS);
                } else {
                    this.dueTime = -1;
                    try {
                        Debouncer.this.runnable.run();
                    } finally {
                        synchronized (Debouncer.this.lock) {
                            Debouncer.this.delayed = null;
                        }
                    }
                }
            }
        }
    }

}
