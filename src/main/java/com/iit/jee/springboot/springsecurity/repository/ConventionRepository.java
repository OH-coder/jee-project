package com.iit.jee.springboot.springsecurity.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.iit.jee.springboot.springsecurity.model.Convention;

import java.util.Date;
import java.util.List;

public interface ConventionRepository extends JpaRepository <Convention,Long>{
    public List<Convention> findByDateExpirationContains(Date date);
}
