package com.dalingjia.leetcode.LinkedList;

public class LinkedEntranceOfLoop {

    public static void main(String[] args) {
        //没有环
//        LinkedNode node1 = new LinkedNode(1);
//        LinkedNode node2 = new LinkedNode(3);
//        LinkedNode node3 = new LinkedNode(2);
//        LinkedNode node4 = new LinkedNode(5);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        System.out.println(getCrossNode(node1));

        //有环
        LinkedNode node1 = new LinkedNode(1);
        LinkedNode node2 = new LinkedNode(8);
        LinkedNode node3 = new LinkedNode(2);
        LinkedNode node4 = new LinkedNode(5);
        LinkedNode node5 = new LinkedNode(9);
        LinkedNode node6 = new LinkedNode(4);
        LinkedNode node7 = new LinkedNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node1;

        int crossNode = getCrossNode(node1);
        System.out.println(crossNode);
    }



    //另解: 慢的走x步，快的走2x步，相差的就是环的大小 n=2x-x=x
    public static int getCrossNode(LinkedNode head){
        if(head == null || head.next == null){
            return -1;
        }
        LinkedNode slow = head.next;
        LinkedNode fast = head.next.next;
        while (slow != null && fast != null){
            //当二者相遇时(快指针比满指针多走n个环的距离)
            if(slow == fast){
                //让快指针重新从head开始每次走一步
                fast = head;
                /**
                 * F = L+X+nR
                 * S = L+X     }==> L = nR-X
                 * F = 2S
                 * 当n=1时，L=R-X; 也就是头结点到入口结点的距离 == 快慢指针交点到入口结点的距离
                 * 当二者再次相遇时，交点就是环的入口结点
                 *
                 * 参考博客：https://blog.csdn.net/baidu_40931662/article/details/84306202
                 */
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast.data;
            }
            slow = slow.next;
            //防止空指针
            if(fast.next == null){
                return -1;
            }else {
                fast = fast.next.next;
            }
        }
        return -1;
    }


}
