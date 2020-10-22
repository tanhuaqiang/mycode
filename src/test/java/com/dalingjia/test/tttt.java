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
        Body body = new Body(new Head());
        Body body1 = (Body) body.clone();
        System.out.println("body == body1 : " + (body == body1));
        System.out.println("body.head == body1.head : " + (body.head == body1.head));


        Integer deadlineIsModify = null;
//        System.out.println(YesNoEnum.NO.getCode() == deadlineIsModify);
//        System.out.println(deadlineIsModify == YesNoEnum.NO.getCode());
        System.out.println("tan");

        Long ii = 1310515203238002787L;

        System.out.println(ii);

        String defect_in_use_default = "[\n" +
                "    {\n" +
                "      \"id\": 701,\n" +
                "      \"name\": \"基础功能无法满足\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 702,\n" +
                "      \"name\": \"硬件相关（卡顿、不灵敏等）\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 703,\n" +
                "      \"name\": \"售后服务差\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 704,\n" +
                "      \"name\": \"平台对接、会员营销相关\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 705,\n" +
                "      \"name\": \"没有缺陷\"\n" +
                "    }\n" +
                "  ]";

        System.out.println(defect_in_use_default.replace("\\n", ""));

    }
}
