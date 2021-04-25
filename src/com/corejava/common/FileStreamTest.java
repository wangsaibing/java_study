package com.corejava.common;

import java.io.*;

/**
 * Created by wangsaibing on 2020/10/23.
 */
public class FileStreamTest {

    public static void writeFile() throws IOException {
        try {
            byte bWrite[] = {11, 22, 33, 44, 55, 66};

            String fileName = "/Users/wangsaibing/code/hellow/src/test_file_write.txt";
            // write to file
            OutputStream os = new FileOutputStream(fileName);
            for (int i = 0; i < bWrite.length; i++) {
                System.out.println((char)bWrite[i] + " ");
                os.write(bWrite[i]);
            }
            os.close();

            // read from file
            InputStream is = new FileInputStream(fileName);
            int size = is.available();
            for (int i = 0; i < size; i++) {
                System.out.println((char)is.read() + " ");
            }
            is.close();

        } catch (IOException e) {

            System.out.print(e.getMessage());
            e.printStackTrace();
        }
    }
}