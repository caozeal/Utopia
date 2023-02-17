package com.caozeal.sort;

public class InsertionSort extends AbstractPanelSort{

    protected InsertionSort(SortPanel panel) {
        super(panel);
    }

    @Override
    public int[] sort(int[] origin) {
        int sorted = 0;
        for (int i = 0; i < origin.length; i++) {
            int current = origin[i];
            int j;
            for(j=sorted-1; j>=0; j--){
                repaint(j+1);
                System.out.println("==========sort round============");
                if(current < origin[j]){
                    origin[j+1] = origin[j];
                    origin[j] = current; //便于展示
                }else {
                    break;
                }
            }
            origin[j+1] = current;
            sorted = i+1;
            panel.getSorted().add(i);
            repaint(j+1);
        }
        System.out.println("==========sort over============");
        return origin;
    }
}
