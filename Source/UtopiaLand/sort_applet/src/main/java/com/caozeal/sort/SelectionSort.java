package com.caozeal.sort;

/**
 * 1. 比冒泡排序交换次数少，但需要1个变量存储当前最小值所在位置
 * 2. 冒泡排序为稳定算法，选择排序非稳定
 * 3. 插入排序从未排序区间依次选择放入已排序区间进行排序，选择排序从未排序区间选择好最小值直接放入已排序区间末尾
 */
public class SelectionSort extends AbstractPanelSort{
    protected SelectionSort(SortPanel panel) {
        super(panel);
    }

    @Override
    public int[] sort(int[] origin) {
        if(origin.length == 0){
            return origin;
        }
        int minP;
        for (int i = 0; i < origin.length; i++) {
            minP = i;
            repaint(minP);
            for (int j = i+1; j < origin.length; j++) {
                if(origin[j] < origin[minP]){
                    minP = j;
                    repaint(minP);
                }
            }
            swap(origin, i, minP);
            repaint(i);
            System.out.println("==========sort round============");
        }
        System.out.println("==========sort over============");
        return origin;
    }
}
