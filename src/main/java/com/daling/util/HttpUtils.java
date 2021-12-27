package com.daling.util;

import com.google.gson.Gson;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.util.Map;

public class HttpUtils {

    private static final Gson GSON = new Gson();


    public static String get(String url, String... params){
        for(String param : params){
            url = url.replaceFirst("#\\{\\}", param);
        }
        try {
            return Jsoup
                    .connect(url)
                    .header("Accept", "*/*")
                    .header("Accept-Encoding", "gzip, deflate")
                    .header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                    .header("Content-Type", "application/json;charset=UTF-8")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
                    .ignoreContentType(true)
                    .validateTLSCertificates(false)
                    .get().body().text();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String post(String url, String... params){
        for(String param : params){
            url = url.replaceFirst("#\\{\\}", param);
        }
        try {
            return Jsoup
                    .connect(url)
                    .header("Accept", "*/*")
                    .header("Accept-Encoding", "gzip, deflate")
                    .header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                    .header("Content-Type", "application/json;charset=UTF-8")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
                    .ignoreContentType(true)
                    .post().body().text();
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return null;
    }

    public static String post(String url, Map<String,String> params){
        try {
            Connection connection = Jsoup.connect(url);
            params.forEach(connection::data);
            connection.header("Accept", "*/*")
                    .header("Accept-Encoding", "gzip, deflate")
                    .header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                    .header("Content-Type", "application/json;charset=UTF-8")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
                    .ignoreContentType(true)
                    .post().body().text();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String postJson(String url, Map<String,String> params){
        try {
            String json = GSON.toJson(params);
            Connection connection = Jsoup.connect(url);
            connection.header("Accept", "*/*")
                    .header("Accept-Encoding", "gzip, deflate")
                    .header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                    .header("Content-Type", "application/json;charset=UTF-8")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
                    .ignoreContentType(true)
                    .requestBody(json)
                    .post().body().text();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String postStr(String url, String str){
        try {
            Connection connection = Jsoup.connect(url);
            connection.header("Accept", "*/*")
                    .header("Accept-Encoding", "gzip, deflate")
                    .header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                    .header("Content-Type", "application/json;charset=UTF-8")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
                    .ignoreContentType(true)
                    .requestBody(str)
                    .post().body().text();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
