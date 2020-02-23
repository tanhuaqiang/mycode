package com.dalingjia.leetcode.LinkedList;

import java.util.Objects;

public class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return data == node.data;
    }

    @Override
    public int hashCode() {

        return Objects.hash(data);
    }
}
