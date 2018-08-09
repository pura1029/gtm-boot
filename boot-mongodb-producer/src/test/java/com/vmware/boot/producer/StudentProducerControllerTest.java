package com.vmware.boot.producer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.vmware.boot.producer.controller.StudentProducerController;
import com.vmware.boot.producer.dao.StudentDao;
import com.vmware.boot.producer.model.ErrorResponse;
import com.vmware.boot.producer.model.Student;

public class StudentProducerControllerTest {

	@InjectMocks
	private StudentProducerController studentProducerController;

	@Mock
	private StudentDao studentDao;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddStudent() {
		Student student = new Student();
		student.setStudentId(56);
		student.setName("Ram");
		student.setMarks(78);
		when(studentDao.addStudent(student)).thenReturn(student);
		
		Object resObj = studentProducerController.addStudent(student);
		if(resObj instanceof Student) {
			//assertEquals(56, ((Student)resObj).getStudentId());
			assertThat(((Student)resObj).getStudentId(), is(56));
		}else {
			assertEquals(400, ((ErrorResponse)resObj).getCode());
		}
	}
}
