package com.vmware.boot.consumer.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorResponse {

    private int code;
    private String desc;

    public ErrorResponse() {
        this.code = 400;
        this.desc = "Student data not found!";
    }

}
