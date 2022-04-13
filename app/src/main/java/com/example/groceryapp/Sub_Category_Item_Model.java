package com.example.groceryapp;

public class Sub_Category_Item_Model {
    String sub_groceryitem;
    int image;

    public Sub_Category_Item_Model(String sub_groceryitem, int image) {
        this.sub_groceryitem = sub_groceryitem;
        this.image = image;
    }

    public String getSub_groceryitem() {
        return sub_groceryitem;
    }

    public int getImage() {
        return image;
    }
}