package com.dalingjia.leetcode.array;

import java.util.PriorityQueue;

/**
 * @author tanhq
 * @Description 703 数据流中第k大元素
 * @Date 2019/9/15 下午6:53
 * @Version 1.0
 **/
public class KthLargest {

    final PriorityQueue<Integer> pq;
    final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k);
        for (int i : nums) {//对传进来的int数组遍历
            add(i);
        }
    }

    /**
     * int k = 3;
     * int[] arr = [4,5,8,2];
     * KthLargest kthLargest = new KthLargest(3, arr);
     * kthLargest.add(3);   // returns 4
     * kthLargest.add(5);   // returns 5
     * kthLargest.add(10);  // returns 5
     * kthLargest.add(9);   // returns 8
     * kthLargest.add(4);   // returns 8
     * @param val
     * @return
     */
    public int add(int val) {
        if (pq.size() < k)//如果队列中的数量少于K，直接添加入优先队列，优先队列会自动维持小顶堆
            pq.offer(val);
        else {
            /*
                否则队列中的数量大于或者等于K，优先队列中的最小数字小于新的数据，优先队列中的顶堆要被移除，并且添加入新的数据进入优先队列，然后做一个调整
                如果优先队列中的最小数字大于新的数，则不作任何操作，返回优先队列的头元素
             */
            if (pq.peek() < val) {
                pq.poll();
                pq.offer(val);
            }
        }
        return pq.peek();//返回当前第K大的数
    }
}

 
    
    
    
    