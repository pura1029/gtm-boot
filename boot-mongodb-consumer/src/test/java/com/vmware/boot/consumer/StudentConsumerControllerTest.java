package com.vmware.boot.consumer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.vmware.boot.consumer.controller.StudentConsumerController;
import com.vmware.boot.consumer.dao.StudentDao;
import com.vmware.boot.consumer.model.Student;

public class StudentConsumerControllerTest {

    @InjectMocks
    private StudentConsumerController studentConsumerController;

    @Mock
    private StudentDao studentDao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetStudentById() {
        Student student = new Student();
        student.setStudentId(56);
        when(studentDao.getStudent(56)).thenReturn(student);

        Object resObj = studentConsumerController.getStudentById(56);
        //assertEquals(56, ((Student)resObj).getStudentId());
        assertThat(((Student) resObj).getStudentId(), is(56));
    }

    @Test
    public void testGetStudentList() {
        Student student = new Student();
        student.setStudentId(56);
        Student student1 = new Student();
        student.setStudentId(57);
        List<Student> listStu = new ArrayList<>();
        listStu.add(student);
        listStu.add(student1);
        when(studentDao.getStudentList()).thenReturn(listStu);

        List<Student> actuallistStu = studentConsumerController.getStudentList();
        assertThat(actuallistStu.size(), is(listStu.size()));
    }

    @Test
    public void testGetStudentById1() {
        Student student = new Student();
        student.setStudentId(56);
        when(studentDao.getStudent(56)).thenReturn(student);

        Object resObj = studentDao.getStudent(56);
        //assertEquals(56, ((Student)resObj).getStudentId());
        assertThat(((Student) resObj).getStudentId(), is(56));
    }

    @Test
    public void testGetStudentList1() {
        Student student = new Student();
        student.setStudentId(56);
        Student student1 = new Student();
        student.setStudentId(57);
        List<Student> listStu = new ArrayList<>();
        listStu.add(student);
        listStu.add(student1);
        when(studentDao.getStudentList()).thenReturn(listStu);

        List<Student> actuallistStu = studentDao.getStudentList();
        assertThat(actuallistStu.size(), is(listStu.size()));
    }
}
