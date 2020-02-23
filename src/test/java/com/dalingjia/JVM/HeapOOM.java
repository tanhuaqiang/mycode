package com.dalingjia.JVM;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 限制java堆的大小为20MB, 堆的最小值-Xms参数与最大值-Xmx参数设置为一样，即可避免堆自动扩展
 *
 * VM Args: -Xms20m -Xmx20m
 *          -XX:+HeapDumpOnOutOfMemoryError  （一个参数之间不要有空格）
 *          可以让虚拟机在出现内存溢出异常是Dump出当前的内存堆转储快照以便事后进行分析
 *
 *
 *          -Xmn10m : 表示10MB分配给新生代
 * java_pid1549.hprof 文件在项目的根目录下
 */
public class HeapOOM {

    /**
     * 内存占位符对象，一个OOMObject大约占64kB
     */
    static class OOMObject{
        public byte[] placeHolder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) {
        try {
            fillHeap(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
