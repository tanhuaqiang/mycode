package com.dalingjia.bean;

public class ShipRuleProdDTO {

    private Long id;
    private String sku;
    private String prodName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    @Override
    public String toString() {
        return "ShipRuleProdDTO{" +
                "id=" + id +
                ", sku='" + sku + '\'' +
                ", prodName='" + prodName + '\'' +
                '}';
    }
}
