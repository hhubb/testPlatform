package com.icode.testplatform.dto;

public class BasicResponseDTO {
    /**
     * 响应码
     */
    private int code;
    /**
     * 响应信息
     */
    private String message;
    /**
     * 是否成功
     */
    private boolean isSuccess;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
