package com.kj.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/8/14 下午6:14
 * @description
 */
public class Md5Encrypt {

    /**
     * 对字符串进行MD5加密
     *
     * @param text 明文
     *
     * @return 密文
     */
    public static String md5(String text) {
        MessageDigest msgDigest = null;

        try {
            msgDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("System doesn't support MD5 algorithm.");
        }
        try {
            msgDigest.update(text.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] bytes = msgDigest.digest();
        byte tb;
        char low;
        char high;
        char tmpChar;
        String md5Str = new String();
        for (int i = 0; i < bytes.length; i++) {
            tb = bytes[i];
            tmpChar = (char) ((tb >>> 4) & 0x000f);
            if (tmpChar >= 10) {
                high = (char) (('a' + tmpChar) - 10);
            } else {
                high = (char) ('0' + tmpChar);
            }
            md5Str += high;
            tmpChar = (char) (tb & 0x000f);
            if (tmpChar >= 10) {
                low = (char) (('a' + tmpChar) - 10);
            } else {
                low = (char) ('0' + tmpChar);
            }
            md5Str += low;
        }
        return md5Str;
    }


    public static void main(String[] args) {


        String s = Md5Encrypt.md5("123456");

        System.out.println(s);



        Thread  thread = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("111111");

            }
        });


        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }







}
