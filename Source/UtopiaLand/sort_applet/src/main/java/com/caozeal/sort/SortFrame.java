package com.caozeal.sort;

import javax.swing.*;
import java.awt.*;

public class SortFrame extends JFrame {

    public static void main(String[] args) {
        SortFrame frame = new SortFrame();
    }

    public SortFrame() throws HeadlessException {
        int[] elements = {1, 3, 3, 2, 10, 6, 5};
        SortPanel panel = new SortPanel(elements);
        this.add(panel);
        this.setSize(1000, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        BubbleSort sort = new BubbleSort(panel);
        sort.sort(elements);
    }

    static class SortPanel extends JPanel implements Runnable{

        private final int[] elements;

        private int current = 0;

        public void setCurrent(int current) {
            this.current = current;
        }

        public SortPanel(int[] elements) {
            this.elements = elements;
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            int x = 50;
            for (int i = 0; i < elements.length; i++) {
                if(i == current){
                    g.setColor(Color.PINK);
                    g.drawOval(x-5, 35, 20, 20);
                    g.setColor(Color.BLACK);
                }
                g.drawString(String.valueOf(elements[i]), x, 50);
                x+=50;
            }
        }

        @Override
        public void run() {
            repaint();
        }
    }
}
