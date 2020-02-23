package com.dalingjia.thead.letterPrint;

public class LetterList {

    private Character i = 'a';

    public Character getI() {
        return i;
    }

    public void setI(Character i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "LetterList{" +
                "i=" + i +
                '}';
    }
}
