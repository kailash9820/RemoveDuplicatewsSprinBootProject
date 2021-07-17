package com.project.entities;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="firstname_lastname_java_output")
public class Output {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	public String output;
	public int count;
	public String name;
	private String input;
	private java.sql.Timestamp publishedOn;
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public java.sql.Timestamp getPublishedOn() {
		return publishedOn;
	}
	public void setPublishedOn(java.sql.Timestamp publishedOn) {
		this.publishedOn = publishedOn;
	}
	
	
	public Output() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Output(int id, String output, int count, String name, String input, Timestamp publishedOn) {
		super();
		this.id = id;
		this.output = output;
		this.count = count;
		this.name = name;
		this.input = input;
		this.publishedOn = publishedOn;
	}
	@Override
	public String toString() {
		return "Output [id=" + id + ", output=" + output + ", count=" + count + ", name=" + name + ", publishedOn="
				+ publishedOn + "]";
	}
	
}
