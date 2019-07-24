package com.kj.comom.util;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/6/30 上午9:37
 * @description
 */
public class JoinNotifyDemo {


    public static void main(String[] args) {

        SharedMessage message = new SharedMessage();
        Producer producer = new Producer(message);
        Consumer consumer = new Consumer(message);
        producer.start();
        consumer.start();

    }

}

class  SharedMessage{

    private volatile Queue<String> news = new ConcurrentLinkedDeque<>();

    synchronized void produceNews(String messsge){
        while (news.size() > 0){
            //满足条件的时候，让当前线程一直等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //具体的操作
        news.add(messsge);
        System.out.println("produceNews : "+messsge);
        notify();
    }

    synchronized String  consumeNews(){

        if (news.size() <= 0){
            //满足条件的时候，让当前线程一直等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String messsge = news.remove();
        System.out.println("consumeNews : "+messsge);
        //具体的操作
        notify();
        return  messsge;
    }
}

class Producer extends Thread {

    private AtomicInteger integer = new AtomicInteger(0);

    private SharedMessage sharedMessage;

    public Producer(SharedMessage sharedMessage) {
        this.sharedMessage = sharedMessage;
    }

    @Override
    public void run(){
        while (true){
            sharedMessage.produceNews(Thread.currentThread().getName()+":"+integer.incrementAndGet());
        }
    }
}


class Consumer extends Thread {

    private SharedMessage sharedMessage;

    public Consumer(SharedMessage sharedMessage) {
        this.sharedMessage = sharedMessage;
    }

    @Override
    public void run(){
        while (true){
            sharedMessage.consumeNews();
        }
    }
}



