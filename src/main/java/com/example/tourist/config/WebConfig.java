
package com.example.tourist.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.example.tourist.interceptor.TouristInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private TouristInterceptor touristInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(touristInterceptor)
                .addPathPatterns("/api/tourists/**");
    }
}
