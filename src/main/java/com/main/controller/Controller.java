package com.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Jobs;
import com.main.entity.SignUser;
import com.main.repository.UserRepository;
import com.main.service.JobService;
import com.main.service.Service;

import jakarta.servlet.http.HttpSession;

@org.springframework.stereotype.Controller

@RequestMapping("/resume")
public class Controller {
	  @Autowired
	  UserRepository userRepository;
	  
	  @Autowired
	  JobService jobService;
	  
      @GetMapping("/home")
      public String getHomePage() {
    	  return "home";
      }
      @GetMapping("/signIn")
      public String getSignIn() {
    	  
    	  return "signIn";
      }
      @GetMapping("/signUp")
      public String getSignUp() {  
    	  return "signup";
      }
      @GetMapping("/personalDetails")
      public String getPersonalDetails() {  
    	  return "personalDetails";
      }
      @GetMapping("/education")
      public String getEducationDetails() {  
    	  return "education";
      }
      @GetMapping("/experience")
      public String getExperienceDetails() {
    	  return "experience";
      }
      @GetMapping("/skills")
      public String getSkills() {
    	  return "skill";
      }
      @GetMapping("/getResume")
      public String getResume(Model model,HttpSession session) {
    	  String email=(String) session.getAttribute("user_email");
    	  Optional<SignUser> user1=userRepository.findById(email);
    	  SignUser user=user1.get();
    		List<Jobs> jobs=jobService.findByUser(user);
    		model.addAttribute("jobs", jobs);
    	  model.addAttribute("user", user);
    	 return "resumedemo2";
      }
  	
}
