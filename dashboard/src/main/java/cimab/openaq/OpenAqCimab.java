package cimab.openaq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

 @SpringBootApplication
 @EnableConfigurationProperties
public class OpenAqCimab {

    public static void main(String[] args) {
        SpringApplication.run(OpenAqCimab.class, args);
    }

}