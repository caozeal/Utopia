package com.caozeal.match.stream;

import com.caozeal.match.BestMatchingData;
import com.caozeal.match.LevenshteinDistance;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>创建时间：2019/9/3 14:41
 * <p>com.caozeal.match.serial
 *
 * @author caozhiyong
 * @version 1.0
 */
public class BestMatchingSerialCalculation {

    public static BestMatchingData getBestMatchingWords(String word, List<String> dictionary){
        BestMatchingData data = dictionary.parallelStream()
            .map(s ->{
                List<String> words = new ArrayList<>();
                words.add(s);
                return BestMatchingData.builder().words(words).distance(LevenshteinDistance.calculate(s, word)).build();
            })
            .reduce((data1, data2) -> {
                if(data2.getDistance() < data1.getDistance()){
                    data1.setDistance(data2.getDistance());
                    data1.getWords().clear();
                    data1.getWords().addAll(data2.getWords());
                }else if(data2.getDistance() == data1.getDistance()){
                    data1.getWords().addAll(data2.getWords());
                }
                return data1;
            })
            .orElse(BestMatchingData.builder().distance(Integer.MAX_VALUE).build());

        return data;
    }
}
