package com.vmware.gtmboot;

import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vmware.gtmboot.dao.StudentDao;
import com.vmware.gtmboot.mongo.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryIntegrationTest {
	
	@Autowired
	private  StudentDao studentRepository;
	
	@Test
	public void testGetStudentList() {
		List<Student> students = studentRepository.getStudentList();
		assertThat(students.size(), is(greaterThanOrEqualTo(0)));
	}
}
