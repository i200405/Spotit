package com.ahmedsohail.i200557;

public class Items {

    private String itemName, price, location, date;

    public Items(String itemName, String price, String location, String date) {
        this.itemName = itemName;
        this.price = price;
        this.location = location;
        this.date = date;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
