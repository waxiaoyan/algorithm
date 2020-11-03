package com.strategy;

public class Singleton {
    //一、饿汉式
//    private static Singleton singleton = new Singleton();
//    public static Singleton getInstance() {
//        return singleton;
//    }
    private Singleton() {}


    //二、懒汉式
//    private static Singleton singleton;
//    public synchronized static Singleton getInstance() {
//        if(singleton == null) {
//            singleton = new Singleton();
//        }
//        return singleton;
//    }

    //三、双重检测,volatile防止指令重排，对象创建的步骤：1、 给singleton分配内存 2、执行构造函数 3、将singleton指向刚分配的内存
    //jdk1。5之后volatile的指令重排才完全修复
//    private static volatile Singleton singleton;
//    public static Singleton getInstance() {
//        if(singleton == null) {
//            synchronized (Singleton.class) {
//                singleton = new Singleton();
//            }
//        }
//        return singleton;
//    }

    //四、静态内部类, 加载外部内的时候，静态内部类不会被加载，只有当使用的时候才会被加载，利用内部类延迟加载机制

//    private static class Inner{
//        private static Singleton singleton = new Singleton();
//    }
//
//    public static Singleton getInstance() {
//        return Inner.singleton;
//    }

    //五、枚举
}
