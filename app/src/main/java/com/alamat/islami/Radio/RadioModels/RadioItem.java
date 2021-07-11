package com.alamat.islami.Radio.RadioModels;

import com.google.gson.annotations.SerializedName;

public class RadioItem {

    @SerializedName("URL")
    private String uRL;

    @SerializedName("Name")
    private String name;

    public String getURL(){
        return uRL;
    }

    public void setURL(String uRL){
        this.uRL = uRL;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return
                "RadiosItem{" +
                        "uRL = '" + uRL + '\'' +
                        ",name = '" + name + '\'' +
                        "}";
    }
}
