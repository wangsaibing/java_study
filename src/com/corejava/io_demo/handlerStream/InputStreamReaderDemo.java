package com.corejava.io_demo.handlerStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by wangsaibing on 21/3/9.
 *
 * InputStreamReader是从字节流到字符流的桥：它读取字节，并使用指定的charset将其解码为字符 。
 * 它使用的字符集可以由名称指定，也可以被明确指定，或者可以接受平台的默认字符集
 */
public class InputStreamReaderDemo {

    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        try {
            fileInputStream = new FileInputStream("abc.txt");
            inputStreamReader = new InputStreamReader(fileInputStream);

            char[] chars = new char[12];
            int length = 0;
            while ((length = inputStreamReader.read(chars)) != -1) {
                System.out.println(new String(chars, 0, length));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
