package com.dogbalbirdbal.database.data;


public class DataSet_URL{
    private final String name;
    private final String pic_url;
    private final String info;
    private String address;

    public DataSet_URL(String name, String pic_url, String info, String address) {
        this.name = name;
        this.pic_url = pic_url;
        this.info = info;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPic_url() {
        return pic_url;
    }

    public String getInfo() {
        return info;
    }

    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }

//    public String toString() {
//        return "{\"name\":\"" + this.name + "\", \"pic_url\":\"" + this.pic_url + "\", \"info\":\"" + this.info + "\", \"address\":\"" + this.address + "\"}";
//    }
}
