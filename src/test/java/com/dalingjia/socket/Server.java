package com.dalingjia.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {
    private static BufferedReader br=null;
    private static PrintWriter pw=null;
    private static ServerSocket ss;
    private static Socket s;
    static Scanner scanner=new Scanner(System.in);
    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            //用指定的端口号来创建一个ServerSocket，端口号范围：0~65536
            ss=new ServerSocket(5500);
            System.out.println("服务器正常启动。。。。");
            s=ss.accept();//阻塞方法，接受客户端socket请求
            System.out.println("连接成功"+s.getRemoteSocketAddress());
            br=new BufferedReader(new InputStreamReader(s.getInputStream()));
            pw=new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
            while(true){
                String string=br.readLine();
                System.out.println("Server读到："+string);
                System.out.println("Server端请输入：");
                String str=scanner.next();
                pw.println(str);
                pw.flush();
                if(str.equals("exit")){
                    break;
                }
            }
        } catch (Exception e1) {
                e1.printStackTrace();
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