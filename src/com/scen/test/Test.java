package com.scen.test;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * 单元测试
 * Created by scen on 2017/4/25.
 */
public class Test {
    public Test(){
        System.out.println("构造方法随类的实例化");
    }
    public void t1(){
        System.out.println("普通方法调用才执行");
    }
    public static void main(String[] args) {
          Test t=new Test();
          t.t1();
    }
}
