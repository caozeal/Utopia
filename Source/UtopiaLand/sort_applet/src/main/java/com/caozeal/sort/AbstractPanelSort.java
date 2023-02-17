package com.caozeal.sort;

public abstract class AbstractPanelSort {

    protected final SortPanel panel;

    protected AbstractPanelSort(SortPanel panel) {
        this.panel = panel;
    }


    public abstract int[] sort(int[] origin);

    protected void swap(int[] origin, int i, int j){
        if(i < 0 || j < 0 || i >= origin.length || j >= origin.length || i == j){
            return;
        }
        int temp = origin[i];
        origin[i] = origin[j];
        origin[j] = temp;
    }

    protected void repaint(Integer current){
        if(current != null){
            this.panel.setCurrent(current);
        }
        this.panel.repaint();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
