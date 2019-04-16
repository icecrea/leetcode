package com.example.weeklycontest.weeklycontest132;

/**
 * @description: 除数博弈
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 * <p>
 * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
 * <p>
 * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
 * 用 N - x 替换黑板上的数字 N 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 * <p>
 * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出：true
 * 解释：爱丽丝选择 1，鲍勃无法进行操作。
 * 示例 2：
 * <p>
 * 输入：3
 * 输出：false
 * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 1000
 * @author: icecrea
 * @create: 2019-04-16 19:32
 **/
public class DivisorGame {
    /**
     * 注意，x是不变的，选择之后
     * N为1时，由于爱丽丝先手，无法进行操作，鲍勃胜利，为false
     * N为2时，爱丽丝胜利，为true
     * N为3时，鲍勃胜利，为false
     * N为4时，取数情况为1,1,1，爱丽丝胜利，为true (或者2)
     * N为5时，取数情况为1,1,1,1，鲍勃胜利，为false
     * N为6时，取数：3 / 1 1 1 1 1 爱丽丝胜利 true
     * <p>
     * dp[i] represents whether a player can win given the number i if he is the first turn.
     *
     * @param N
     * @return
     */
    public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int x = 1; x < i; x++) {
                //上一轮是false，下一轮则为true
                if (i % x == 0 && !dp[i - x]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }

    /**
     * 原理：
     * ***Choosing any x with 0 < x < N and N % x == 0.
     * ***Replacing the number N on the chalkboard with N - x.
     * key words: Both players play optimally.
     * 1)N = 1, first player(alice) lose;
     * 2)N = 2, first player(alice) take x = 1, then N = 1, look 1) ,sencond player lose(first player(alice) win);
     * 3)N = 3, first player(alice) only take x = 1, then N = 2, look 2), sencond player win(first player(alice) lose);
     * 4)N = 4, first player(alice) can take x = 1 or x = 2. while alice take x = 1, then N = 3, look 3), sencond player lose(first player(alice) win);
     * 5)N = 5, first player(alice) only take x = 1, then N = 4, look 4), sencond player win(first player(alice) lose);
     *
     * @param N
     * @return
     */
    public boolean divisorGame2(int N) {
        return (N & 1) == 0;
    }
}
