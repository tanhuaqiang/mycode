package com.dalingjia.EmojiParser;

import com.vdurmont.emoji.EmojiParser;

import java.util.concurrent.CyclicBarrier;

/**
 * Emoji表情
 */
public class EmojiParserTest {

    public static void main(String[] args) {
        String emoji = EmojiParser.parseToUnicode("\uD83D\uDC6Esfs\uD83D\uDC6F");
        System.out.println(emoji);
        System.out.println("范围习🈚️，🍚，解决了");
        CyclicBarrier barrier  = new CyclicBarrier(4);
        String s = "哈哈哈哈哈哈哈哈哈哈不哈哈哈哈哈哈哈哈哈哈还会不会版了……不过现在宝贝宝贝小的宝贝宝贝宝贝宝贝宝贝吧";
        System.out.println(s.length());

        String ss = "267473  268552\n" +
                " 267754  266810\n" +
                " 268799  268546\n" +
                " 268401  268560\n" +
                " 267750  268516\n" +
                " 268329  267915\n" +
                " 268384  267364\n" +
                " 267737  268132";
        String[] split = ss.split("\\s+");
        int sum = 0;
        for (String s1 : split) {
            sum += Integer.parseInt(s1);
        }
        System.out.println(sum);

    }

}
