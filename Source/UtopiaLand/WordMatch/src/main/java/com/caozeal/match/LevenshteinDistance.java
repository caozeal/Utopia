package com.caozeal.match;

import org.apache.commons.lang.math.NumberUtils;

/**
 * <p>创建时间：2019/8/21 18:38
 * <p>PACKAGE_NAME
 *
 * @author caozhiyong
 * @version 1.0
 */
public class LevenshteinDistance {

    public static int calculate(String s1, String s2){
        int[][] distances = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s2.length() + 1; i++) {
            distances[0][i] = i;
        }
        for (int j = 1; j < s1.length() + 1; j++) {
            distances[j][0] = j;
        }
        for (int i = 1; i < s2.length() + 1; i++) {
            for (int j = 1; j < s1.length() + 1; j++) {
                if(s1.charAt(j - 1) == s2.charAt(i - 1)){
                    distances[j][i] = distances[j - 1][i - 1];
                    continue;
                }
                distances[j][i] = NumberUtils.min(distances[j - 1][i - 1], distances[j - 1][i], distances[j][i -1]) + 1;
            }
        }
        return distances[s1.length()][s2.length()];
    }
}
