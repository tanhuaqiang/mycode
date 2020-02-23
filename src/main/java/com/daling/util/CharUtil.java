package com.daling.util;

import java.util.regex.Pattern;

/**
 * @author tanhq
 * @date 2019/04/12
 */
public class CharUtil {

    public static final Pattern pattern = Pattern.compile("[\\u4E00-\\u9FBF]+");

    /**
     * 根据Unicode编码完美的判断中文汉字和符号
     * @param c
     * @return
     */
    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || (c >= '0' && c <= '9')
                || (c == '.') || (c == '\'')
                || (c == 32)) {
            return true;
        }
        return false;
    }

    /**
     * 完整的判断中文汉字和符号
     * @param strName
     * @return
     */
    public static boolean isChinese(String strName) {
        strName = strName.replaceAll("\\s*", "").trim();
        char[] ch = strName.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (!isChinese(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 只能判断部分CJK字符（CJK统一汉字）
     * @param str
     * @return
     */
    public static boolean isChineseByREG(String str) {
        if (str == null) {
            return false;
        }

        return pattern.matcher(str.trim()).find();
    }

    public static void main(String[] args) {
        String[] strArr = new String[] { "www.micmiu.com", "!@#$%^&*()_+{}[]|\"'?/:;<>,.", "！￥……（）——：；“”‘’《》，。？、", "不要啊", "やめて", "韩佳人", "???" };
        for (String str : strArr) {
            System.out.println("===========> 测试字符串：" + str);
            System.out.println("Unicode判断结果 ：" + isChinese(str));
            System.out.println("详细判断列表：");
            char[] ch = str.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                char c = ch[i];
                System.out.println(c + " --> " + (isChinese(c) ? "是" : "否"));
            }
        }
    }

    public static boolean isEnglish(String strName) {
        strName = strName.replaceAll("\\s*", "").trim();
        char[] ch = strName.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (!isEnglish(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEnglish(char c) {
        if (!(c >= 'A' && c <= 'Z')  && !(c >= 'a' && c <= 'z') && !(c == '\'') && !(c == '"') && !(c == '&') && !(c >= '0' && c <= '9')
                && !(c == 32) && !(c == '.')) {
            return false;
        }
        return true;
    }

}
