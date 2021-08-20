package me.ltxom.patientapp.backend.util;

public enum ResultCode {

    CODE_OK(200, "Success"),
    SIGN_ERROR(404, "Error"),
    NOT_EXIST(411, "Element DNE")
    ;

    private Integer code;
    private String msg;


    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    @Override
    public String toString() {
        return "code:" + code + ", msg" + msg;
    }
}
