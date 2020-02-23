package com.dalingjia.util.regular;

import org.junit.Test;

public class RegularTest {

    @Test
    public void test1(){
        String mobile = "18332559937";
        if(mobile.matches("^1[\\d]{10}$")){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }
}
