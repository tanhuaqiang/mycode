package com.dalingjia.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    private static PrintWriter pw=null;
    private static BufferedReader br=null;
    private static Socket s;
    static Scanner scanner=new Scanner(System.in);
    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            //客户端通常使用Socket的构造器来连接到指定的服务器
            Socket s=new Socket(InetAddress.getLocalHost(),5500);
            pw=new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
            br=new BufferedReader(new InputStreamReader(s.getInputStream()));
            while(true){
                System.out.println("Client端请输入：");
                String str = scanner.next();
                pw.println(str);
                pw.flush();
                String string=br.readLine();
                System.out.println("Client读到："+string);
                if(str.equals("exit")){
                    break;
                }
            }
        }catch (Exception e) {
                e.printStackTrace();
        }finally {
            try {
                pw.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}