package com.luban;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OutOfMemoryDump {

    /**
     *  设置JVM参数
     *  -Xms10m
     *  -Xmx10m
     *  -XX:+PrintGCDetails
     *  -XX:+HeapDumpOnOutOfMemoryError
     *  -XX:HeapDumpPath=路径
     */
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        int i = 0;
        while(true){
            list.add(new User(i++,UUID.randomUUID().toString()));
        }
    }

}
