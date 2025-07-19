package com.codingshuttle.anuj.production_ready_features.production_ready_features.clients;

import com.codingshuttle.anuj.production_ready_features.production_ready_features.advice.ApiResponse;
import com.codingshuttle.anuj.production_ready_features.production_ready_features.dto.EmployeeDTO;
import com.codingshuttle.anuj.production_ready_features.production_ready_features.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class EmployeeClientImpl implements EmployeeClient{

    Logger logger = LoggerFactory.getLogger(EmployeeClientImpl.class);

    @Autowired
    private RestClient restClient;


    @Override
    public List<EmployeeDTO> getAllEmployees() {
        try{
            logger.info("Something the getAllEmployees");
            ApiResponse<List<EmployeeDTO>> response = restClient.get()
                    .uri("employees")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            logger.trace("Retrieved the data : {}", response);
            return response.getData();
        } catch (Exception e){
            logger.trace("Something when wrong in getAllEmployees");
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        try{
            ApiResponse<EmployeeDTO> response = restClient.get()
                    .uri("employees/{employeeId}", id)
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {});

            return response.getData();
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO payload) {
        try{
            ResponseEntity<ApiResponse<EmployeeDTO>> response = restClient.post()
                    .uri("employees")
                    .body(payload)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        System.out.println("Error : " + new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("Not able to create employee");
                    })
                    .toEntity(new ParameterizedTypeReference<>() {});

            return response.getBody().getData();
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
