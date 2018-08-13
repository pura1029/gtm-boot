package com.vmware.boot.producer.model;

import java.util.Date;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Document(collection = "Student")
@Data
public class Student {

    @Indexed(unique = true)
    @Field(order = -1, value = "studentId")
    @AccessType(Type.PROPERTY)
    private int studentId;
    private String name;
    private int marks;
    private Date creationDate;
}
