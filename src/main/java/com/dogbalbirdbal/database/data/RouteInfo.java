package com.dogbalbirdbal.database.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;

public class RouteInfo {
    public static ArrayList[][] FoodLocation = new ArrayList[4][];
    static {
        FoodLocation[0] = new ArrayList[3]; // 부산
        FoodLocation[0][0] = new ArrayList<>(); // 부산 힐링
        FoodLocation[0][1] = new ArrayList<>(); // 부산 음식
        FoodLocation[0][2] = new ArrayList<>(); // 부산 커플

        FoodLocation[1] = new ArrayList[3]; // 대구
        FoodLocation[1][0] = new ArrayList<>(); // 대구 힐링
        FoodLocation[1][1] = new ArrayList<>(); // 대구 음식
        FoodLocation[1][2] = new ArrayList<>(); // 대구 커플

        FoodLocation[2] = new ArrayList[3]; // 수원
        FoodLocation[2][0] = new ArrayList<>(); // 수원 힐링
        FoodLocation[2][1] = new ArrayList<>(); // 수원 음식
        FoodLocation[2][2] = new ArrayList<>(); // 수원 커플

        File fl = new File("src/main/java/com/dogbalbirdbal/database/data/DataSet.txt");
        BufferedReader bfr = null;
        try {
            FileReader fir = new FileReader(fl);
            bfr = new BufferedReader(fir);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int city = 0, theme = 0;
        String line = "";
        ObjectMapper mapper = new ObjectMapper();
        while (true) {
            try {
                line = bfr.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (line == null || line.equals("")) break;

            if (line.contains("keyword")) {
                if (line.contains("부산")) city = 0;
                else if (line.contains("대구")) city = 1;
                else if (line.contains("수원")) city = 2;
                else if (line.contains("서울")) city = 3;

                if (line.contains("힐링")) theme = 0;
                else if (line.contains("음식")) theme = 1;
                else if (line.contains("커플")) theme = 2;
                continue;
            }

            try {
                FoodLocation[city][theme].add(mapper.readValue(line, DataSet_URL.class));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Route Info Load Complete");
    }
    public static String GetRoute(int pick_location, int pick_theme, int count){
        return FoodLocation[pick_location][pick_theme].get(count).toString();
    }
}
