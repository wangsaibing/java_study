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
public class StreamDemo3 {
    public static void main(String[] args) {
        InputStream inputStream = null;
        DataInputStream dataInputStream = null;
        OutputStream outputStream = null;
        DataOutputStream dataOutputStream = null;

        String filePath = "/Users/wangsaibing/code/hellow/data.txt";
        try {
            outputStream = new FileOutputStream(filePath);
            dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeInt(123);
            dataOutputStream.writeUTF("abcdefg");
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeUTF("王赛兵");

            inputStream = new FileInputStream(filePath);
            dataInputStream = new DataInputStream(inputStream);
            System.out.println(dataInputStream.readInt());
            System.out.println(dataInputStream.readUTF());
            System.out.println(dataInputStream.readBoolean());
            System.out.println(dataInputStream.readUTF());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dataInputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}

