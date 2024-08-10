package com.main.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.entity.Jobs;
import com.main.entity.SignUser;

import java.util.List;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, Integer> {
   public List<Jobs> findByUser(SignUser user);
}