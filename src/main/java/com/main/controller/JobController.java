package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Job;
import com.main.entity.Jobs;
import com.main.entity.SignUser;
import com.main.repository.JobRepository;
import com.main.repository.JobsRepository;
import com.main.repository.UserRepository;
import com.main.service.JobService;

import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class JobController {

    @Autowired
    private JobService jobService;
    @Autowired
    JobRepository jobRepository;
    
    @Autowired
    UserRepository userRepository;
    
    @GetMapping("/searchJobs")
    public List<Job> searchJobs(@RequestParam String query) {
        return jobService.searchJobs(query);
    }
    
    @PostMapping("resume/updateJob")
    public ResponseEntity<?> saveJob(@RequestBody Jobs job,HttpSession session) {
		
		
    	String email=(String) session.getAttribute("user_email");
    	Optional<SignUser> user1=userRepository.findById(email); 	
    	SignUser user=user1.get();
    	String jobSearch=job.getJobSearch();
			jobService.saveJob(user, jobSearch);
			return ResponseEntity.ok().build();     
		}
    
    
}