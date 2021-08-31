package leetCode;

/**
 * <pre>
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
你在爬楼梯。 需要n步才能到达顶部。
每次您可以爬 1 步或 2 步。 你可以通过多少种不同的方式登上顶峰？
 * </pre>
 * 
 * @since Jul 12, 2021
 * @author AlexHsu
 * @version
 *          <ul>
 *          <li>Jul 12, 2021,AlexHsu,new
 *          </ul>
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 5;

        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
        // return climbStairs(0, n);
    }

    /**
     * Approach 1: Brute Force(遞迴處理) In this brute force approach we take all possible step combinations i.e. 1 and 2, at every step. At every step we are calling the function climbStairsclimbStairs
     * for step 11 and 22, and return the sum of returned values of both functions.
     * 
     * @param i
     * @param n
     * @return
     * @see 結構圖
     * @see _____________________________________________(0,5)
     * @see ___________________________________________(1,5)___________________________(2,5)
     * @see ______________________________(2,5)________________(3,5)_______________(3,5)______(4,5)
     * @see ________________________(3,5)______(4,5)______(4,5)______(5,5)_____(4,5)___(5,5)(5,5)(6,5)
     * @see ______________________(4,5)(5,5)_(5,5)(6,5)_(5,5)(6,5)___________(5,5)(6,5)
     * @see _______________(5,5)__(6,5)
     * @see
     */

    private static int climbStairs(int i, int n) {
        if (i > n)
            return 0;
        if (i == n)
            return 1;
        return climbStairs(i + 1, n) + climbStairs(i + 2, n);
    }

    /**
     * Approach 2: Recursion with Memoization
     * 
     * @param i
     * @param n
     * @param memo
     * @return
     */
    // memo[0] = climb_Stairs(0 + 1, 3, memo) + climb_Stairs(0 + 2, 3, memo);
    // memo[1] = climb_Stairs(1 + 1, 3, memo) + climb_Stairs(1 + 2, 3, memo);
    // memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
    // memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
    public static int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        System.out.println("memo[" + i + "] : " + memo[i]);
        return memo[i];
    }

}
