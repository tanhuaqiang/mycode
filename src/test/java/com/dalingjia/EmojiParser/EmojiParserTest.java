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
        CyclicBarrier barrier  = new CyclicBarrier(4);
    }
}
