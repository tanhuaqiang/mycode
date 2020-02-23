package com.dalingjia.thead.letterPrint;

import java.util.*;

public class Consonant implements Runnable{

    private String name;
    private LetterList letterList;

    public Consonant(String name, LetterList letterList) {
        this.name = name;
        this.letterList = letterList;
    }

    @Override
    public void run() {
        Character[] characters = new Character[]{'a', 'e','i', 'o', 'u'};
        List<Character> list = Arrays.asList(characters);
        try {
            while (true) {
                if(!list.contains(letterList.getI())){
                    System.out.println(name + "打印-->" + letterList.getI());
                    letterList.setI((char) (letterList.getI() + 1));
                }
                Thread.sleep(100);
                if(letterList.getI() > 'z'){
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
