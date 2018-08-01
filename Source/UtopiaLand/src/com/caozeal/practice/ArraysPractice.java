package com.caozeal.practice;

import java.util.Arrays;
import java.util.List;

/**
 * <p>创建时间：2018/7/19 9:41
 * <p>com.caozeal.practice
 * @author caozhiyong
 * @version 1.0
 */
public class ArraysPractice {

    public static int duplicate(List<Integer> list){
        if(null == list){
            return -1;
        }
        for(int i = 0; i < list.size(); i++){
            while (i != list.get(i)){
                if(list.get(i).equals(list.get(list.get(i)))){
                    return list.get(i);
                }

                int temp = list.get(i);
                list.set(i, list.get(temp));
                list.set(temp, temp);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] arrays = {2, 0, 3, 1, 2};
        int res = duplicate(Arrays.asList(arrays));
        System.out.println(res);
    }
}
