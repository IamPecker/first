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
package org.n52.iceland.service;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.n52.iceland.binding.Binding;
import org.n52.iceland.binding.BindingRepository;
import org.n52.iceland.event.ServiceEventBus;
import org.n52.iceland.event.events.ExceptionEvent;
import org.n52.iceland.event.events.IncomingRequestEvent;
import org.n52.iceland.event.events.OutgoingResponseEvent;
import org.n52.iceland.exception.HTTPException;
import org.n52.iceland.util.http.HTTPHeaders;
import org.n52.iceland.util.http.HTTPMethods;
import org.n52.iceland.util.http.HTTPStatus;
import org.n52.iceland.util.http.MediaType;
import org.n52.iceland.util.http.MediaTypes;

import com.google.common.base.Stopwatch;

/**
 * The servlet of the Service which receives the incoming HttpPost and HttpGet
 * requests and sends the operation result documents to the client TODO review
 * exception handling
 *
 * @since 4.0.0
 */
@Controller
@RequestMapping(value = "/service", consumes = "*/*", produces = "*/*")
public class Service extends HttpServlet {
    private static final long serialVersionUID = -2103692310137045855L;
    private static final Logger LOGGER = LoggerFactory.getLogger(Service.class);

    public static final String BINDING_DELETE_METHOD = "doDeleteOperation";
    public static final String BINDING_PUT_METHOD = "doPutOperation";
    public static final String BINDING_POST_METHOD = "doPostOperation";
    public static final String BINDING_GET_METHOD = "doGetOperation";

    private static final AtomicLong counter = new AtomicLong(0);

    @Inject
    private transient BindingRepository bindingRepository;

    @Inject
    private transient ServiceEventBus serviceEventBus;

    private long logRequest(HttpServletRequest request) {
        long count = counter.incrementAndGet();
        this.serviceEventBus.submit(new IncomingRequestEvent(request, count));

        if (LOGGER.isDebugEnabled()) {
            Enumeration<?> headerNames = request.getHeaderNames();
            StringBuilder headers = new StringBuilder();
            while (headerNames.hasMoreElements()) {
                String name = (String) headerNames.nextElement();
                headers.append("> ").append(name).append(": ").append(request.getHeader(name)).append("\n");
            }
            LOGGER.debug("Incoming request No. {}:\n> [{} {} {}] from {} {}\n{}", count, request.getMethod(),
                    request.getRequestURI(), request.getProtocol(), request.getRemoteAddr(), request.getRemoteHost(),
                    headers);
        }
        return count;
    }

    private void logResponse(HttpServletRequest request, HttpServletResponse response, long count, Stopwatch stopwatch) {
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MILLISECONDS);
        this.serviceEventBus.submit(new OutgoingResponseEvent(request, response, count, elapsed));
        LOGGER.debug("Outgoing response for request No. {} is committed = {} (took {} ms)", count, response.isCommitted(), elapsed);
    }

    @Override
    @Deprecated
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        delete(request, response);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        long currentCount = logRequest(request);
        try {
            getBinding(request).doDeleteOperation(request, response);
        } catch (HTTPException exception) {
            onHttpException(request, response, exception);
        } finally {
            logResponse(request, response, currentCount, stopwatch);
        }
    }

    @Deprecated
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        get(request, response);
    }

    @RequestMapping(method = RequestMethod.GET)
    public void get(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        long currentCount = logRequest(request);
        try {
            getBinding(request).doGetOperation(request, response);
        } catch (HTTPException exception) {
            onHttpException(request, response, exception);
        } finally {
            logResponse(request, response, currentCount, stopwatch);
        }
    }

    @Deprecated
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        post(request, response);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void post(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        long currentCount = logRequest(request);
        try {
            getBinding(request).doPostOperation(request, response);
        } catch (HTTPException exception) {
            onHttpException(request, response, exception);
        } finally {
            logResponse(request, response, currentCount, stopwatch);
        }
    }

    @Deprecated
    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        put(request, response);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void put(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        long currentCount = logRequest(request);
        try {
            getBinding(request).doPutOperation(request, response);
        } catch (HTTPException exception) {
            onHttpException(request, response, exception);
        } finally {
            logResponse(request, response, currentCount, stopwatch);
        }
    }

    @Deprecated
    @Override
    public void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        options(request, response);
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    private void options(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException, ServletException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        long currentCount = logRequest(request);
        Binding binding = null;
        try {
            binding = getBinding(request);
            binding.doOptionsOperation(request, response);
        } catch (HTTPException exception) {
            if (exception.getStatus() == HTTPStatus.METHOD_NOT_ALLOWED && binding != null) {
                doDefaultOptions(binding, request, response);
            } else {
                onHttpException(request, response, exception);
            }
        } finally {
            logResponse(request, response, currentCount, stopwatch);
        }
    }

    /**
     * Get the implementation of {@link Binding} that is registered for the
     * given <code>request</code>.
     *
     * @param request
     *            URL pattern from request URL
     *
     * @return The implementation of {@link Binding} that is registered for the
     *         given <code>urlPattern</code>.
     *
     *
     * @throws HTTPException If the URL pattern or ContentType is not supported
     *                       by this SOS.
     */
    private Binding getBinding(HttpServletRequest request) throws HTTPException {
        final String requestURI = request.getPathInfo();
        if (requestURI == null || requestURI.isEmpty() || requestURI.equals("/")) {
            MediaType contentType = getContentType(request);
            // strip of the parameters to get rid of things like encoding
            Binding binding = this.bindingRepository.getBinding(contentType.withoutParameters());
            if (binding == null) {
                if (contentType.equals(MediaTypes.APPLICATION_KVP)) {
                    throw new HTTPException(HTTPStatus.METHOD_NOT_ALLOWED);
                } else {
                    throw new HTTPException(HTTPStatus.UNSUPPORTED_MEDIA_TYPE);
                }
            } else {
                return binding;
            }
        }

        for (String prefix : this.bindingRepository.getAllBindingsByPath().keySet()) {
            if (requestURI.startsWith(prefix)) {
                return this.bindingRepository.getBinding(prefix);
            }
        }
        throw new HTTPException(HTTPStatus.NOT_FOUND);
    }

    private MediaType getContentType(HttpServletRequest request)
            throws HTTPException {
        if (request.getContentType() == null) {
            // default to KVP for GET requests
            if (request.getMethod().equals(HTTPMethods.GET)) {
                return MediaTypes.APPLICATION_KVP;
            } else {
                throw new HTTPException(HTTPStatus.BAD_REQUEST);
            }
        } else {
            try {
                return MediaType.parse(request.getContentType());
            } catch (IllegalArgumentException e) {
                throw new HTTPException(HTTPStatus.BAD_REQUEST, e);
            }
        }
    }

    protected void onHttpException(HttpServletRequest request, HttpServletResponse response, HTTPException exception)
            throws IOException {
        this.serviceEventBus.submit(new ExceptionEvent(exception));
        response.sendError(exception.getStatus().getCode(), exception.getMessage());
    }

    protected void doDefaultOptions(Binding binding, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Set<String> methods = getDeclaredBindingMethods(binding.getClass());
        StringBuilder allow = new StringBuilder();
        if (methods.contains(BINDING_GET_METHOD)) {
            allow.append(HTTPMethods.GET);
            allow.append(", ");
            allow.append(HTTPMethods.HEAD);
        }
        if (methods.contains(BINDING_POST_METHOD)) {
            if (allow.length() != 0) {
                allow.append(", ");
            }
            allow.append(HTTPMethods.POST);
        }
        if (methods.contains(BINDING_PUT_METHOD)) {
            if (allow.length() != 0) {
                allow.append(", ");
            }
            allow.append(HTTPMethods.PUT);
        }
        if (methods.contains(BINDING_DELETE_METHOD)) {
            if (allow.length() != 0) {
                allow.append(", ");
            }
            allow.append(HTTPMethods.DELETE);
        }

        if (allow.length() != 0) {
            allow.append(", ");
        }
        allow.append(HTTPMethods.TRACE);
        allow.append(", ");
        allow.append(HTTPMethods.OPTIONS);
        response.setHeader(HTTPHeaders.ALLOW, allow.toString());
    }

    private Set<String> getDeclaredBindingMethods(Class<?> c) {
        if (c.equals(Binding.class)) {
            return Collections.emptySet();
        } else {
            Set<String> parent = getDeclaredBindingMethods(c.getSuperclass());
            for (Method m : c.getDeclaredMethods()) {
                parent.add(m.getName());
            }
            return parent;
        }
    }
}
