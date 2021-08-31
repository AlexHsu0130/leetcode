package leetCode;

import java.util.TreeMap;

public class BestTimeToBuyandSellStock {

    public static void main(String[] args) {
        TreeMap<Integer, Integer> map1 = new TreeMap<Integer, Integer>();
        map1.put(1, 2);

        map1.put(2, 4);

        map1.put(7, 1);

        map1.put(5, 2);

        System.out.println("map1=" + map1);

    }

    public static int maxProfitByBruteForce(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    public static int maxProfitByOnePass(int[] prices) {
        int result = 0;
        int sub = 0;
        int pre = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > pre) {
                for (int x = i - 1; 0 <= x; x--) {
                    sub = prices[i] - prices[x];
                    if (sub > result) {
                        result = sub;
                    }
                }
            }
            pre = prices[i];
        }
        return result;
    }

}
