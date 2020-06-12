package com.iit.jee.Conventions.Dao;

import com.iit.jee.Conventions.entities.Convention;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ConventionRepository extends JpaRepository <Convention,Long>{
    public List<Convention> findByDateExpirationContains(Date date);
}
