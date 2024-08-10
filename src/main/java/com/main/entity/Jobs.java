package com.main.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name="jobs")
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String jobSearch;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private SignUser user;

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobSearch() {
        return jobSearch;
    }

    public void setJobSearch(String jobSearch) {
        this.jobSearch = jobSearch;
    }

	public SignUser getUser() {
		return user;
	}

	public void setUser(SignUser user) {
		this.user = user;
	}
}