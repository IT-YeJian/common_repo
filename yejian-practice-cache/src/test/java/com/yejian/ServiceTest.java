package com.yejian;

/**
 * @Name: ServiceTest
 * @Description: TODO
 * @Version: V1.0.0
 * @Author: yejian
 * @Create Date: 2022-08-13
// */
//@RunWith(Springrun)
public class ServiceTest {

    public static void main(String[] args) {
        Thread thread=null;
        ServiceTest test = new ServiceTest();
        for (int i = 0; i < 5; i++) {
            thread = new Thread(()->{
                test.say();
            });
            thread.start();
        }
    }

    public synchronized void say(){
        try {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
