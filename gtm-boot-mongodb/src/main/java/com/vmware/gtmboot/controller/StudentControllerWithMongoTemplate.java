package com.vmware.gtmboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vmware.gtmboot.dao.StudentDao;
import com.vmware.gtmboot.mongo.Student;
import com.vmware.gtmboot.service.ErrorResponse;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/api/mongo/templ")
@Api(value="/api/mongo/templ")
public class StudentControllerWithMongoTemplate {
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	private final StudentDao studentRepository;

	public StudentControllerWithMongoTemplate(StudentDao studentRepository) {
		this.studentRepository = studentRepository;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getStudentList",produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getStudentList() {
		LOG.info("Start getStudentList() method in StudentControllerWithMongoTemplate.class");
		List<Student> students = studentRepository.getStudentList();
		LOG.info("End getStudentList() method in StudentControllerWithMongoTemplate.class");
		return students;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getStudent/{studentId}",produces= MediaType.APPLICATION_JSON_VALUE)
	public Object getStudentById(@PathVariable Integer studentId) {
		LOG.info("Start getStudentById() method in StudentControllerWithMongoTemplate.class");
		Object stuObj;
		try {
			stuObj = studentRepository.getStudent(studentId);
			if(stuObj == null)
				stuObj = new ErrorResponse();
		} catch (Exception e) {
			stuObj = new ErrorResponse();
		}
		LOG.info("End getStudentById() method in StudentControllerWithMongoTemplate.class");
		return stuObj;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addStudent",produces= MediaType.APPLICATION_JSON_VALUE)
	public Student addStudent(@RequestBody Student student) {
		LOG.info("Start addStudent() method in StudentControllerWithMongoTemplate.class");
		LOG.info("End addStudent() method in StudentControllerWithMongoTemplate.class");
		return studentRepository.addStudent(student);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updateStudent/{studentId}",produces= MediaType.APPLICATION_JSON_VALUE)
	public Student updateStudent(@PathVariable int studentId, @RequestBody Student student) {
		LOG.info("Start updateStudent() method in StudentControllerWithMongoTemplate.class");
		LOG.info("End updateStudent() method in StudentControllerWithMongoTemplate.class");
		return studentRepository.updateStudent(studentId, student);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteStudent/{studentId}",produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Student> deleteStudent(@PathVariable int studentId) {
		LOG.info("Start deleteStudent() method in StudentControllerWithMongoTemplate.class");
		LOG.info("End deleteStudent() method in StudentControllerWithMongoTemplate.class");
		return studentRepository.deleteStudent(studentId);
	}
}
