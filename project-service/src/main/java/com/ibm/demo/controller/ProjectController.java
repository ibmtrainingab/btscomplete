package com.ibm.demo.controller;

import javax.validation.Valid;
import com.ibm.Entity;
import com.ibm.service;
import com.ibm.Entity.Project;
import com.ibm.service.ProjectService;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProjectController {
	@PostMapping("/project")
	@ResponseStatus(code = HttpStatus.CREATED)
	String createProject(@Valid Project project, BindingResult bindingResult) {
		validateModel(bindingResult);
		System.out.println(project);
		return ProjectService.createProject(project); 
	}

	@GetMapping("/project")
	List<project> getprojects() {
		System.out.println(ProjectService.hashCode());
		return ProjectService.getProject();
	}
	
	@GetMapping("/project/{id}")
	Optional<project> getProject(@PathVariable("id") int Id) {
		return ProjectService.getProject(Id);
	}

	@PutMapping("/project/{id}")
	void updateProject(@Valid Project project, BindingResult bindingResult, @PathVariable("id") int Id) {
		validateModel(bindingResult);
		System.out.println(Id);
		project.setId(Id);
		ProjectService.updateProject(project);
	}
}
