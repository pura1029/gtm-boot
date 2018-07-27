package com.vmware.gtmboot;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.vmware.gtmboot.controller.StudentControllerWithMongoRepo;
import com.vmware.gtmboot.mongo.Student;
import com.vmware.gtmboot.mongo.StudentRepository;
import com.vmware.gtmboot.service.ErrorResponse;

public class StudentControllerWithMongoRepoTest {

	@InjectMocks
	private StudentControllerWithMongoRepo studentControllerRepo;

	@Mock
	private StudentRepository studentRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetStudentById() {
		Student student = new Student();
		student.setStudentId(56);
		Optional<Student> op = Optional.of(student);
		when(studentRepository.findById(56)).thenReturn(op);
		
		Object resObj = studentControllerRepo.getStudentById(56);
		if(resObj instanceof Student) {
			//assertEquals(56, ((Student)resObj).getStudentId());
			assertThat(((Student)resObj).getStudentId(), is(56));
		}else {
			assertEquals(400, ((ErrorResponse)resObj).getCode());
		}
	}
}
