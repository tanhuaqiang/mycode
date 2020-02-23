package com.daling.util;

import com.alibaba.fastjson.JSON;

import java.security.MessageDigest;
import java.util.*;

/**
 * 签名工具
 *
 * @Author: raoxiaoyan
 * @CreateDate: 2019/5/30
 */
public class SignUtil {

    /**
     * 计算并获取CheckSum
     * 使用sha1加密
     *
     * @param appSecret
     * @param nonce
     * @param curTime
     * @return
     */
    public static String sign(String appSecret, String nonce, String curTime) {
        return encode("sha1", appSecret + nonce + curTime);
    }

    public static String md5(String url, Map params) {
        return md5(url, params, "");
    }

    /**
     * @param url
     * @param params
     * @param jsonBody    请求体json字符串
     * @return
     */
    public static String md5(String url, Map params, String jsonBody) {
        Set<String> keySet = params.keySet();
        //2. 对参数的key进行排序
        List<String> keyList = new ArrayList<>(keySet);
        Collections.sort(keyList);
        Map<String, Object> paramMap = new LinkedHashMap<>();
        for (String key : keyList) {
            paramMap.put(key, params.get(key));
        }
        String requestParams = JSON.toJSONString(paramMap);
        requestParams = requestParams.concat(jsonBody).concat(url);
        return md5(requestParams);
    }

    /**
     * 计算并获取md5值
     *
     * @param requestBody
     * @return
     */
    public static String md5(String requestBody) {
        return encode("md5", requestBody);
    }

    public static String encode(String algorithm, String value) {
        if (value == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(value.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 把密文转换成十六进制的字符串形式
     *
     * @param bytes
     * @return
     */
    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

}