package com.caozeal.sort;

import javax.swing.*;
import java.awt.*;

public class PanelMain {

    public static void main(String[] args) {
        SortFrame frame = new SortFrame();
        int[] elements = {1, 3, 3, 2, 9, 8, 1, 10, 6, 5, 2};
        SelectPanel selectPanel = new SelectPanel(elements);
        frame.add(selectPanel, BorderLayout.NORTH);

        SortPanel panel = new SortPanel(elements);
        frame.add(panel, BorderLayout.CENTER);

        frame.setSize(1000, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        selectPanel.setPanel(panel);
    }
}
