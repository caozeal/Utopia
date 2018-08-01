package com.caozeal.practice;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TryAboutFather {

    protected String lastName;

    private String homeTown;

    public TryAboutFather() {
        System.out.println("父类无参构造");
    }

    TryAboutFather(String lastName) {
        this.lastName = lastName;
        System.out.println("父类有参构造");
    }

    {
        System.out.println("父类块");
    }

    static {
        System.out.println("父类静态块");
    }

    public static void method() {
        System.out.println("父类方法");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c = Class.forName("com.caozeal.practice.TryAboutFather");
        Constructor constructor = c.getConstructor(String.class);
        TryAboutFather father = (TryAboutFather) constructor.newInstance("sss");
    }
}
