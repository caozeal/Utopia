package com.caozeal.practice.concurrent.odevity;

import com.caozeal.practice.TryAboutFather;

import java.rmi.MarshalledObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>创建时间：2019/3/14 13:42
 * <p>com.writ.practice.concurrent.odevity
 * @author caozhiyong
 * @version 1.0
 */
public class OdevityMain2 {
    static class SolutionTask implements Runnable {
        static int value = 0;

        @Override
        public void run() {
            synchronized (SolutionTask.class) {
                while (value <= 100) {
                    System.out.println(Thread.currentThread().getName() + "： " + value++);
                    SolutionTask.class.notify();
                    try {
                        SolutionTask.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                SolutionTask.class.notify();
            }
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        Map<String, String> map = new HashMap<>();
        map.put("a", "A");
        map.put("b", "B");
        map.put("c", "C");
        map.put("d", "D");
        map.put("e", "E");
        new Thread(new SolutionTask(), "偶线程").start();
        new Thread(new SolutionTask(), "奇线程").start();
        Stream.generate(list::toArray).forEach(System.out::println);
        list.forEach(System.out::println);
        list.forEach(String::length);
        map.forEach(String::compareTo);
        list.stream().sorted(String::compareTo).forEach(System.out::println);
//        List<TryAboutFather> people = list.stream().map(TryAboutFather::new).collect(Collectors.toList());
    }
}