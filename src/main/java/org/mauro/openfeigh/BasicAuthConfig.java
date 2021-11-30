package org.mauro.openfeigh;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasicAuthConfig {

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(@Value("${spring.security.user.name}") final String user,
                                                                   @Value("${spring.security.user.password}") final String password) {
        return new BasicAuthRequestInterceptor(user, password);
    }
}
