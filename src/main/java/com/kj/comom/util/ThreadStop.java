package com.kj.comom.util;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/6/30 上午6:49
 * @description
 */
public class ThreadStop {

    public static void main(String[] args) {

        class MyThread extends Thread{

            private boolean stop;

            @Override
            public void run() {
                while (!stop){

                    System.out.println(Thread.currentThread().getName()+" is running");

                }
            }

            public void stopThread(){
                stop = true;
            }
        }

        MyThread thread = new MyThread();
        thread.setName("线程一");
        MyThread threadB = new MyThread();
        threadB.setName("线程二");

        thread.start();
        threadB.start();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.stopThread();

    }




}
