package com.shuzzy.junaid.shuzzy;

public class model {
    String url,brand,price;

    public model(String url, String brand, String price) {
        this.url = url;
        this.brand = brand;
        this.price = price;
    }
    public model(){

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return brand;
    }

    public void setName(String name) {
        this.brand = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
