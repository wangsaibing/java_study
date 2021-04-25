package com.corejava;

import java.io.File;
import java.io.IOException;


/**
 * Created by wangsaibing on 21/3/1.
 */
public class FileDemo {

    public static void main(String[] args) {
        File file = new File("/Users/wangsaibing/code/hellow");
        final File[] files = file.listFiles();
        for (File f: files) {
            System.out.println(f.getAbsoluteFile());
            System.out.println(f.isDirectory());
            System.out.println(f.isFile());
        }


        File file1 = new File("/Users/wangsaibing/code/hellow/abc.log");
        try {
            file1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        final File[] files2 = File.listRoots();
        for (int i = 0; i < files2.length; i++) {
            System.out.println(files2[i]);
        }

        File file3 = new File("/Users/wangsaibing/code/hellow/aa/bb/cc");
        file3.mkdirs();
    }

}
