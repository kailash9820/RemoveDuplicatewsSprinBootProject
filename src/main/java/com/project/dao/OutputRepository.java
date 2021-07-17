package com.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.entities.Output;
import com.project.entities.input_details;

public interface OutputRepository  extends CrudRepository<Output, Integer> {

	
}
