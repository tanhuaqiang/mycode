package com.dalingjia.test;

public class TestNotNull {

    public static void main(String[] args) {

        System.out.println(numToBinary(7));
        System.out.println(numToBinary(4));
        System.out.println(numToBinary(49));
        int i = 2;
        i = i++;
        System.out.println(i);
    }

    public String addBinary(String a, String b) {
        String result="";
        //类似于前一章的carry进位状态符
        int sum=0;
        int lengthA = a.length();
        int lengthB = b.length();
        while(lengthA > 0 || lengthB > 0){
            if(lengthA>0){
                //截取字符串最后一位，类似获取十进制里的个位
                sum += Integer.parseInt(a.substring(lengthA-1, lengthA));
                lengthA--;
            }
            if(lengthB>0){
                sum += Integer.parseInt(b.substring(lengthB-1, lengthB));
                lengthB--;
            }
            //当刚好满足二进制进位条件时
            if(sum == 2){
                //相加刚好等于2，所以前一位剩余0，类似于十进制 4+6时，个位满十进位，个位数值为0
                result = "0" + result;
                //这里重新赋予1，是指进位的那一个数值，所以前面代码是用 sum+=  而不是sum=
                sum = 1;
            }else if(sum==3){
                result = "1" + result;
                sum = 1;
            }else{
                result=(sum + "") + result;
                sum = 0;
            }
        }
        //用于处理最高位进位
        if(sum == 1){
            result = "1" + result;
        }
        return result;
    }

    /**
     * 二进制转整数
     * @param s
     * @return
     */
    public static int binaryToNum(String s) {
        int num = 1;
        int sum = 0;
        for (int i = s.length()-1; i >=0; i--) {
            if(s.charAt(i) == '1'){
                sum += 1*num;
            }
            num *= 2;
        }
        return sum;
    }

    /**
     * 整数转二进制
     * @param s
     * @return
     */
    public static String numToBinary(int s) {
        StringBuilder sb = new StringBuilder();
        while (s / 2 != 0) {
            sb.append(s % 2);
            s = s / 2;
        }
        sb.append(s);
        return sb.reverse().toString();
    }
}
