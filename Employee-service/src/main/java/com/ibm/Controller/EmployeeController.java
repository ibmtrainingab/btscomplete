package com.ibm.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.Entity.Employee;
import com.ibm.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/employee")
	@ResponseStatus(code = HttpStatus.CREATED)
	String createEmployee(@RequestBody @Valid Employee employee, BindingResult bindingresult) {
		validateModel(bindingresult);
		System.out.println(employee);
		return employeeService.createEmployee(employee);
	}

	private void validateModel(BindingResult bindingresult) {
		if (bindingresult.hasErrors()) {
			throw new IllegalArgumentException("Something went wrong, please retry!");
		}

	}

	@GetMapping("/employee")
	List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	@GetMapping("/employee/{id}")
	Optional<Employee> getEmployee(@RequestBody @PathVariable("id") String Id) {
		return employeeService.getEmployee(Id);
	}

	@PutMapping("/employee/{id}")
	void updateEmployee(@RequestBody @Valid Employee employee, BindingResult bindingresult,
			@PathVariable("id") String Id) {
		validateModel(bindingresult);
		employee.setId(Id);
		employeeService.updateEmployee(employee);

	}

	@DeleteMapping("/employee/{id}")
	void deleteEmployee(@PathVariable("id") String empid) {

		System.out.println(empid);
		employeeService.deleteEmployee(empid);

	}
}
