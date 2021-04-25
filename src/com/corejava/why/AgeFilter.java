package com.corejava.why;

/**
 * Created by wangsaibing on 21/3/6.
 */
public class AgeFilter implements StudentFilter {
    public boolean compare(Student student) {
        return (student.getAge() > 14);
    }
}
