package com.caozeal.leetcode.before20230224;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class OrderedStream {

    private String[] val;

    private List<String> list;

    private int ptr = 1;

    public OrderedStream(int n) {
        val = new String[n];
        list = Arrays.asList(val);
    }

    public List<String> insert(int idKey, String value) {
        val[idKey-1] = value;
        if(idKey != ptr){
            return Collections.emptyList();
        }
        int begin = ptr-1;
        while(ptr<=val.length && val[ptr-1] != null){
            ptr++;
        }
        return list.subList(begin, ptr-1);
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */