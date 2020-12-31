package com.github.itwild.less.base.jvm;

public class BaseEntity {

    static {
        System.out.println("BaseEntity加载了");
    }

    public static final String NAME = "BaseEntityName";

    public static String DESC = "BaseEntityDESC";

    protected Long id;

    protected String name;

    public Long getId() {
        return id;
    }

    public BaseEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BaseEntity setName(String name) {
        this.name = name;
        return this;
    }
}
