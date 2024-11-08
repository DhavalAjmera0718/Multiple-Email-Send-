package com.example.Multi_Email.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Multi_Email.Entity.Email_Entity;



@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Email_Entity, Long>{

}
