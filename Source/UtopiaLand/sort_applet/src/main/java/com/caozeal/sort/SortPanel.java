package com.caozeal.sort;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

class SortPanel extends JPanel implements Runnable {

    private final int[] elements;

    private int current = 0;

    private Set<Integer> sorted;

    public void setCurrent(int current) {
        this.current = current;
    }

    public Set<Integer> getSorted() {
        return sorted;
    }

    public SortPanel(int[] elements) {
        this.elements = elements;
        sorted = new HashSet<>();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int x = 50;
        for (int i = 0; i < elements.length; i++) {
            if (i == current) {
                g.setColor(Color.PINK);
                g.drawOval(x - 5, 35, 20, 20);
            }
            if(sorted.contains(i)){
                g.setColor(Color.GREEN);
//                g.drawRect(x - 5, 35, 20, 20);
            } else {
                g.setColor(Color.BLACK);
            }
            g.drawString(String.valueOf(elements[i]), x, 50);
            x += 50;
        }
    }

    @Override
    public void run() {
        repaint();
    }
}
