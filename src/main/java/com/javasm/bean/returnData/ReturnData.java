package com.javasm.bean.returnData;

import lombok.Data;

@Data
public class ReturnData<T> {
    private String message;
    private Integer code;
    private T t;
}
