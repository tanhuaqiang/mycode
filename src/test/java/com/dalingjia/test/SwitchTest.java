package com.dalingjia.test;

import com.google.common.base.Preconditions;

public class SwitchTest {

    public static void main(String[] args) {
        int type = 2;
        /**
         * 忘记写break的陷阱
         * break在switch中用于结束当前流程
         * 一旦case匹配，就会顺序执行后面的程序代码，而不管后面的case是否匹配，直到遇见break
         */
        switch (type){
            case 1:
                System.out.println(1);
            case 2:
                System.out.println(2);
            case 3:
                System.out.println(3);
                break;
            case 4:
                System.out.println(4);
            case 5:
                System.out.println(5);
                break;

        }

        System.out.println(getLeapYear(-3));
        System.out.println(getLeapYear(0));
        System.out.printf("第三次提交代码，嘻嘻嘻嘻");
    }

    public static int getDays(){
        int year = 2015;
        int month = 8;
        int day = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = 31;
                break;
            case 2:
                day = 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day = 30;
                break;
        }
        return day;
    }


    /** 判断2009年是闰年还是平年。
     *提示：
     *闰年的条件是符合下面二者之一：(1)年份能被4整除，但不能被100整除；(2)能被400整除。
     **/
    public static boolean getLeapYear(int year){
        Preconditions.checkArgument(year >0 );
        boolean flag = false;
        if(year % 400 ==0 || year % 4 == 0 && year % 100 != 0){
            flag = true;
        }
        return flag;
    }

}
