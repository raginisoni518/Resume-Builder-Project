package com.main.controller;


import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.main.entity.SignUser;
import com.main.repository.UserRepository;
import com.main.service.Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/resume")
public class Controller2 {
	@Autowired
	UserRepository userRepository;
	@Autowired
	Service service;

	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestBody SignUser user) {
		Optional<SignUser> user2 = userRepository.findById(user.getEmail());
		if (user2.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(Map.of("message", "Email exist already"));

		} else {
			
			userRepository.save(user);
			return ResponseEntity.ok().build();
            
		}
	}

	@PostMapping("/check")
	public ResponseEntity<?> checkUser(@RequestBody SignUser user2, HttpSession session) {
		Optional<SignUser> user1 = userRepository.findById(user2.getEmail());
		SignUser user=user1.get();
		if (user1.isPresent() && user.getPassword().equals(user2.getPassword())) {
			session.setAttribute("user_email", user.getEmail());
			System.out.println(userRepository.findById(user.getEmail()));
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(Map.of("message", "incorrect email or password"));
		}
	}

	@PatchMapping("/update")
	public ResponseEntity<?> updatePersonalDetails(@RequestBody Map<String,Object> fields,HttpSession session) {	
		if (session.getAttribute("user_email") != null) {
			String email=(String) session.getAttribute("user_email");
			session.setAttribute("user_email", email);
			SignUser user=service.update(email, fields);
			userRepository.save(user);
			System.out.println(userRepository.findById(email));
			
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(Map.of("message", "Email does not exist. Please provide a valid email."));
		}
	}

	@PatchMapping("/updateEducation")
	public ResponseEntity<?> updateEducationDetails(@RequestBody Map<String,Object> fields,HttpSession session) {	
		if (session.getAttribute("user_email") != null) {
			String email=(String) session.getAttribute("user_email");
			session.setAttribute("user_email", email);
			SignUser user=service.update(email, fields);
			userRepository.save(user);
			System.out.println(userRepository.findById(email));
			return ResponseEntity.ok().build();
		} 
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(Map.of("message", "Email does not exist. Please provide a valid email."));
		}
	}
	@PatchMapping("/updateExperience")
	public ResponseEntity<?> updateExperienceDetails(@RequestBody Map<String,Object> fields,HttpSession session) {	
		if (session.getAttribute("user_email") != null) {
			String email=(String) session.getAttribute("user_email");
			session.setAttribute("user_email", email);
			SignUser user=service.update(email, fields);
			userRepository.save(user);
			System.out.println(userRepository.findById(email));
			return ResponseEntity.ok().build();
		} 
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(Map.of("message", "Email does not exist. Please provide a valid email."));
		}
	}
}
