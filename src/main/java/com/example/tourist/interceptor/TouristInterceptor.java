
package com.example.tourist.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TouristInterceptor implements HandlerInterceptor {

    private static final String VALID_TOKEN =
            "my-secret-token";

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {

        // Validate only PUT requests
        if (!"PUT".equalsIgnoreCase(request.getMethod())) {
            return true;
        }

        String token = request.getHeader("Token");

        if (VALID_TOKEN.equals(token)) {
            return true;
        }

        response.setStatus(
                HttpServletResponse.SC_UNAUTHORIZED);

        response.getWriter().write(
                "Invalid or Missing Token");

        return false;
    }
}
