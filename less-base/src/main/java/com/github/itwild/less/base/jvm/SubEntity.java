package com.github.itwild.less.base.jvm;

public class SubEntity extends BaseEntity {

    public static final String SUB_NAME = NAME;

    public static String SUB_DESC = DESC;

    public static SubEntity INSTANCE = new SubEntity();

    private static String SUB_NAME_2 = new String(NAME);

    private String property1;
    private String property2;

    public SubEntity() {
        this.property1 = SUB_DESC;
        this.property2 = SUB_NAME_2;
    }

    static {
        System.out.println("SubEntity加载了");
    }

    public String getProperty1() {
        return property1;
    }

    public SubEntity setProperty1(String property1) {
        this.property1 = property1;
        return this;
    }

    public String getProperty2() {
        return property2;
    }

    public SubEntity setProperty2(String property2) {
        this.property2 = property2;
        return this;
    }
}
