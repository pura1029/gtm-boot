package com.vmware.boot.producer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vmware.boot.producer.dao.StudentDao;
import com.vmware.boot.producer.model.Student;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/api")
@Api(value="/api")
public class StudentProducerController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final StudentDao studentRepository;

	public StudentProducerController(StudentDao studentRepository) {
		this.studentRepository = studentRepository;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/student/add",produces= MediaType.APPLICATION_JSON_VALUE)
	public Student addStudent(@RequestBody Student student) {
		logger.info("Start addStudent() method in StudentControllerWithMongoTemplate.class");
		logger.info("End addStudent() method in StudentControllerWithMongoTemplate.class");
		return studentRepository.addStudent(student);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/student/{studentId}",produces= MediaType.APPLICATION_JSON_VALUE)
	public Student updateStudent(@PathVariable int studentId, @RequestBody Student student) {
		logger.info("Start updateStudent() method in StudentControllerWithMongoTemplate.class");
		logger.info("End updateStudent() method in StudentControllerWithMongoTemplate.class");
		return studentRepository.updateStudent(studentId, student);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/student/{studentId}",produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Student> deleteStudent(@PathVariable int studentId) {
		logger.info("Start deleteStudent() method in StudentControllerWithMongoTemplate.class");
		logger.info("End deleteStudent() method in StudentControllerWithMongoTemplate.class");
		return studentRepository.deleteStudent(studentId);
	}
}
