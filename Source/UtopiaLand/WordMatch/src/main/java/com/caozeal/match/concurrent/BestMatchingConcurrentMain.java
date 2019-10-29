package com.caozeal.match.concurrent;

import com.caozeal.match.BestMatchingData;
import com.caozeal.match.WordsLoader;
import com.caozeal.match.serial.BestMatchingSerialCalculation;
import java.util.concurrent.ExecutionException;

/**
 * <p>创建时间：2019/9/3 15:13
 * <p>com.caozeal.match.stream
 *
 * @author caozhiyong
 * @version 1.0
 */
public class BestMatchingConcurrentMain {

    /**
     * 298, 277, 213, 192
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println("begin at " + start);
        BestMatchingData bestMatchingData = BestMatchingConcurrentCalculation
            .getBestMatchingWords("stitter", WordsLoader.getInstance().getWords());
        long end = System.currentTimeMillis();
        System.out.println(bestMatchingData);
        System.out.println("end at " + end);
        System.out.println("Serial Calcultion costs " + (end - start) + "ms");
    }
}
