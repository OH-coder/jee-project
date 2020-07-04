package com.iit.jee.springboot.springsecurity.repository;


import com.iit.jee.springboot.springsecurity.model.Convention;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface ConventionRepository extends JpaRepository <Convention,Long>{
    public Page<Convention> findAllBySignatureContains(Date dignature, Pageable pageable);

    public Page<Convention> findAllByObjetContainingOrTypeContaining(String objet, String type, Pageable pageable);






}
