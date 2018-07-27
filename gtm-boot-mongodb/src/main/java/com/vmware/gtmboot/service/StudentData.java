package com.vmware.gtmboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class StudentData {

	private static HashMap<Integer, Student> studentData = new HashMap<>();

	public static Student addStudent(Student student) {
		studentData.put(student.getId(), student);
		return student;
	}

	public static List<Student> getStudentList(){
		return studentData.values().stream().collect(Collectors.toList());
	}

	public static Object getStudent(int id){
		Student stu = studentData.get(id);
		return stu != null ? stu : new ErrorResponse();
	}

	public static List<Student> updateStudent(int id, Student student){
		studentData.put(id, student);
		return getStudentList();
	}

	public static List<Student> deleteStudent(int id){
		studentData.remove(id);
		return getStudentList();
	}
}
