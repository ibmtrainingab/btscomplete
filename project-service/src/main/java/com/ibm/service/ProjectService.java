package com.ibm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
	@Autowired
	ProjectRepository projectRepository;

	public String createProject(Project project) {
		Project saveProject = projectRepository.save(project);
		return saveProject.getId();
	}

	public List<Project> getProjects() {
		return projectRepository.findAll();
	}

	public Optional<Project> getProject(String id) {
		return projectRepository.findById(id);
	}

	public void updateProject(Project project) {
		projectRepository.save(project);
	}

	public void deleteProject(String id) {
		projectRepository.deleteById(id);
	}

}
