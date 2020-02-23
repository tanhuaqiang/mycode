package com.dalingjia.JVM;

public class MinorGC3 {

    private static final int _1MB = 1024*1024;
    /**
     * -Xms20M -Xms20M          : 堆的最小值为20M, 最大值为20M, 可以限制java堆的大小为20MB
     * -Xmn10M                  : 新生代分配10MB, 剩下10MB分配给老年代
     * -XX: +PrintGCDetails     : 虚拟机提供的垃圾日志参数
     * -XX: SurvivorRatio=8     : 决定了新生代Eden区与一个Survivor区的空间比例是8:1
     * -XX: MaxTenuringThreshold=1 : 对象晋升老年代的年龄阀值
     * -XX:+PrintTenuringDistribution
     */
    public static void testAllocation(){
        byte[] allocation1, allocation2,allocation3,allocation4;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }
    public static void main(String[] args) {
        testAllocation();
    }
}
