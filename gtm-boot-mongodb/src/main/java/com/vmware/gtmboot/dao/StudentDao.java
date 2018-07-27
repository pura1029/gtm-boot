package com.vmware.gtmboot.dao;

import java.util.List;

import com.vmware.gtmboot.mongo.Student;


public interface StudentDao {
	
	Student addStudent(Student student);
	Student updateStudent(int studentId, Student student);
	Object getStudent(int studentId);
	List<Student> getStudentList();
	List<Student> deleteStudent(int studentId);

}
