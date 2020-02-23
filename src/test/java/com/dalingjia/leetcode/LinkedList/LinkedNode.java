package com.dalingjia.leetcode.LinkedList;

import java.util.Objects;

//定义链表结构
public class LinkedNode {

    public Integer data;
    public LinkedNode next;

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public LinkedNode getNextNode() {
        return next;
    }

    public void setNextNode(LinkedNode next) {
        this.next = next;
    }

    public LinkedNode(Integer data, LinkedNode next) {
        this.data = data;
        this.next = next;
    }

    public LinkedNode(Integer data) {
        this.data = data;
    }

    public LinkedNode() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedNode that = (LinkedNode) o;
        return Objects.equals(data, that.data) &&
                Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {

        return Objects.hash(data, next);
    }
}
