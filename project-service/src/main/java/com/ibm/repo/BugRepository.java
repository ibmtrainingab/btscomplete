package com.ibm.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.Entity.Project;

public interface BugRepository extends MongoRepository<Project, String> {

}
