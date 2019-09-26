package com.kj.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/9/4 下午10:31
 * @description
 * 控制多线程的执行顺序
 * 1 ----join()
 * 2 ----Executor.newSingleThreadExecutor()
 *
 */
public class ExecutorUtil {

    static ExecutorService executorService;

    static {

        executorService = Executors.newSingleThreadExecutor();

    }



    public static void main(String[] args) {


        Thread thread4 = new Thread() {
            @Override
            public void run() {

                System.out.println("run .....");
            }
        };




        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(String.format("%s ....",Thread.currentThread().getName()));
            }
        },"thread1");


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(String.format("%s ....",Thread.currentThread().getName()));
            }
        },"thread2");


        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(String.format("%s ....",Thread.currentThread().getName()));
            }
        },"thread3");



        executorService.submit(thread1);
        executorService.submit(thread2);
        executorService.submit(thread3);
        executorService.submit(thread4);


        executorService.shutdown();

    }





}
