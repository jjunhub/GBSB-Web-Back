package com.dogbalbirdbal.service;

import com.dogbalbirdbal.database.data.DataSet_URL;
import com.dogbalbirdbal.database.data.RouteInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CrawlingService {
    static int count = 0; // variable for choice path

    public String crawlfood(String location) {
        String fullURL = "https://www.mangoplate.com/search/" + location;
        JSONArray jsonArray = new JSONArray();
        try {
            Elements restaurants = Jsoup.connect(fullURL)
                    .get()
                    .body()
                    .getElementsByClass("list-restaurant-item");
            for (Element restaurant : restaurants) {
                String restaurantLocation = restaurant.select(".thumb img").attr("alt").split("-")[1].strip();
                String thumbnail = restaurant.select(".thumb img").attr("data-original").split(";")[0];
                String restaurantLink = restaurant.select(".info a").attr("abs:href");
                String restaurantName = restaurant.select(".info a").text();

                System.out.println(thumbnail);
                if ( restaurantLocation.equals("")
                        | thumbnail.startsWith("/?fit=around")
                        | restaurantLink.equals("")
                        | restaurantName.equals("")) {
                    continue;
                }
                System.out.println("ok");

                DataSet_URL food = new DataSet_URL(restaurantName, thumbnail, restaurantLink, restaurantLocation);
                JSONObject jsonObject = new JSONObject(food.toString());
                jsonArray.put(jsonObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONArray returnjsonArray = new JSONArray();
        try {
            while(returnjsonArray.length() < 3){
                int random = (int) (Math.random() * jsonArray.length());
                JSONObject tempObject = jsonArray.getJSONObject(random);
                if (!returnjsonArray.toString().contains(tempObject.toString()))
                    returnjsonArray.put(tempObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnjsonArray.toString();
    }

    public String crawlhotel(String data) {
        //장소_2022-12-09_2022-12-10 방식으로 data 작성
        ArrayList<DataSet_URL> Hotels = new ArrayList<>();
        ArrayList<String> StringName = new ArrayList<>();
        ArrayList<String> PicURL = new ArrayList<>();
        ArrayList<String> Info = new ArrayList<>();
        ArrayList<String> Location = new ArrayList<>();
        String[] urlSplit = data.split("_");

        String fullURL = "https://www.goodchoice.kr/product/result?sel_date=checkin&sel_date2=checkout&keyword=destination";
        fullURL = fullURL.replace("checkin", urlSplit[1]);
        fullURL = fullURL.replace("checkout", urlSplit[2]);
        fullURL = fullURL.replace("destination", urlSplit[0]);

        try {
            Document doc = Jsoup.connect(fullURL).timeout(0).get();
            Elements text_contents = doc.select("div[class=name] strong");
            Elements image_contents = doc.select("p[class=pic] img");
            Elements info_contents = doc.select("div[id=poduct_list_area] ul a");
            Elements Location_contents = doc.select("div[id=poduct_list_area] ul li a div div[class=name] p:nth-child(3)");

            for (Element t : text_contents) {
                String temp = t.text();
                if(temp.contains("특급")) temp = temp.replace("특급", "");
                if(temp.contains("가족호텔")) temp = temp.replace("가족호텔", "");
                if(temp.contains("비지니스")) temp = temp.replace("비지니스","");
                if(temp.contains("★당일특가★")) temp = temp.replace("★당일특가★", "");
                if(temp.contains("★연말특가★")) temp = temp.replace("★연말특가★", "");
                if(temp.contains("[대규모특가]")) temp = temp.replace("★당일특가★", "");
                if(temp.contains("[반짝특가]")) temp = temp.replace("[반짝특가]", "");
                if(temp.contains("[특가]")) temp = temp.replace("[특가]", "");

                StringName.add(temp);
            }

            for (Element i : image_contents) {
                PicURL.add("https:" + i.attr("data-original"));
            }

            for (Element k : info_contents) {
                Info.add(k.attr("href"));
            }

            for( Element l : Location_contents){
                Location.add(l.text());
            }
            for (int a = 0; a < 10; a++) {
                DataSet_URL hotel = new DataSet_URL(StringName.get(a), PicURL.get(a), Info.get(a), Location.get(a));
                Hotels.add(hotel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String result = Hotels.get(count++ % Hotels.size()).toString();
        System.out.println(result);
        return result;
    }
    public String selectPath(String destination, String theme){
        // 입력 예시는 "부산 힐링", "부산 식도락", "부산 오락".
        int pick_location = 0, pick_theme = 0;

        switch (destination) {
            case "부산" -> pick_location = 0;
            case "대구" -> pick_location = 1;
            case "수원" -> pick_location = 2;
        }

        switch (theme) {
            case "힐링" -> pick_theme = 0;
            case "음식" -> pick_theme = 1;
            case "커플" -> pick_theme = 2;
            case "랜덤" -> pick_theme = (int) (Math.random() * 3);
        }

        String result = "[" + RouteInfo.GetRoute(pick_location, pick_theme, count++ % 6) + "," +
                RouteInfo.GetRoute(pick_location, pick_theme, count++ % 6) + "," +
                RouteInfo.GetRoute(pick_location, pick_theme, count++ % 6) + "]";
        return result;
    }
}