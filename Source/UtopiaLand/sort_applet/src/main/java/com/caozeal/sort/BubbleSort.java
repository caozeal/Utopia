package com.caozeal.sort;

public class BubbleSort extends AbstractPanelSort{

    public BubbleSort(SortPanel panel) {
        super(panel);
    }

    @Override
    public int[] sort(int[] origin){
        boolean swap;
        for (int i = origin.length-1; i > 0; i--) {
            repaint(0);

            swap = false;
            for (int j = 0; j < i; j++) {
                if(origin[j] > origin[j+1]){
                    swap(origin, j, j+1);
                    swap = true;
                }
                if(panel != null){
                    repaint(j+1);
                }
            }
            panel.getSorted().add(i);
            System.out.println("==========sort round============");
            repaint(null);
            if(!swap){
                break;
            }
        }
        System.out.println("==========sort over============");
        repaint(null);
        return origin;
    }


}
