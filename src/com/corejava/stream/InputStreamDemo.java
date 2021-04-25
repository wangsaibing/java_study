package com.corejava.stream;

/**
 * Created by wangsaibing on 21/3/2.
 */
import java.io.*;

/**
 * 在java中需要读写文件中的数据的话，需要使用流的概念
 *  流表示从一个文件将数据返送到另一个文件，包含一个流向的问题
 *      最终需要选择一个参照物：当前程序作为参照物
 *          从一个文件中读取数据到程序叫做输入流
 *          从程序输出数据到另一个文件叫做输出流
 *
 * 注意：当编写io流的程序的时候一定要注意关闭流
 *      步骤;
 *          1、选择合适的io流对象
 *          2、创建对象
 *          3、传输数据
 *          4、关闭流对象（占用系统资源）
 */
public class InputStreamDemo {
    public static void main(String[] args) {
//        InputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream("/Users/wangsaibing/code/hellow/abc.txt");
//            int read = inputStream.read();
//            System.out.println((char)read);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                inputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            inputStream = new FileInputStream("/Users/wangsaibing/code/hellow/abc.txt");
            bufferedInputStream = new BufferedInputStream(inputStream);

            byte[] buffer = new byte[1024];
            int length = 0;
//            while ((length = inputStream.read(buffer)) != -1) {
//                System.out.println(new String(buffer, 0, length));
//            }
            while ((length = bufferedInputStream.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, length));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

