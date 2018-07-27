package com.vmware.gtmboot.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vmware.gtmboot.mongo.Student;
import com.vmware.gtmboot.mongo.StudentRepository;
import com.vmware.gtmboot.service.ErrorResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/mongo/repo")
@Api(value="/api/mongo/repo")
public class StudentControllerWithMongoRepo {
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	private final StudentRepository studentRepository;

	public StudentControllerWithMongoRepo(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getStudentList",produces= MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "/getStudentList",notes = "Get Student List")
	public List<Student> getStudentList() {
		LOG.info("Start getStudentList() method in StudentControllerWithMongoRepo.class");
		List<Student> students = studentRepository.findAll();
		LOG.info("End getStudentList() method in StudentControllerWithMongoRepo.class");
		return students;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getStudent/{studentId}",produces= MediaType.APPLICATION_JSON_VALUE)
	public Object getStudentById(@PathVariable Integer studentId) {
		LOG.info("Start getStudentById() method in StudentControllerWithMongoRepo.class");
		Object stuObj;
		try {
			Optional<Student> student = studentRepository.findById(studentId);
			if(student != null)
				stuObj = student.get();
			else
				stuObj = new ErrorResponse();
		} catch (Exception e) {
			stuObj = new ErrorResponse();
		}
		LOG.info("End getStudentById() method in StudentControllerWithMongoRepo.class");
		return stuObj;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addStudent",produces= MediaType.APPLICATION_JSON_VALUE)
	public Student addStudent(@RequestBody Student student) {
		LOG.info("Start addStudent() method in StudentControllerWithMongoRepo.class");
		LOG.info("End addStudent() method in StudentControllerWithMongoRepo.class");
		return studentRepository.insert(student);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updateStudent/{studentId}",produces= MediaType.APPLICATION_JSON_VALUE)
	public Student updateStudent(@PathVariable int studentId, @RequestBody Student student) {
		LOG.info("Start updateStudent() method in StudentControllerWithMongoRepo.class");
		student.setStudentId(studentId);
		LOG.info("End updateStudent() method in StudentControllerWithMongoRepo.class");
		return studentRepository.save(student);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteStudent/{studentId}",produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Student> deleteStudent(@PathVariable int studentId) {
		LOG.info("Start deleteStudent() method in StudentControllerWithMongoRepo.class");
		studentRepository.deleteById(studentId);
		LOG.info("End deleteStudent() method in StudentControllerWithMongoRepo.class");
		return getStudentList();
	}
}
