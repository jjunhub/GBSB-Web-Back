package com.dogbalbirdbal.database.vo;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PlaceInfo {

    private String id;
    private String route;
    private int num;

    public PlaceInfo(String id, String route, int num) {
        this.id = id;
        this.route = route;
        this.num = num;
    }

    @Override
    public String toString() {
        return "PlaceInfo{" +
                "id='" + id + '\'' +
                ", route='" + route + '\'' +
                ", num='" + num + '\'' +
                '}';
    }
}
