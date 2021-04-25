package com.corejava.why;

import java.util.ArrayList;

/**
 * Created by wangsaibing on 21/3/6.
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("zhangsan",14,67));
        list.add(new Student("lisi",13,89));
        list.add(new Student("wangwu",15,97));
        list.add(new Student("maliu",12,63));
        list.add(new Student("zhaoqi",17,75));

        //Test.getStudentByFilter(list, new AgeFilter());
        Test.getStudentByFilter(list, new ScoreFilter());

    }

    public static void getStudentByFilter(ArrayList<Student> students, StudentFilter filter) {
        for (Student stu:students) {
            if (filter.compare(stu)) {
                System.out.println(stu);
            }
        }
    }
}
