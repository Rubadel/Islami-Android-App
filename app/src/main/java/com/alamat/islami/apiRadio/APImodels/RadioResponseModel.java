package com.alamat.islami.apiRadio.APImodels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RadioResponseModel {

    @SerializedName("Radios")
    private List<RadioItem> radios;

    public List<RadioItem> getRadios(){
        return radios;
    }

    public void setRadios(List<RadioItem> radios){
        this.radios = radios;
    }

    @Override
    public String toString(){
        return
                "RadioResponse{" +
                        "radios = '" + radios + '\'' +
                        "}";
    }

}
