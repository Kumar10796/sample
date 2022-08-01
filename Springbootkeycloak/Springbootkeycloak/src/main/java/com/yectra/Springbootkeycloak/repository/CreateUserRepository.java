package com.yectra.Springbootkeycloak.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yectra.Springbootkeycloak.model.CreateUser;

@Repository
public interface CreateUserRepository extends JpaRepository <CreateUser, Integer > {


	

	
	

    

}