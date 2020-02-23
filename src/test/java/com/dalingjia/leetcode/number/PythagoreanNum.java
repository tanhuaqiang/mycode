package com.dalingjia.leetcode.number;

import java.util.UUID;

public class PythagoreanNum {
    public static void main(String[] args) {
        System.out.println(method(17));
        Double t = 4.44;
        System.out.println(t.intValue() == t);

        Double e = Math.sqrt(25-16);
        System.out.println(e);
        System.out.println(e.intValue());
        System.out.println(e.intValue() == e);

        System.out.println(UUID.randomUUID().toString());
        String lockTicketID = UUID.randomUUID().toString().replace("-","");
        String lockTicketID2 = UUID.randomUUID().toString().replaceAll("-","");
        System.out.println(lockTicketID);
        System.out.println(lockTicketID2);
    }

    private static boolean method(int num){
        boolean flag = false;
        for (int i = 1; i < num ; i++) {
            Double b = Math.sqrt(num*num - i*i);
            if(b.intValue() == b){
                flag = true;
                System.out.println("i="+i+", b="+b+", num="+num);
                break;
            }
        }
        return flag;
    }
}
