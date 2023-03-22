package com.javasm.bean;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class LoginUser {
    private Integer id;
    private String name;
    private String date;

    public LoginUser(Integer id, String name) {
        this.id = id;
        this.name = name;
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        this.date = format.format(date);

    }
}
