package demo.code.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CoinCombo {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 7));
//        System.out.println(coinChange(new int[]{2}, 3));
//        System.out.println(coinChange(new int[]{186, 419, 83, 408}, 6249));
    }

    public static int coinChange(int[] coins, int amount) {
        return count(coins, amount, new int[amount]);
    }

    private static int count(int []coins, int amt, int[]cache) {
        if(amt < 0) return -1;
        if(amt == 0) return 0;
        if(cache[amt - 1] != 0) return cache[amt - 1];

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < coins.length; i++) {
            int response = count(coins, amt - coins[i], cache);
            if(response >= 0 && response < min) {
                min = 1 + response;
            }
        }
        cache[amt - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return cache[amt - 1];
    }
}
