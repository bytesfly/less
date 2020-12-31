package com.github.itwild.less.base.jvm;

public class Test1 {

    /*
    类加载时机：
    1. 遇到new、getstatic、putstatic或invokestatic这四条字节码指令
    （注意，newarray指令触发的只是数组类型本身的初始化，而不会导致其相关类型的初始化

    2. 使用java.lang.reflect包的方法对类进行反射调用的时候

    3. 当初始化一个类的时候，如果发现其父类还没有进行过初始化，则需要先触发其父类的初始化

    4. 当虚拟机启动时，用户需要指定一个要执行的主类（包含main()方法的那个类），虚拟机会先初始化这个主类


    */
    public static void main(String[] args) {

        // 此时并不会触发Entity类加载
        // SubEntity[] array = new SubEntity[10];

        // 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
        // 静态常量 不会触发类加载
        // String name1 = SubEntity.NAME;
        // String name2 = SubEntity.SUB_NAME;

        // 静态变量 会触发类加载

        // BaseEntity加载了
        // String desc1 = SubEntity.DESC;

        // BaseEntity加载了 SubEntity加载了
        // String desc2 = SubEntity.SUB_DESC;

        // https://www.jianshu.com/p/8a14ed0ed1e9

        // property1: BaseEntityDESC
        // System.out.println("property1: " + SubEntity.INSTANCE.getProperty1());
        // property2: null
        // System.out.println("property2: " + SubEntity.INSTANCE.getProperty2());

        // SubEntity subEntity = new SubEntity();
        // property1: BaseEntityDESC
        // System.out.println("property1: " + subEntity.getProperty1());
        // property2: BaseEntityName
        // System.out.println("property2: " + subEntity.getProperty2());
    }
}
