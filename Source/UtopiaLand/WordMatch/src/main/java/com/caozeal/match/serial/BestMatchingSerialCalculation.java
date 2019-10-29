package com.caozeal.match.serial;

import com.caozeal.match.BestMatchingData;
import com.caozeal.match.LevenshteinDistance;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>创建时间：2019/9/3 14:41
 * <p>com.caozeal.match.serial
 *
 * @author caozhiyong
 * @version 1.0
 */
public class BestMatchingSerialCalculation {

    public static BestMatchingData getBestMatchingWords(String word, List<String> dictionary){
        List<String> result = new ArrayList<>();
        int minDistance = Integer.MAX_VALUE;
        int distance;

        for (String s : dictionary) {
            distance = LevenshteinDistance.calculate(word, s);
            if(distance > minDistance){
                continue;
            }
            if(distance < minDistance){
                minDistance = distance;
                result.clear();
            }
            result.add(s);
        }
        return BestMatchingData.builder().distance(minDistance).words(result).build();
    }
}
