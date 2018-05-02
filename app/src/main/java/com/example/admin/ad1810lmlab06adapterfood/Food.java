package com.example.admin.ad1810lmlab06adapterfood;

/**
 * Created by Admin on 06/04/2018.
 */

public class Food {
    int image;
    String name;
    String desct; // Description

    public Food() {
    }

    public Food(int image, String name, String desct) {
        this.image = image;
        this.name = name;
        this.desct = desct;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesct() {
        return desct;
    }

    public void setDesct(String desct) {
        this.desct = desct;
    }
}
