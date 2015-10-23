package com.myapplication;

/**
 * Created by lilyxiao on 15/10/22.
 */
public class Person {
    private String name;
    private int age;
    private int icon;

    public Person(String name, int age, int icon){
        this.name  = name;
        this.age = age;
        this.icon = icon;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public int getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }
}
