package com.shuzzy.junaid.shuzzy;

public class model {
    String url,name,price;

    public model(String url, String name, String price) {
        this.url = url;
        this.name = name;
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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
