package com.corejava.common;

import java.io.File;

/**
 * Created by wangsaibing on 2020/10/23.
 */
public class DirList {
    public static void listDir() {
        String dirName = "/tmp";
        File fl = new File(dirName);

        if (fl.isDirectory()) {
            System.out.println("目录" + dirName);

            String s[] = fl.list();
            for (int i = 0; i < s.length; i++) {
                File f = new File(dirName + '/' + s[i]);
                if (f.isDirectory()) {
                    System.out.println(s[i] + "是一个目录");
                } else {
                    System.out.println(s[i] + "是一个文件");
                }
            }
        } else {
            System.out.println(dirName + "不是一个目录");
        }
    }
}