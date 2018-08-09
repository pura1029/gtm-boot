package com.vmware.boot.consumer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vmware.boot.consumer.dao.StudentDao;
import com.vmware.boot.consumer.model.ErrorResponse;
import com.vmware.boot.consumer.model.Student;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/api")
@Api(value="/api")
public class StudentConsumerController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final StudentDao studentRepository;

	public StudentConsumerController(StudentDao studentRepository) {
		this.studentRepository = studentRepository;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/student/list",produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getStudentList() {
		logger.info("Start getStudentList() method in StudentConsumerController.class");
		logger.info("End getStudentList() method in StudentConsumerController.class");
		return (studentRepository.getStudentList());
	}

	@RequestMapping(method = RequestMethod.GET, value = "/student/{studentId}",produces= MediaType.APPLICATION_JSON_VALUE)
	public Object getStudentById(@PathVariable Integer studentId) {
		logger.info("Start getStudentById() method in StudentConsumerController.class");
		Object stuObj;
		try {
			stuObj = studentRepository.getStudent(studentId);
			if(stuObj != null)
				return stuObj;
			else 
				return new ErrorResponse();
		} catch (Exception e) {
			return new ErrorResponse();
		}
	}
}
