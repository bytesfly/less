package com.github.itwild.less.springboot.controller;

import com.github.itwild.less.springboot.consts.ResultCode;
import com.github.itwild.less.springboot.consts.ResultMessage;
import com.github.itwild.less.springboot.exception.BizException;
import com.github.itwild.less.springboot.model.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BaseController {

    public static Result success() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(ResultMessage.SUCCESS);
    }

    public static Result success(Object entity) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(ResultMessage.SUCCESS)
                .setEntity(entity);
    }

    public static Result success(Object entity, Long totalCount) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(ResultCode.SUCCESS)
                .setEntity(entity)
                .setTotal(totalCount);
    }

    public static Result fail(String code, String message) {
        return new Result()
                .setCode(code)
                .setMessage(message);
    }

    public static Result fail(BizException e) {
        return new Result()
                .setCode(e.getCode())
                .setMessage(e.getMessage());
    }
}
