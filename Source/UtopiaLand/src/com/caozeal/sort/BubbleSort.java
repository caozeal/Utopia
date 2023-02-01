package com.caozeal.sort;

import com.alibaba.fastjson.JSON;

public class BubbleSort{

    private final SortFrame.SortPanel panel;

    public static void main(String[] args) {
        int[] origin = {1, 3, 3, 2, 10, 6, 5};
        BubbleSort bubbleSort = new BubbleSort(null);
        bubbleSort.sort(origin);
    }

    public BubbleSort(SortFrame.SortPanel panel) {
        this.panel = panel;
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
            System.out.println(JSON.toJSONString(origin));
            repaint();
            if(!swap){
                break;
            }
        }
        System.out.println("==========sort over============");
        System.out.println(JSON.toJSONString(origin));
        repaint();
        return origin;
    }

    private void swap(int[] origin, int i, int j){
        if(i < 0 || j < 0 || i >= origin.length || j >= origin.length || i == j){
            return;
        }
        int temp = origin[i];
        origin[i] = origin[j];
        origin[j] = temp;
    }

    private void repaint(){
        if(this.panel != null){
            this.panel.repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
