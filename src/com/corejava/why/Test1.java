package com.corejava.why;

import java.util.ArrayList;

/**
 * Created by wangsaibing on 21/3/6.
 */
public class Test1 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("zhangsan",14,67));
        list.add(new Student("lisi",13,89));
        list.add(new Student("wangwu",15,97));
        list.add(new Student("maliu",12,63));
        list.add(new Student("zhaoqi",17,75));

        Test.getStudentByFilter(list, new StudentFilter() {
            @Override
            public boolean compare(Student student) {
                return student.getAge() > 14;
            }
        });
        Test1.getStudentByFilter(list, new StudentFilter() {
            @Override
            public boolean compare(Student student) {
                return student.getScore() > 75;
            }
        });
        Test1.getStudentByFilter(list, new StudentFilter() {
            @Override
            public boolean compare(Student student) {
                return student.getName().length() > 5;
            }
        });

    }

    public static void getStudentByFilter(ArrayList<Student> students, StudentFilter filter) {
        for (Student stu:students) {
            if (filter.compare(stu)) {
                System.out.println(stu);
            }
        }
    }
}
