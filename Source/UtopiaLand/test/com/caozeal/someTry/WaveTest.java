package com.caozeal.sometry;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class WaveTest {

    private int[] wavePoints = {5, 10, 20, 10, -5, 6, 6, 25, 3, 3, -6, -6, -10, 30, 5, 5, 15};
    private Wave wave;

    @Before
    public void before(){
        wave = new Wave(wavePoints);
    }

    @Test
    public void When20ThenCrest(){
        Point p = new Point(2, 20);
        Assert.assertTrue(wave.getCrestPoints().contains(p));
    }

    @Test
    public void When5ThenThrough(){
        Point p = new Point(14, 5);
        Assert.assertTrue(wave.getThroughPoints().contains(p));
    }

    @Test
    public void when5And6ThenNotCrest(){
        Point p = new Point(5, 6);
        Assert.assertFalse(wave.getCrestPoints().contains(p));
    }

    @Test
    public void printTest() {
        System.out.println("CrestPoints: ");
        for(Point p1 : wave.getCrestPoints()){
            System.out.println(p1.toString());
        }
        System.out.println("ThroughPoints: ");
        for(Point p2 : wave.getThroughPoints()){
            System.out.println(p2.toString());
        }
    }

}
