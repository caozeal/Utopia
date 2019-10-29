package com.caozeal.match.concurrent;

import com.caozeal.match.BestMatchingData;
import com.caozeal.match.LevenshteinDistance;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <p>创建时间：2019/9/3 15:13
 * <p>com.caozeal.match.stream
 *
 * @author caozhiyong
 * @version 1.0
 */
public class BestMatchingConcurrentCalculation {

    public static BestMatchingData getBestMatchingWords(String word, List<String> dictionary) throws InterruptedException,
        ExecutionException {
        int numCores = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numCores);
        int size = dictionary.size();
        int step = size / numCores;
        int startIndex, endIndex;
        List<Future<BestMatchingData>> results = new ArrayList<>();
        for (int i = 0; i < numCores; i++) {
            startIndex = i * step;
            if (i == numCores - 1) {
                endIndex = dictionary.size();
            } else {
                endIndex = (i + 1) * step;
            }
            BestMatchingBasicTask task = new BestMatchingBasicTask(startIndex,
                endIndex, dictionary, word);
            Future<BestMatchingData> future = executor.submit(task);
            results.add(future);
        }
        executor.shutdown();
        List<String> words=new ArrayList<>();
        int minDistance=Integer.MAX_VALUE;
        for (Future<BestMatchingData> future: results) {
            BestMatchingData data = future.get();
            if (data.getDistance() < minDistance) {
                words.clear();
                minDistance=data.getDistance();
                words.addAll(data.getWords());
            } else if (data.getDistance()==minDistance) {
                words.addAll(data.getWords());
            }
        }
        return BestMatchingData.builder().distance(minDistance).words(words).build();
    }
}
