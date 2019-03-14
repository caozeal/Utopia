package com.caozeal.practice.concurrent.base.executor.knn;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * <p>创建时间：2019/3/11 20:14
 * <p>com.caozeal.practice.concurrent.base.executor.knn
 * @author caozhiyong
 * @version 1.0
 */
@AllArgsConstructor
public class KmmClassifer {

    private final List<? extends Sample> dataSet;

    private int k;

    //    public String classify(Sample sample){
//
//    }
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\caozhiyong\\Documents\\CoCall4\\15965@ts\\recvfile\\法院TAP支持\\user1.json");

        String a = FileUtils.readFileToString(file, "UTF-8");
        Object o = JSON.parse(a);
        System.exit(0);
    }
}
