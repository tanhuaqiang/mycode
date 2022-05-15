package com.dalingjia.leetcode.ListNode;

/**
 * @author tanhq
 * @Description 203 移除链表元素
 * @Date 2019/8/20 上午10:30
 * @Version 1.0
 **/
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // 要把链表前面连续的需要删除的节点  从链表移除出去，得到一个头节点不需要被删除的新链表(head.val != val)
        // head != null : 防止空指针
        while (head != null && head.val == val) {
            head = head.next;
        }
        // 链表被删空
        if(head == null){
            return null;
        }
        //定义一个指针
        ListNode node = head;
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            }else {
                node = node.next;
            }
        }
        return head;
    }


    /**
     * 设置一个虚拟节点
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode cur = header;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return header.next;

    }



    /**
     * 给定指定节点，删除该节点 LeetCode 237
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
 
    
    
    
    