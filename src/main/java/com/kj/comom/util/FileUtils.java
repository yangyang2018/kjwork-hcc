package com.kj.comom.util;

import java.io.*;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/9/3 下午9:35
 * @description
 */
public class FileUtils {


    public static void copyInputStreamToFile(InputStream inputStream,File file) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream  fileOutputStream = null;
        try {
            fileOutputStream =  new FileOutputStream(file);

            byte[] bytes=new byte[1024];    //每次读取1024字节
            int i=inputStream.read(bytes);
            while(i!=-1)
            {
                fileOutputStream.write(bytes,0,i);    //向E:\newStudent.txt文件中写入内容
                i=inputStream.read(bytes);
            }
            System.out.println("写入结束！");
        }finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }

    }
}
