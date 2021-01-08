package com.github.itwild.less.springboot.controller;

import com.github.itwild.less.springboot.model.Result;
import com.github.itwild.less.springboot.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeroController extends BaseController {

    @Autowired
    private HeroService heroService;

    @GetMapping("hero/{id}")
    public Result queryById(@PathVariable("id") Long id) {
        return success(heroService.getById(id));
    }
}
