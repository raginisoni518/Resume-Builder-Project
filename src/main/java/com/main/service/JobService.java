package com.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.Job;
import com.main.entity.Jobs;
import com.main.entity.SignUser;
import com.main.repository.JobRepository;
import com.main.repository.JobsRepository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private JobsRepository jobsRepository;
   

	
	@PostConstruct
    public void onStartup() {
        // Define multiple records to insert
        List<Job> entities = Arrays.asList(
            new Job(1, "HTML"),
            new Job(2, "CSS"),
            new Job(3, "Javascript"),
            new Job(4, "Java"),
            new Job(5, "Core Java"),
            new Job(6, "Advance Java"),
            new Job(7, "SQL"),
            new Job(8, "C"),
            new Job(9, "C++"),
            new Job(10, "Python"),
            new Job(11, "Django")
        );

        // Save all entities to the database
        jobRepository.saveAll(entities);

        System.out.println("Inserted multiple records at startup.");
    }
	@PreDestroy
    public void onShutdown() {
        // Delete all records from the database
        jobRepository.deleteAll();
        System.out.println("Deleted all records at shutdown.");
    }
    
    public List<Jobs> findByUser(SignUser user) {
        return jobsRepository.findByUser(user);
    }
    public List<Job> searchJobs(String query) {
        return jobRepository.findByTitleContainingIgnoreCase(query);
    }
    public void saveJob(SignUser user1,String jobSearch) {
    	Jobs user=new Jobs();
    	user.setJobSearch(jobSearch);
    	user.setUser(user1);
    	jobsRepository.save(user);
    }
}