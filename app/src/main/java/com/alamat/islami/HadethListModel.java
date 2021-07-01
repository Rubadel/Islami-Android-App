package com.alamat.islami;

public class HadethListModel {
    int image;
    String hadethName;


    public HadethListModel(int image, String hadethName) {
        this.image = image;
        this.hadethName = hadethName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getHadethName() {
        return hadethName;
    }

    public void setHadethName(String hadethName) {
        this.hadethName = hadethName;
    }
}
