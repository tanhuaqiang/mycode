package com.dalingjia.leetcode.ListNode;

import org.junit.Test;

/**
 * 160 链表相交
 * 我们可以首先遍历两个链表得到它们的长度，就能知道哪个链表比较长，以及长的链表比短的链表多几个结点。
 * 在第二次遍历的时候，在较长的链表上先走若干步，接着再同时在两个链表上遍历，找到的第一个相同的结点就是它们的第一个公共结点
 */
public class ListNodeCross {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lengthA = listNodeLength(headA);
        int lengthB = listNodeLength(headB);
        //判断出长链表和短链表
        ListNode nodeLong = (lengthA > lengthB) ? headA : headB;
        ListNode nodeShort = (lengthA > lengthB) ? headB : headA;
        //长链表比短链表多出的长度
        int more = (lengthA > lengthB) ? (lengthA - lengthB) : (lengthB - lengthA);

        //长链表先走多出的长度
        while (more > 0) {
            nodeLong = nodeLong.next;
            more--;
        }
        //一起向前遍历链表，直到两链表结点相等
        while (nodeLong != null && nodeShort != null) {
            if (nodeLong.equals(nodeShort)) {
                return nodeLong;
            }
            nodeLong = nodeLong.next;
            nodeShort = nodeShort.next;
        }
        return null;
    }

    /**
     * 获取链表长度
     *
     * @param head
     * @return
     */
    public int listNodeLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }


    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        /**
         定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
         两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
         **/
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头, 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }


    @Test
    public void method() {
        ListNode nodeOne1 = new ListNode(1);
        ListNode nodeOne2 = new ListNode(2);
        ListNode nodeOne3 = new ListNode(3);
        ListNode nodeOne4 = new ListNode(4);
        ListNode nodeOne5 = new ListNode(5);
        ListNode nodeOne6 = new ListNode(8);
        ListNode nodeOne7 = new ListNode(9);

        ListNode nodeTwo1 = new ListNode(6);
        ListNode nodeTwo2 = new ListNode(7);
        nodeOne1.next = nodeOne2;
        nodeOne2.next = nodeOne3;
        nodeOne3.next = nodeOne4;
        nodeOne4.next = nodeOne5;
        nodeOne5.next = nodeOne6;
        nodeOne6.next = nodeOne7;

        nodeTwo1.next = nodeTwo2;
        nodeTwo2.next = nodeOne6;
        ListNode node = getIntersectionNode(nodeOne1, nodeTwo1);
        System.out.println(node.val);
    }
}
