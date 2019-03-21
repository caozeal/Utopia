package com.caozeal.practice.error;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

    static class OOMObject{
        
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
