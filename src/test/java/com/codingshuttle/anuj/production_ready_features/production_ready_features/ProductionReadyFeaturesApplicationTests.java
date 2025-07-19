package com.codingshuttle.anuj.production_ready_features.production_ready_features;

import com.codingshuttle.anuj.production_ready_features.production_ready_features.clients.EmployeeClient;
import com.codingshuttle.anuj.production_ready_features.production_ready_features.dto.EmployeeDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductionReadyFeaturesApplicationTests {

	@Autowired
	private EmployeeClient employeeClient;

	@Test
//	@Order(3)
	void getAllEmployees() {
		List<EmployeeDTO> allEmployees = employeeClient.getAllEmployees();
		System.out.println(allEmployees);
	}
//
//	@Test
//	@Order(1)
//	void getEmpById() {
//		EmployeeDTO allEmployees = employeeClient.getEmployeeById(402L);
//		System.out.println(allEmployees);
//	}
//
//	@Test
//	@Order(2)
//	void createEmp() {
//		EmployeeDTO createPayload = new EmployeeDTO(null, "Rest user", "restuser@gmail.com", 20, "USER", LocalDate.now(), true);
//		EmployeeDTO allEmployees = employeeClient.createEmployee(createPayload);
//		System.out.println(allEmployees);
//	}

}
