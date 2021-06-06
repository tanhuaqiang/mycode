package com.dalingjia.leetcodeStudy;

import java.util.ArrayList;
import java.util.Collections;

public class Code21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (l1 != null) {
            list.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            list.add(l2.val);
            l2 = l2.next;
        }
        Collections.sort(list);
        ListNode head = new ListNode(list.get(0));
        ListNode temp = head;
        for (int i = 1; i < list.size(); i++) {

            temp.next = new ListNode(list.get(i));
            temp = temp.next;
        }
        return head;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode resultHead;
        if (l1.val < l2.val) {
            resultHead = l1;
            resultHead.next = mergeTwoLists2(l1.next, l2);
        }else {
            resultHead = l2;
            resultHead.next = mergeTwoLists2(l1, l2.next);

        }
        return resultHead;

    }
}
