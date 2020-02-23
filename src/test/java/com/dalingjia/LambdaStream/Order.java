package com.dalingjia.LambdaStream;

public class Order {
    private Integer orderId;
    private String orderName;
    private Integer sort;

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Order(Integer orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }

    public Order(Integer orderId, String orderName, Integer sort) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.sort = sort;
    }

    public Order(){}

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                ", sort=" + sort +
                '}';
    }

    public static void main(String[] args) {
        System.out.println("abc.bda".replace(".","$"));
        int HIGHEST_PRECEDENCE = -2147483648;
        int LOWEST_PRECEDENCE = 2147483647;
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(2^4);
    }

}