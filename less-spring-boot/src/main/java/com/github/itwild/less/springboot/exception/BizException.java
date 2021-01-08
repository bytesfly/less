package com.github.itwild.less.springboot.exception;

import com.github.itwild.less.springboot.consts.ResultCode;
import lombok.Getter;

public class BizException extends RuntimeException {
    @Getter
    private final String code;

    @Getter
    private final String message;

    public BizException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BizException(String message) {
        super(message);
        this.code = ResultCode.UNDEFINED;
        this.message = message;
    }

    public BizException(Throwable throwable) {
        super(throwable);
        this.code = ResultCode.UNDEFINED;
        this.message = throwable.getMessage();
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
        this.code = ResultCode.UNDEFINED;
        this.message = message;
    }
}
