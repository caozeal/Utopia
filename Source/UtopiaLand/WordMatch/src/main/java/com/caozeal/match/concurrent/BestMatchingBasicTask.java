package com.caozeal.match.concurrent;

import com.caozeal.match.BestMatchingData;
import com.caozeal.match.LevenshteinDistance;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * <p>创建时间：2019/9/3 15:26
 * <p>com.caozeal.match.concurrent
 *
 * @author caozhiyong
 * @version 1.0
 */
public class BestMatchingBasicTask implements Callable<BestMatchingData > {

    private int startIndex;
    private int endIndex;
    private List<String> dictionary;
    private String word;

    public BestMatchingBasicTask(int startIndex, int endIndex,
        List<String> dictionary, String word) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.dictionary = dictionary;
        this.word = word;
    }

    @Override
    public BestMatchingData call() {
        List<String> results= new ArrayList<>();
        int minDistance=Integer.MAX_VALUE;
        int distance;
        for (int i=startIndex; i<endIndex; i++) {
            distance = LevenshteinDistance.calculate(word, dictionary.get(i));
            if (distance < minDistance) {
                results.clear();
                minDistance = distance;
                results.add(dictionary.get(i));
            } else if (distance == minDistance) {
                results.add(dictionary.get(i));
            }
        }
        return BestMatchingData.builder().words(results).distance(minDistance).build();
    }
}
