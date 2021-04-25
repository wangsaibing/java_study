package com.corejava.c2_classloader;

public class T001_ClassLoadingProcedure {
    public static void main(String[] args) {
        System.out.println(com.corejava.c2_classloader.T.count);
    }
}

class T {
    public static com.corejava.c2_classloader.T t = new com.corejava.c2_classloader.T(); // null
    public static int count = 2; //0

    //private int m = 8;

    private T() {
        count ++;
        System.out.println("--" + count);
    }
}
