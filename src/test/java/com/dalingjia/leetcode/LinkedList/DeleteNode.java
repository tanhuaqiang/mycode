package com.dalingjia.leetcode.LinkedList;

public class DeleteNode {

    /**
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
     * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     * @param pHead
     * @return
     */
    public static Node deleteNode(Node pHead){
        //使用虚拟头结点
        Node visual = new Node(-1);
        visual.next = pHead;
        //当前结点的前一个结点，其实就是标识头结点的一个指针
        Node pre = visual;
        //遍历链表
        while (pHead != null && pHead.next != null) {
            if(pHead.data == pHead.next.data){
                int value = pHead.data;
                //寻找链表中相同的结点
                while (pHead.data == value) {
                    pHead = pHead.next;
                }
                pre.next = pHead;
            }else {
                pre = pHead;
                pHead = pHead.next;

            }
        }
        return visual.next;
    }

    /**
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次，返回链表头指针。
     * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->3->4->5
     * @param head
     * @return
     */
    public static Node deleteDuplicates(Node head) {
        //指定一个虚拟结点，不动
        Node visual = new Node(-1);
        visual.next = head;
        //用于删除结点的辅助指针
        Node pre = visual;
        while (head != null && head.next != null) {
            if (head.data == head.next.data) {
                //防止空指针
                while (head.next != null && head.data == head.next.data) {
                    head = head.next;
                    pre.next = head;
                }
            }else {
                pre = head;
                head = head.next;
            }
        }
        return visual.next;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(3);
        Node node5 = new Node(4);
        Node node6 = new Node(4);
//        Node node7 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
//        node6.next = node7;
        Node head = deleteDuplicates(node1);
        System.out.println(head.data);
    }
}
