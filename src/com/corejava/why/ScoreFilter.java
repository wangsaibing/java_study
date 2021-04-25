package com.corejava.why;

/**
 * Created by wangsaibing on 21/3/6.
 */
public class ScoreFilter implements StudentFilter {
    public boolean compare(Student student) {
        return (student.getScore() > 75);
    }
}
