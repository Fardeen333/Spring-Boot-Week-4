package com.codingshuttle.anuj.production_ready_features.production_ready_features.config;

import com.codingshuttle.anuj.production_ready_features.production_ready_features.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Configuration
public class RestClientConfig {

    @Value(value = "${employeeRestClient.base.url}")
    private String EMPLOYEE_REST_CLIENT_BASE_URL;

    @Bean
    @Qualifier("employeeRestClinet")
    RestClient getEmployeeServiceRestClient(){
        return RestClient.builder()
                .baseUrl(EMPLOYEE_REST_CLIENT_BASE_URL)
                .defaultHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .defaultStatusHandler(HttpStatusCode::is5xxServerError, (req, res) -> {
                    throw new ResourceNotFoundException("Server Error");
                })
                .build();
    }

}
