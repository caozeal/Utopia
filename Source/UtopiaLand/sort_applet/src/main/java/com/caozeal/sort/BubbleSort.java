package com.caozeal.sort;

import javax.swing.*;

public class BubbleSort extends AbstractPanelSort{

    public BubbleSort(SortFrame.SortPanel panel) {
        super(panel);
    }

    public int[] sort(int[] origin){
        boolean swap;
        for (int i = origin.length-1; i > 0; i--) {
            if(panel != null){
                panel.setCurrent(0);
                repaint();
            }
            swap = false;
            for (int j = 0; j < i; j++) {
                if(origin[j] > origin[j+1]){
                    swap(origin, j, j+1);
                    swap = true;
                }
                if(panel != null){
                    panel.setCurrent(j+1);
                    repaint();
                }
            }
            System.out.println("==========sort round============");
            repaint();
            if(!swap){
                break;
            }
        }
        System.out.println("==========sort over============");
        repaint();
        return origin;
    }


}
