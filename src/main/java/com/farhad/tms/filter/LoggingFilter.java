package com.farhad.tms.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component // Marks this class as a Spring component so that Spring Boot can detect and register it as a bean
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        // Cast the generic ServletRequest to HttpServletRequest to access HTTP-specific methods like getRequestURI().
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        // Print the URI of the incoming request to the console (for logging/debugging purposes).
        System.out.println("Request URL: " + httpServletRequest.getRequestURL());

        // Continue the filter chain. This means the request is passed to the next filter (if any),
        // or to the target servlet/controller if there are no more filters.
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
