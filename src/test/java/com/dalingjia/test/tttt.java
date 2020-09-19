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
                "21 ,      \n" +
                "20 ,      \n" +
                "22 ,      \n" +
                "19 ,      \n" +
                "35 ,      \n" +
                "34 ,      \n" +
                "33 ,      \n" +
                "32 ,      \n" +
                "31 ,      \n" +
                "30 ,      \n" +
                "29 ,      \n" +
                "28 ,      \n" +
                "27 ,      \n" +
                "36 ,      \n" +
                "37 ,      \n" +
                "39 ,      \n" +
                "45 ,      \n" +
                "43 ,      \n" +
                "42 ,      \n" +
                "41 ,      \n" +
                "52 ,      \n" +
                "48 ,      \n" +
                "50 ,      \n" +
                "47 ,      \n" +
                "46 ,      \n" +
                "51 ,      \n" +
                "64 ,      \n" +
                "53 ,      \n" +
                "44 ,      \n" +
                "49 ,      \n" +
                "71 ,      \n" +
                "54 ,      \n" +
                "66 ,      \n" +
                "67 ,      \n" +
                "69 ,      \n" +
                "70 ,      \n" +
                "55 ,      \n" +
                "58 ,      \n" +
                "72 ,      \n" +
                "76 ,      \n" +
                "74 ,      \n" +
                "73 ,      \n" +
                "75 ,      \n" +
                "87 ,      \n" +
                "89 ,      \n" +
                "81 ,      \n" +
                "84 ,      \n" +
                "83 ,      \n" +
                "82 ,      \n" +
                "78 ,      \n" +
                "79 ,      \n" +
                "77 ,      \n" +
                "86 ,      \n" +
                "80 ,      \n" +
                "99 ,      \n" +
                "94 ,      \n" +
                "88 ,      \n" +
                "90 ,      \n" +
                "102,      \n" +
                "97 ,      \n" +
                "95 ,      \n" +
                "96 ,      \n" +
                "93 ,      \n" +
                "100,      \n" +
                "92 ,      \n" +
                "91 ,      \n" +
                "119,      \n" +
                "104,      \n" +
                "105,      \n" +
                "117,      \n" +
                "111,      \n" +
                "106,      \n" +
                "118,      \n" +
                "110,      \n" +
                "107,      \n" +
                "114,      \n" +
                "121,      \n" +
                "120,      \n" +
                "112,      \n" +
                "85 ,      \n" +
                "103,      \n" +
                "108,      \n" +
                "98 ,      \n" +
                "122,      \n" +
                "125,      \n" +
                "202,      \n" +
                "203,      \n" +
                "207,      \n" +
                "190,      \n" +
                "201,      \n" +
                "186,      \n" +
                "200,      \n" +
                "160,      \n" +
                "135,      \n" +
                "132,      \n" +
                "131,      \n" +
                "129,      \n" +
                "128,      \n" +
                "136,      \n" +
                "101,      \n" +
                "220,      \n" +
                "123,      \n" +
                "116,      \n" +
                "191,      \n" +
                "188,      \n" +
                "208,      \n" +
                "189,      \n" +
                "210,      \n" +
                "172,      \n" +
                "187,      \n" +
                "197,      \n" +
                "195,      \n" +
                "138,      \n" +
                "137,      \n" +
                "218,      \n" +
                "185,      \n" +
                "166,      \n" +
                "127,      \n" +
                "130,      \n" +
                "219,      \n" +
                "214,      \n" +
                "211,      \n" +
                "212,      \n" +
                "109,      \n" +
                "217,      \n" +
                "221,      \n" +
                "236,      \n" +
                "225,      \n" +
                "216,      \n" +
                "223,      \n" +
                "196,      \n" +
                "194,      \n" +
                "227,      \n" +
                "228,      \n" +
                "226,      \n" +
                "238,      \n" +
                "260,      \n" +
                "235,      \n" +
                "234,      \n" +
                "229,      \n" +
                "230,      \n" +
                "240,      \n" +
                "237,      \n" +
                "224,      \n" +
                "249,      \n" +
                "256,      \n" +
                "258,      \n" +
                "231,      \n" +
                "232,      \n" +
                "241,      \n" +
                "244,      \n" +
                "209,      \n" +
                "246,      \n" +
                "261,      \n" +
                "257,      \n" +
                "259,      \n" +
                "245,      \n" +
                "242,      \n" +
                "247,      \n" +
                "263,      \n" +
                "262,      \n" +
                "243,      \n" +
                "270,      \n" +
                "275,      \n" +
                "284,      \n" +
                "278,      \n" +
                "277,      \n" +
                "276,      \n" +
                "301,      \n" +
                "302,      \n" +
                "286,      \n" +
                "300,      \n" +
                "299,      \n" +
                "298,      \n" +
                "285,      \n" +
                "282,      \n" +
                "292,      \n" +
                "291,      \n" +
                "288,      \n" +
                "280,      \n" +
                "289,      \n" +
                "294,      \n" +
                "283,      \n" +
                "303,      \n" +
                "290,      \n" +
                "296,      \n" +
                "293,      \n" +
                "304,      \n" +
                "305,      \n" +
                "295,      \n" +
                "313,      \n" +
                "287,      \n" +
                "309,      \n" +
                "281,      \n" +
                "310,      \n" +
                "307,      \n" ;
        String [] strings = id.replace("\n", "").replace("\\s+", "").split(",");

    }
}
