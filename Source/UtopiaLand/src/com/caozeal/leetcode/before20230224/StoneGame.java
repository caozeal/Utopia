package com.caozeal.leetcode.before20230224;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * [5, 3, 4, 5]
 * [3, 7, 2, 3]
 * 假设有 n 堆石子，n 是偶数，则每堆石子的下标从 0 到 n−1。根据下标将 n 堆石子分成两组，每组有n/2
 * 堆石子，下标为偶数的石子堆属于第一组，下标为奇数的石子堆属于第二组。初始时，行的开始处的石子堆位于
 * 下标 0，属于第一组，行的结束处的石子堆位于下标n−1，属于第二组，因此作为先手的Alice可以自由选择取
 * 走第一组的一堆石子或者第二组的一堆石子。如果Alice取走第一组的一堆石子，则剩下的部分在行的开始处和
 * 结束处的石子堆都属于第二组，因此Bob 只能取走第二组的一堆石子。如果Alice 取走第二组的一堆石子，则
 * 剩下的部分在行的开始处和结束处的石子堆都属于第一组，因此Bob 只能取走第一组的一堆石子。无论Bob 取
 * 走的是开始处还是结束处的一堆石子，剩下的部分在行的开始处和结束处的石子堆一定是属于不同组的，因此轮
 * 到Alice 取走石子时，Alice 又可以在两组石子之间进行自由选择。根据上述分析可知，作为先手的Alice
 * Alice 可以在第一次取走石子时就决定取走哪一组的石子，并全程取走同一组的石子。既然如此，Alice 是否
 * 有必胜策略？
 * 答案是肯定的。将石子分成两组之后，可以计算出每一组的石子数量，同时知道哪一组的石子数量更多。Alice
 * 只要选择取走数量更多的一组石子即可。因此，Alice 总是可以赢得比赛。
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode.cn/problems/stone-game/solution/shi-zi-you-xi-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class StoneGame {

    public static void main(String[] args) {
        StoneGame game = new StoneGame();
        System.out.printf("" + game.stoneGame(new int[]{5, 3, 4, 5}));
    }

    private Map<String, Integer> backup = new HashMap<>();

    /**
     * 石头游戏
     *
     * @param piles 桩
     * @return boolean
     */
    public boolean stoneGame(int[] piles) {
        int sum = Arrays.stream(piles).sum();
        int alice = max(piles, 0, piles.length-1, sum);
        return alice > sum - alice;
    }

    /**
     * 回溯+备忘录
     * @param piles
     * @param l
     * @param r
     * @param sum
     * @return
     */
    private int max(int[] piles, int l, int r, int sum){
        if(l == r){
            return piles[l];
        }
        String format = String.format("%s_%s", l, r);
        if(backup.containsKey(format)){
            return backup.get(format);
        }
        int sumLeft = sum - piles[l];
        int left = piles[l] + (sumLeft - max(piles, l+1, r, sumLeft));
        int sumRight = sum - piles[r];
        int right = piles[r] + (sumRight - max(piles, l, r-1, sumRight));
        int max = Math.max(left, right);
        backup.put(format, max);
        return max;
    }
}
