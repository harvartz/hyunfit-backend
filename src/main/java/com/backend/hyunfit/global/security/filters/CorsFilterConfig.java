package com.backend.hyunfit.global.security.filters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsFilterConfig {
    @Value("${origin.backend-ec2-ip}")
    private String backendEc2IP;
    @Value("${origin.frontend-url}")
    private String frontendUrl;

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // 허용할 오리진(Origin)들을 추가합니다.
        config.addAllowedOrigin(backendEc2IP);
        config.addAllowedOrigin(frontendUrl);

        // 다른 CORS 관련 설정들을 필요에 따라 추가합니다.

        source.registerCorsConfiguration("/**", config); // CORS 설정을 "/api/**" 경로에만 적용합니다.
        return new CorsFilter(source);
    }
}
