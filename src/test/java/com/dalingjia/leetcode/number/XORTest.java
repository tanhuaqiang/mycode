package com.dalingjia.leetcode.number;

public class XORTest {

    /**
     * 问题一：在一个整数数组中，除了一个数之外，其他的数出现的次数都是两次，求出现一次的数，要求时间复杂度尽可能的小。
     * 例如数组{2,2,3,7,3,6,6},出现一次的数是7.
     */

    /**
     * 考虑异或运算：异或的运算法则为：0⊕0=0，1⊕0=1，0⊕1=1，1⊕1=0（同为0，异为1）
     * 任何数字和自己做异或运算结果都为0；任何数字和0做异或运算结构都为本身
     */
    public static int getNumberAppearOnce(int[] arr){
        if(arr == null || arr.length <=2){
            throw new IllegalArgumentException("数组长度必须大于2");
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result ^= arr[i];
        }
        return result;
    }


    /**
     * 问题一：在一个整数数组中，除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
     * 例如数组{2,2,3,7,3,6,9,6},出现一次的数是7和9
     * 思路：
     *     (1)对于出现两次的元素，使用“异或”操作后结果肯定为0，那么我们就可以遍历一遍数组，对所有元素使用异或操作，那么得到的结果就是两个出现一次的元素的异或结果。
     *
     * 　　(2)因为这两个元素不相等，所以异或的结果肯定不是0，也就是可以再异或的结果中找到1位不为0的位，例如异或结果的最后一位不为0。
     *
     * 　　(3)这样我们就可以最后一位将原数组元素分为两组，一组该位全为1，另一组该位全为0。
     *
     * 　　(4)再次遍历原数组，最后一位为0的一起异或，最后一位为1的一起异或，两组异或的结果分别对应着两个结果。
     */
    public static int[] findNumsAppearOnce(int [] array,int[] num) {
        //输入不符合要求
        if(array==null||array.length==0){
            throw new IllegalArgumentException("数组长度必须大于2");
        }
        //int xor存放异或结果
        int xor=0;
        //flag用于寻找和标记第N位为1的位置
        int flag=1;
        //先对整个数组的元素进行异或运算
        for(int i=0;i<array.length;i++){
            xor^=array[i];
        }
        //寻找结果为1的位置
        while((xor&flag)==0){
            flag=flag<<1;
        }

        for(int i=0;i<array.length;i++){
            //根据该位是否为1，将原数组进行分组
            if((array[i]&flag)==0){
                num[0]^=array[i];
            }else{
                num[1]^=array[i];
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,3,3,6,9,6};
//        System.out.println(getNumberAppearOnce(arr));

        int[] array = {2,2,3,7,3,6,9,6};
        int[] num = new int[2];
        num = findNumsAppearOnce(array, num);
        System.out.println(num[0]);
        System.out.println(num[1]);

        System.out.println(test(100));
        System.out.println(Sum_Solution(100));
        System.out.println(Math.pow(100, 2));
    }


    public static int test(int n){
        int sum = n;
        //&& : 左边为false，右边不会执行
        //采用递归，利用逻辑与的短路特性
        boolean flag = (n>0) && ((sum += test(n - 1)) > 0);
        return sum;
    }

    public static int Sum_Solution(int n) {
        int sum = (int) (Math.pow(n,2) + n);
        return sum>>1;
    }

}
