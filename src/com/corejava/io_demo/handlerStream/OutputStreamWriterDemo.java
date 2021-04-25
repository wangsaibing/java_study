package com.corejava.io_demo.handlerStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by wangsaibing on 21/3/9.
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) {
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fileOutputStream = null;


        try {
            long time = System.currentTimeMillis();
            fileOutputStream = new FileOutputStream("abc.txt");
            outputStreamWriter = new OutputStreamWriter(fileOutputStream,"utf-8");
            outputStreamWriter.write(99);
            outputStreamWriter.write("马士兵教育");
            outputStreamWriter.write("abcdefg",0,5);
            long end = System.currentTimeMillis();
            System.out.println(end-time);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭流对象的时候，建议按照创建的顺序的逆序来进行关闭
            try {
                outputStreamWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
