package com.dogbalbirdbal.database.data;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DataSet_URL{
    private String name;
    private String pic_url;
    private String info;
    private String address;

    public DataSet_URL(){}

    public DataSet_URL(String name, String pic_url, String info, String address) {
        this.name = name;
        this.pic_url = pic_url;
        this.info = info;
        this.address = address;
    }

    public String toString() {
        return "{\"name\":\"" + this.name + "\", \"pic_url\":\"" + this.pic_url + "\", \"info\":\"" + this.info + "\", \"address\":\"" + this.address + "\"}";
    }
}




