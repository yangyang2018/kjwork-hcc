package com.kj.comom.util;

import java.math.BigDecimal;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/6/29 下午5:13
 * @description
 */
public class ThreadDemo {

    private static BigDecimal result = null;

    private static Object object = new Object();//控制访问临界区的时候是同步的


    public static void main(String[] args) {


        Runnable r = ()->{

            synchronized (object){
                System.out.println("进入子线程。。。。");
                result = computePi(50000);

            }
        };


        Thread t = new Thread(r);
        t.start();


        synchronized (object){
            System.out.println(result);
        }

//        try {
//            t.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("主线程结束了。。。。");

    }

    private static BigDecimal computePi(int i) {

        return new BigDecimal(i);

    }


}
