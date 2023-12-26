package com.web.blog.config;


import com.web.blog.resolver.TestResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class CorsConfig implements WebMvcConfigurer {

    private final TestResolver testResolver;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
                //.allowedOrigins("http://127.0.0.1:5173", "http://localhost:5173");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(testResolver);
    }
}