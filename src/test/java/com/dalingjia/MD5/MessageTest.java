package com.dalingjia.MD5;

import java.security.MessageDigest;

public class MessageTest {

    /**
     * 对字符串md5加密
     * @param signContent
     * @return
     */
    private static String hash(String signContent) {
        String hashResult = "";
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            //byte[]  getBytes(): 使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中
            //计算md5函数
            md.update(signContent.getBytes("UTF-8"));
            //digest()最后确定返回md5 hash值
            byte byteData[] = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashResult = sb.toString().toLowerCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashResult;
    }

    /**
     * java中以0x开头的数表示十六进制数(如0x1, 0xa)， 其中以字母a~f表示10~15的数字
     * 在java中以0开头的数表示八进制数(如012,03)，没有前缀的数才表示十进制数(如123,4)
     * 在java里面 "&" 是一个‘与’运算符，就是二进制中的 同为1才为1
     * @param args
     */
    public static void main(String[] args) {
//        System.out.println(hash("tanhq"));
        StringBuffer stringBuffer = new StringBuffer();
        //在java里面这个是一个‘与’运算符，就是二进制中的 同为1才为1
        System.out.println(4 & 0xff);//4
        System.out.println(0x100);//256 -> 100000000
        System.out.println(0xff);//255 -> 11111111
        System.out.println(0x05);//5
        System.out.println((44 & 0xff) + 0x100);//44+256=300
        System.out.println(Integer.toString((44 & 0xff) + 0x100, 16));//将300转换为16进制数: 0x12c
        stringBuffer.append(Integer.toString((44 & 0xff) + 0x100, 16).substring(1));//从第2位开始截取
        System.out.println(stringBuffer);
    }
}
