package com.vmware.gtmboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.vmware.gtmboot.mongo.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private MongoTemplate mongoTemplate;


	public StudentDaoImpl(MongoTemplate mongoTemplate) {
		super();
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		mongoTemplate.save(student);
		return student;
	}

	@Override
	public Student updateStudent(int studentId, Student student) {
		// TODO Auto-generated method stub
		student.setStudentId(studentId);
		mongoTemplate.save(student);
		return student;
	}

	@Override
	public Object getStudent(int studentId) {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("studentId").in(studentId));
		return mongoTemplate.findOne(query, Student.class);
	}

	@Override
	public List<Student> getStudentList() {
		return mongoTemplate.findAll(Student.class);
	}

	@Override
	public List<Student> deleteStudent(int studentId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("studentId").in(studentId));
		mongoTemplate.remove(query, Student.class);
		return getStudentList();
	}

	@Override
	public Object getStudentByName(String studentName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").in(studentName));
		return mongoTemplate.findOne(query, Student.class);
	}

}
