package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description 925 长按键入
 * @Date 2019/9/18 下午4:11
 * @Version 1.0
 **/
public class IsLongPressedName {

    /**
     * 通过2个指针解决
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedName(String name, String typed) {
        for (int i = 0, j = 0; i < name.length(); ) {
            if (j >= typed.length()) {
                return false;
            }
            //比较name[i]==typed[j]，如果成立的话，我们将i+=1并且j+=1
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (i >= 1 && name.charAt(i - 1) == typed.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }
        return true;

    }
}

 
    
    
    
    