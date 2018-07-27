package com.vmware.gtmboot.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vmware.gtmboot.service.Student;
import com.vmware.gtmboot.service.StudentData;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/api")
@Api(value="/api")
public class StudentController {

	@RequestMapping(method = RequestMethod.GET, value = "/getStudentList",produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getStudentList() {
		return StudentData.getStudentList();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getStudent/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
	public Object getStudentList(@PathVariable int id) {
		return StudentData.getStudent(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addStudent",produces= MediaType.APPLICATION_JSON_VALUE)
	public Student addStudent(@RequestBody Student student) {
		return StudentData.addStudent(student);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/updateStudent/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
		return StudentData.updateStudent(id, student);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteStudent/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Student> deleteStudent(@PathVariable int id) {
		return StudentData.deleteStudent(id);
	}
}
