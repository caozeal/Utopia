package com.caozeal.sort;

public abstract class AbstractPanelSort {

    protected final SortFrame.SortPanel panel;

    protected AbstractPanelSort(SortFrame.SortPanel panel) {
        this.panel = panel;
    }

    protected void swap(int[] origin, int i, int j){
        if(i < 0 || j < 0 || i >= origin.length || j >= origin.length || i == j){
            return;
        }
        int temp = origin[i];
        origin[i] = origin[j];
        origin[j] = temp;
    }

    protected void repaint(){
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
