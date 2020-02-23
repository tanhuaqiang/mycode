package com.dalingjia.bean;

public class ShipRule {

    private Long id;
    private String title;
    private String prods;

    public ShipRule(Long id, String title, String prods) {
        this.id = id;
        this.title = title;
        this.prods = prods;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProds() {
        return prods;
    }

    public void setProds(String prods) {
        this.prods = prods;
    }

    @Override
    public String toString() {
        return "ShipRule{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", prods='" + prods + '\'' +
                '}';
    }
}
