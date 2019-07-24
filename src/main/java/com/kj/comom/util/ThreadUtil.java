package com.kj.comom.util;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/6/27 上午6:27
 * @description
 */
public class ThreadUtil {


    public static void main(String[] args) {

        //中断方法
//        interrupt();

        //join
        join();


    }

    static  void join(){


        Thread mainThread = Thread.currentThread();
        Runnable r = new Runnable() {

            @Override
            public void run() {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("mainThread :"+mainThread.isInterrupted());
                System.out.println("哈哈哈"+Thread.currentThread().getName());

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread threadA = new Thread(r);
        threadA.start();
        try {

            threadA.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":"+Thread.interrupted());






    }


    static  void interrupt(){
        Runnable r = new Runnable() {
            @Override
            public void run() {

                String name = Thread.currentThread().getName();
                int count = 0;
                while(!Thread.interrupted()){
                    //验证当前线程是否已经中断，会清除中断状态
                    System.out.println(name +" : "+count++);
                }
                System.out.println("清除了中断状态:"+Thread.currentThread().isInterrupted());

            }
        };

        Thread threadA = new Thread(r);

        threadA.start();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //中断线程
        threadA.interrupt();

        System.out.println(threadA.isInterrupted());



        try {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }










}
