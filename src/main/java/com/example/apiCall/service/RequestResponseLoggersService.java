package com.example.apiCall.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class RequestResponseLoggersService implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        log.info(
                "\n\n------------------------------------------------------" +
                        "\nHTTP Methods LOG : \nMethod={}; \nRequest URI={}; " +
                         "\nRESPONSE CODE={};\n",
                httpServletRequest.getMethod(), httpServletRequest.getRequestURI(), httpServletResponse.getStatus());

        log.info("Request URI: {}", httpServletRequest.getRequestURI());
        log.info("Request Method: {}", httpServletRequest.getMethod());

        filterChain.doFilter(servletRequest, servletResponse);


    }
}
