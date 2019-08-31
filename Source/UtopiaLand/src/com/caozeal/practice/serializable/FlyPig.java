package com.caozeal.practice.serializable;

import java.io.Serializable;

/**
 * <p>创建时间：2018/8/31 11:08
 * <p>com.writ.practice.serializable
 * @author caozhiyong
 * @version 1.0
 */
public class FlyPig implements Serializable {

    private static String AGE = "269";
    private String name;
    private String color;
    transient private String car;

    @Override
    public String toString() {
        return "FlyPig{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", car='" + car + '\'' +
                ", AGE='" + AGE + '\'' +
                '}';
    }

    public static String getAGE() {
        return AGE;
    }

    public static void setAGE(String AGE) {
        FlyPig.AGE = AGE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }
}
