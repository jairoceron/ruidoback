package cimab.openaq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
 @EnableConfigurationProperties
public class OpenAqCimab {

    public static void main(String[] args) {
        SpringApplication.run(OpenAqCimab.class, args);
    }

     @Bean
     public WebMvcConfigurer corsConfigurer() {
         return new WebMvcConfigurer() {
             @Override
             public void addCorsMappings(CorsRegistry registry) {
                 registry.addMapping("/**").allowedOrigins("/**").allowedMethods("*").allowedHeaders("*");
             }
         };
     }

}