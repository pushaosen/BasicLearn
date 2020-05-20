package com.luban;

public class ClassLoaderDemo {

    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
//        System.out.println(DESKeyFactory.class.getClassLoader().getClass().getName());
        System.out.println(ClassLoaderDemo.class.getClassLoader().getClass().getName());
        System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());
    }

}
