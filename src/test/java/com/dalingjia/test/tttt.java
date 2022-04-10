package com.dalingjia.test;

import com.daling.bean.YesNoEnum;

public class tttt {

    static class Face {

    }

    static class Body implements Cloneable {
        public Head head;

        public Body() {
        }

        public Body(Head head) {
            this.head = head;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    static class Head /*implements Cloneable*/ {
        public Face face;
        public Head() {
        }
        public Head(Face face) {
            this.face = face;
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
//        Body body = new Body(new Head());
//        Body body1 = (Body) body.clone();
//        System.out.println("body == body1 : " + (body == body1));
//        System.out.println("body.head == body1.head : " + (body.head == body1.head));
//
//
//        Integer deadlineIsModify = null;
//        System.out.println(YesNoEnum.NO.getCode() == deadlineIsModify);
//        System.out.println(deadlineIsModify == YesNoEnum.NO.getCode());
//        System.out.println();

        String id =
                "26 ,      \n" +
                "25 ,      \n" +
                "23 ,      \n" +
                "24 ,      \n" +
                "307,      \n" ;
        String [] strings = id.replace("\n", "").replace("\\s+", "").split(",");

    }
}
