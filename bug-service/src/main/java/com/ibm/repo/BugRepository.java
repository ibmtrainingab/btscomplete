package com.ibm.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.Entity.Bug;

public interface BugRepository extends MongoRepository<Bug, String> {

}
