package com.tencent.wxcloudrun.exception;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = -3294888964903029991L;
    private final String errorCode;
    private Throwable cause;
    private String[] args;

    public BusinessException(String errCode) {
        super(errCode);
        this.errorCode = errCode;
    }

    public BusinessException(String errCode, Throwable cause, String... args) {
        super(errCode, cause);
        this.errorCode = errCode;
        this.cause = cause;
        if (args != null) {
            this.args = (String[])args.clone();
        }

    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public Throwable getCause() {
        return this.cause;
    }

    public String[] getArgs() {
        String[] result = null;
        if (this.args != null) {
            result = (String[])this.args.clone();
        }

        return result;
    }
}
