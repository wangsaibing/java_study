package com.corejava.data_type;

/**
 * Created by wangsaibing on 21/3/8.
 */

public enum EventEnum {

    LAUNCH("launch"),PAGEVIEW("pageview"),EVENT("event");

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    EventEnum(String name) {

        this.name = name;
    }

    public void show() {
        System.out.println("----------"+this.name);
        EventEnum[] ee = this.values();
        for(int i = 0;i<ee.length;i++){
            System.out.println(ee[i]);
        }
    }

}
