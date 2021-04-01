package com.ibm.Service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.Entity.Bug;
import com.ibm.Entity.STATUS;
import com.ibm.repo.BugRepository;

@Service
public class BugService {
	@Autowired
	BugRepository bugRepository;

	public BugRepository getBugRepository() {
		return bugRepository;
	}

	public void setBugRepository(BugRepository bugRepository) {
		this.bugRepository = bugRepository;
	}

	public String createBug(Bug bug) {
		Bug savedBug = bugRepository.save(bug);
		return savedBug.getId();
	}

	public List<Bug> getBugs() {
		return bugRepository.findAll();
	}

	public Optional<Bug> getBug(String id) {
		return bugRepository.findById(id);
	}

	public STATUS updateBugStatus(@Valid Bug bug) {
		bugRepository.save(bug);
		return bug.getStatus();
	}

}
