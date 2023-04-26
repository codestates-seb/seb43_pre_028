package server.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@CrossOrigin
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true); //내 서버 응답 할때 제이슨을 자바스크립트에서 처리할 수 있게 할지 결정
//            config.addAllowedOriginPattern("*");// 모든 ip 응답 허용
        config.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:3001", "https://prepro28.s3-website.ap-northeast-2.amazonaws.com"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PATCH", "DELETE", "PUT", "OPTIONS"));
        config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
        config.addExposedHeader("Authorization");
//            config.addAllowedHeader("*");// 모든 헤더에 응답 허용
//            config.addAllowedMethod("*");// 모든 http 메소드 응답 허용

        source.registerCorsConfiguration("/**",config);

        return new CorsFilter(source);

    }
}