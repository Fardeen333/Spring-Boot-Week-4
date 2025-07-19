package com.codingshuttle.anuj.production_ready_features.production_ready_features.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDTO {

    private Long id;

    private String name;


    private String email;


    private Integer age;


    private String role;

    private LocalDate dateOfJoining;

    @JsonProperty("isActive")
    private Boolean isActive;


}
