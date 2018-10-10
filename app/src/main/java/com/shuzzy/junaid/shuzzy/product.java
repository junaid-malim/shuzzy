package com.shuzzy.junaid.shuzzy;

public class product {
    int id;
    int price;
    String name;
    String image;
    String url;

    public product(int id,int price,String name,String image,String url) {
        this.price = price;
        this.name=name;
        this.id=id;
        this.image=image;
        this.url=url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
