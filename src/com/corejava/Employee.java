package com.corejava;

/**
 * Created by wangsaibing on 2020/10/21.
 */
public class Employee {
    protected int age = 0;
    protected String name = "";
    protected String designation;

    protected double salary;

    private int _id;
    private static int _nextId = 1;


    public Employee() {}

    public Employee(String name) {
        this.name = name;
        this.setId();
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setId() {
        this._id = this._nextId;
        this._nextId++;
    }

    public int getId() {
        return this._id;
    }

    /**
     * get age
     * @return
     */
    public int getAge() {
        return this.age;
    }

    /**
     * set age
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * get name
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * set name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

}