package me.ltxom.patientapp.backend.util;


import java.io.Serializable;

public class ActionResult implements Serializable {
    private Integer code;
    private String message;
    private Object data;


    public static ActionResult genActionResult(ResultCode returnCode) {
        ActionResult actionResult = new ActionResult();
        actionResult.setCode(returnCode.getCode());
        actionResult.setMessage(returnCode.getMsg());
        return actionResult;
    }

    public static ActionResult genActionResultByOk() {
        ResultCode returnCode = ResultCode.CODE_OK;
        ActionResult actionResult = new ActionResult();
        actionResult.setCode(returnCode.getCode());
        actionResult.setMessage(returnCode.getMsg());
        return actionResult;
    }

    public static ActionResult genActionResultByOk(Object data) {
        ResultCode returnCode = ResultCode.CODE_OK;
        ActionResult actionResult = new ActionResult();
        actionResult.setCode(returnCode.getCode());
        actionResult.setMessage(returnCode.getMsg());
        actionResult.setData(data);
        return actionResult;
    }

    public static ActionResult genActionResultByOk(ResultCode resultCode, Object data) {
        ResultCode returnCode = resultCode;
        ActionResult actionResult = new ActionResult();
        actionResult.setCode(returnCode.getCode());
        actionResult.setMessage(returnCode.getMsg());
        actionResult.setData(data);
        return actionResult;
    }

    public static ActionResult genActionResult(ResultCode returnCode, Object data) {
        ActionResult actionResult = new ActionResult();
        actionResult.setCode(returnCode.getCode());
        actionResult.setMessage(returnCode.getMsg());
        actionResult.setData(data);
        return actionResult;
    }


    public static ActionResult genActionResultWithMsgData(ResultCode returnCode, Object... msgData) {
        ActionResult actionResult = new ActionResult();
        actionResult.setCode(returnCode.getCode());
        if (msgData != null && msgData.length > 0 && returnCode.getMsg() != null) {
            actionResult.setMessage(String.format(returnCode.getMsg(), msgData));
        } else {
            actionResult.setMessage(returnCode.getMsg());
        }
        return actionResult;
    }

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}

