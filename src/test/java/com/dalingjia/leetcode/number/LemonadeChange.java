package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description 860 柠檬水找零
 * @Date 2019/9/17 下午9:59
 * @Version 1.0
 **/
public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int[] ints = {0, 0, 0};
        for (int i : bills) {
            if (i == 5) {
                ints[0]++;
            } else if (i == 10) {
                if (ints[0] > 0) {
                    ints[0]--;
                    ints[1]++;
                }else {
                    return false;
                }
            }else { // 20
                if (ints[0] > 0 && ints[1] > 0) { //先找10块的出去
                    ints[0]--;
                    ints[1]--;
                    ints[2]++;
                } else if (ints[0] > 2) {
                    ints[0] -= 3;
                    ints[2]++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

 
    
    
    
    