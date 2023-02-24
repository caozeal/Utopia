package com.caozeal.leetcode.before20230224;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 圆形排列
 * 给你两个整数n 和 start。你的任务是返回任意 (0,1,2,,...,2^n-1) 的排列 p，并且满足：
 *
 * p[0] = start
 * p[i] 和 p[i+1]的二进制表示形式只有一位不同
 * p[0] 和 p[2^n -1]的二进制表示形式也只有一位不同
 *
 * 示例 1：
 *
 * 输入：n = 2, start = 3
 * 输出：[3,2,0,1]
 * 解释：这个排列的二进制表示是 (11,10,00,01)
 *      所有的相邻元素都有一位是不同的，另一个有效的排列是 [3,1,0,2]
 * 示例 2：
 *
 * 输出：n = 3, start = 2
 * 输出：[2,6,7,5,4,0,1,3]
 * 解释：这个排列的二进制表示是 (010,110,111,101,100,000,001,011)
 * 010 011 001 000 100 101 111 110
 * 2 3 1 0 4 5 7 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/circular-permutation-in-binary-representation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Zhiyong Cao
 * @since 1.0.0
 */
public class CircularPermutation {

    public static void main(String[] args) {
        CircularPermutation circularPermutation = new CircularPermutation();
        List<Integer> result = circularPermutation.circularPermutation(16, 16);
        System.out.println(JSON.toJSONString(result));
        System.out.println(Integer.toBinaryString(result.get(0)) + "_" + Integer.toBinaryString(result.get(result.size()-1)));
    }

    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> result = new ArrayList<>();
        result.add(start);
        revert(n, result);
        return result;
    }

    private void revert(int n, List<Integer> result){
        if(n == 0){
            return;
        }
        revert(n-1, result);
        int mask = 1 << (n-1);
        result.add(result.get(result.size()-1) ^ mask);
        revert(n-1, result);
    }
}
