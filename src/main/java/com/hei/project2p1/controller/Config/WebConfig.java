package com.hei.project2p1.controller.Config;

import com.hei.project2p1.controller.AuthenticatedController;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Enregistrez votre intercepteur personnalisé
        registry.addInterceptor(new AuthenticatedController()).addPathPatterns("/**");
    }
}

