package com.caozeal.sort;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class SelectPanel extends JPanel {

    private SortPanel panel;

    public SelectPanel(int[] elements) {
        JButton bubbleButton = new JButton("冒泡排序");
        this.add(bubbleButton);
        bubbleButton.addActionListener( (e) -> {
            BubbleSort sort = new BubbleSort(panel);
            sortAsync(elements, sort);

        });
        JButton insertionButton = new JButton("插入排序");
        this.add(insertionButton);
        insertionButton.addActionListener( (e) -> {
            InsertionSort sort = new InsertionSort(panel);
            sortAsync(elements, sort);

        });
        JButton selectionButton = new JButton("选择排序");
        this.add(selectionButton);
        selectionButton.addActionListener( (e) -> {
            SelectionSort sort = new SelectionSort(panel);
            sortAsync(elements, sort);

        });
    }

    private static void sortAsync(int[] elements, AbstractPanelSort sort) {
        Thread thread = new Thread(() -> sort.sort(elements));
        thread.start();
    }

    public void setPanel(SortPanel panel) {
        this.panel = panel;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
