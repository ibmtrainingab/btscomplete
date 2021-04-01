package com.ibm.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ibm.Entity.Bug;
import com.ibm.Entity.Employee;
import com.ibm.Entity.STATUS;
import com.ibm.Service.BugService;
import com.ibm.Service.DummyBugRepository;
import com.ibm.repo.BugRepository;
import com.ibm.repo.EmployeeRepository;

class EmployeeServiceTest {

	@Test
	void testCreateEmployee() {
		EmployeeService employeeService = new EmployeeService();
		EmployeeRepository dummyRepo = new DummyEmployeeRepository();
		employeeService.setEmployeeRepository(dummyRepo);
		Employee employee = new Employee();
		String empid = employeeService.createEmployee(employee);
		assertNotNull(empid);	}
	@Test
	void testUpdateEmployee() {
		EmployeeService employeeService = new EmployeeService();
		EmployeeRepository dummyRepo = new DummyEmployeeRepository();
		employeeService.setEmployeeRepository(dummyRepo);
		Employee employee = new Employee();
		
	}

//	@Test
	//void testGetEmployees() {
		//fail("Not yet implemented");
	//}

	//Test
	//void testGetEmployee() {
	//	fail("Not yet implemented");
	//}

	

//	@Test
	//void testDeleteEmployee() {
		//fail("Not yet implemented");
	//}

}
