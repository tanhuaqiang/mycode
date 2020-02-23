package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2019/8/21 下午12:14
 * @Version 1.0
 **/
public class VersionControl {

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(isBadVersion(mid)){
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }
}

 
    
    
    
    