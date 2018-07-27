package com.vmware.gtmboot.mongo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Student")
public class Student {

	@Indexed(unique=true)
	@Field(order = -1, value = "studentId")
	@AccessType(Type.PROPERTY)
	private int studentId;
	private String name;
	private int marks;
	private Date creationDate;
	
	public Student() {
		super();
	}
	
	
	
	public int getStudentId() {
		return studentId;
	}

	@Required
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getMarks() {
		return marks;
	}
	
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = new Date();
	}

	@Override
	public String toString() {
		return "Student [id=" + studentId + ", name=" + name + ", marks=" + marks + "]";
	}
	
}
