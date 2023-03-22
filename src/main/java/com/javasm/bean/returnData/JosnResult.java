package com.javasm.bean.returnData;

import lombok.Data;

@Data
public class JosnResult {
    private String message;
    private Integer code;
    public JosnResult(){
        this.code=200;
        this.message="代码正确";
    }

    public JosnResult(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
}
