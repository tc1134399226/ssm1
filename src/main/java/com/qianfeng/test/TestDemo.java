package com.qianfeng.test;

import com.qianfeng.dto.UserIdsDTO;

import java.util.ArrayList;

public class TestDemo {
    public static void main(String[] args) {
        System.out.println("4");
        new TestDemo();
    }

    {
        System.out.println("1");
    }

    static {
        System.out.println("2");
    }

    public TestDemo() {
        System.out.println("3");
    }
}
