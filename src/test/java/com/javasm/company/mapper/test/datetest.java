package com.javasm.company.mapper.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class datetest {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format);



    }
}
