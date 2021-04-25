package com.corejava.data_type;

/**
 * Created by wangsaibing on 21/3/8.
 */
public class Test {
    static Gender gender = Gender.女;
    static Gender gender2 = Gender.男;

    public static void main(String[] args) {
        //System.out.println(gender);

        EventEnum ee = EventEnum.LAUNCH;
        System.out.println("ee.LAUNCH-----"+ee);
        System.out.println("ee.getName-----"+ee.getName());
        ee.show();

        String name = EventEnum.PAGEVIEW.name();
        System.out.println(name);
    }
}