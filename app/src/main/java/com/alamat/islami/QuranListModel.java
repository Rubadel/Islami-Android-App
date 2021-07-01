package com.alamat.islami;

public class QuranListModel {

    int image;
    String sorhName;


    public QuranListModel(int image, String sorhName) {
        this.image = image;
        this.sorhName = sorhName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getSorhName() {
        return sorhName;
    }

    public void setSorhName(String sorhName) {
        this.sorhName = sorhName;
    }

}
