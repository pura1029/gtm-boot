package com.vmware.boot.consumer.dao;

import java.util.List;

import com.vmware.boot.consumer.model.Student;


public interface StudentDao {

    Student addStudent(Student student);

    Student updateStudent(int studentId, Student student);

    Object getStudent(int studentId);

    List<Student> getStudentList();

    List<Student> deleteStudent(int studentId);

}
