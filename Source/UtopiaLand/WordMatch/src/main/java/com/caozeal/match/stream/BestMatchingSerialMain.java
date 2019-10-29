package com.caozeal.match.stream;

import com.caozeal.match.BestMatchingData;
import com.caozeal.match.WordsLoader;

/**
 * <p>创建时间：2019/9/3 14:51
 * <p>com.caozeal.match.serial
 *
 * @author caozhiyong
 * @version 1.0
 */
public class BestMatchingSerialMain {

    /**
     * 257, 287, 272, 308
     * @param args
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("begin at " + start);
        BestMatchingData bestMatchingData = BestMatchingSerialCalculation
            .getBestMatchingWords("stitter", WordsLoader.getInstance().getWords());
        long end = System.currentTimeMillis();
        System.out.println(bestMatchingData);
        System.out.println("end at " + end);
        System.out.println("Serial Calcultion costs " + (end - start) + "ms");
    }
}
