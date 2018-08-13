package com.vmware.boot.consumer.model;

import java.util.Date;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "Student")
@Setter
@Getter
public class Student {

    @Indexed(unique = true)
    @Field(order = -1, value = "studentId")
    @AccessType(Type.PROPERTY)
    private int studentId;
    private String name;
    private int marks;
    private Date creationDate;
}
