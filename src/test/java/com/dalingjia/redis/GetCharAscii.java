package com.dalingjia.redis;

public class GetCharAscii {

    public static void main(String[] args) {
        toBinary("abc");
    }

    public static void toBinary(String str) {
        char[] strChar = str.toCharArray();
        String result = "";
        for (int i = 0; i < strChar.length; i++) {
            result += Integer.toBinaryString(strChar[i]) + " ";
        }
        System.out.println(result);
    }
}
