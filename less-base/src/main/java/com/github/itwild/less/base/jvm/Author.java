package com.github.itwild.less.base.jvm;

public class Author {

    public Long id;

    public String name;

    public Integer age;

    public Author(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
