package com.luban;

public class ClassLoaderDemo2 {

    static {
        System.out.println("---------------static---------------");
    }

    public static void main(String[] args) {
        new A();
        System.out.println("---------------test---------------");
        new B();
    }
}

class A{
    public A(){
        System.out.println("---------------A---------------");
    }
}

class B{
    public B() {
        System.out.println("---------------B---------------");
    }
}