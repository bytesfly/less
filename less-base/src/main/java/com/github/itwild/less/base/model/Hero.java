package com.github.itwild.less.base.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hero {

    private Long id;

    private String name;

    private Integer age;

    private String skill;

    private String book;

    private String author;
}
