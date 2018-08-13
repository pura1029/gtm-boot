package com.vmware.boot.producer.dao;

import java.util.List;

import com.vmware.boot.producer.model.Student;


public interface StudentDao {

    Student addStudent(Student student);

    Student updateStudent(int studentId, Student student);

    Object getStudent(int studentId);

    List<Student> getStudentList();

    List<Student> deleteStudent(int studentId);

}
