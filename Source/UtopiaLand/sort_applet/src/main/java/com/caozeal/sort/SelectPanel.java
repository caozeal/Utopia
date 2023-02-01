package com.caozeal.sort;

import javax.swing.*;
import java.awt.*;

public class SelectPanel extends JPanel {

    private final int[] elements;

    private BubbleSort sort;

    public SelectPanel(int[] elements) {
        this.elements = elements;
        JButton bubbleButton = new JButton("冒泡排序");
        this.add(bubbleButton);
        bubbleButton.addActionListener( (e) -> {
            Thread thread = new Thread(() -> this.sort.sort(elements));
            thread.start();

        });
    }

    public void setSort(BubbleSort sort) {
        this.sort = sort;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
