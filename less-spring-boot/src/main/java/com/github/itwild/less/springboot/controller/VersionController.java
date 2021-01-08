package com.github.itwild.less.springboot.controller;

import com.github.itwild.less.springboot.model.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController extends BaseController {

    @GetMapping("version")
    public Result version() {
        return success("v1.0.0");
    }
}
