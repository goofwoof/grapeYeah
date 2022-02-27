package com.tencent.wxcloudrun.config;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class IdFilter extends OncePerRequestFilter {
    private static final String HEADER_OPEN_ID = "x-wx-openid";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
        UserContext.setOpenId(request.getHeader(HEADER_OPEN_ID));
        filterChain.doFilter(request, response);
    }
}
