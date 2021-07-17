package com.project.dao;

import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.project.entities.Output;
import com.project.entities.input_details;



public interface UserRepository extends CrudRepository<input_details, Integer> {

	
	@Query(value = "select * from input_details", nativeQuery = true)
	public List<input_details> getData();


	
}