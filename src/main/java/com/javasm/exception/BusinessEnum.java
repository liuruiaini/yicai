package com.javasm.exception;




public enum BusinessEnum {
    PRIMETER_EXCEPTION(101,"参数异常"),
    INTERFACEOUTTIME_EXCEPTION(102,"接口调用超时异常"),
    AOP_EXCEPTION(103,"刚刚那个AOP异常了！！！");
    private BusinessEnum(Integer code,String message){
        this.code=code;
        this.message=message;
    }
    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
