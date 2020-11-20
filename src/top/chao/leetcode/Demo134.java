package top.chao.leetcode;

import java.util.Scanner;

/**
 * <p>在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。<br/>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gas-station</p>
 *  @author YiYChao
 *  @Date: 2020/11/18 18:35
 *  @version V1.0
 */
public class Demo134 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String gasRaw = sc.nextLine();
        String costRaw = sc.nextLine();
        gasRaw = gasRaw.substring(gasRaw.indexOf("[") + 1, gasRaw.indexOf("]"));
        String[] gasArr = gasRaw.split(",");
        costRaw = costRaw.substring(costRaw.indexOf("[") + 1, costRaw.indexOf("]"));
        String[] costArr = costRaw.split(",");
        int len = gasArr.length;
        boolean flag = true;
        for (int j = 0; j < len; j++) {
            int curr = 0;
            for (int i = j; i < len + j; i++) {
                int addCurrent = Integer.parseInt(gasArr[(i) % len]);         // 当前油量
                int cost = Integer.parseInt(costArr[(i) % len]);
                curr = curr + addCurrent - cost;
                if (curr < 0){
                    break;
                }
            }
            if (curr >= 0){
                System.out.println(j);
                flag = false;
                break;
            }
        }
        if (flag){
            System.out.println(-1);
        }
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int j = 0; j < len; j++) {
            int curr = 0;
            for (int i = j; i < len + j; i++) {
                int currentAdd = gas[(i) % len];         // 当前油量
                int currentCost = cost[(i) % len];
                curr = curr + currentAdd - currentCost;
                if (curr < 0){
                    break;
                }
            }
            if (curr >= 0){
                return j;
            }
        }
        return -1;
    }
}
