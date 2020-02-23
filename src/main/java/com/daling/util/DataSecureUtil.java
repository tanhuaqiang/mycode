package com.daling.util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

/**
 * @author tanhq
 * @Description 加密解密类
 * @Date 2019/10/26 下午11:11
 * @Version 1.0
 **/
public class DataSecureUtil {

    /** 加密、解密key. */
    private static final String PASSWORD_CRYPT_KEY = "smxq4p854vaxdm21v5tnupi85lsk0273";
    private static final String SECURE_RANDOM_STR = "12345678";

    /**
     * 用指定的key对数据进行DES解密.
     *
     *
     * @throws Exception
     */
    public static String encrypt(String data) throws Exception {
        byte[] key= {20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43};
        byte[] iv = {7,3,3,4,1,6,8,1};
        String orig="ABCDEFG天才";
        byte[] original=orig.getBytes("8859_1");
        System.out.println(new String (original,"8859_1"));
        Security.addProvider(new BouncyCastleProvider());
        Cipher wrapper = Cipher.getInstance("DESede/CBC/PKCS5Padding","BC");
        wrapper.init(Cipher.WRAP_MODE, new SecretKeySpec(key, "DESEDE"), new IvParameterSpec(iv));
        byte[] cryptograph = wrapper.wrap(new SecretKeySpec(original, "DESEDE"));
        return new String (cryptograph);
    }

    /**
     * 需要解密的数据
     * 这是加解密的功能，每次运行加解密都会new一个BouncyCastleProvider对象,放倒Cipher.getInstance()方法中。
     * verificationResults.put(var0, PROVIDER_VERIFIED);
     * 导致内存被占用儿得不到了回收
     * @param data
     * @return
     * @throws Exception
     */
    public static String decrypt(String data) throws Exception {

        Cipher cipher = Cipher.getInstance("DES", new BouncyCastleProvider());

        return "a";
    }



}

 
    
    
    
    