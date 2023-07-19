package com.dogbalbirdbal.service;

import com.dogbalbirdbal.database.data.DataSet_URL;
import com.dogbalbirdbal.database.data.RouteInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CrawlingService {
    static int count = 0; // variable for choice path

    public String crawlfood(String location){
        ArrayList<DataSet_URL> foods = new ArrayList<>();
        ArrayList<String> StringName = new ArrayList<>();
        ArrayList<String> PicURL = new ArrayList<>();
        ArrayList<String> Info = new ArrayList<>();
        ArrayList<String> Location = new ArrayList<>();
        String fullURL = "https://www.mangoplate.com/search/" + location;
        try {
            Document doc = Jsoup.connect(fullURL).get();
            Elements contents = doc.select("div[class=thumb] img");
            Elements infos = doc.select("a[class=only-desktop_not]");
            for(Element t : contents){
                String[] temp = t.attr("alt").split("-");
                if(temp[0].contains("사진"))
                    temp[0] = temp[0].replace("사진", "");
                StringName.add(temp[0]);
                Location.add(temp[1]);

                String temp2 = t.attr("data-original");
                int parsingindex = temp2.indexOf("?");
                PicURL.add(temp2.substring(0, parsingindex));
            }
            for(Element k : infos){
                String temp = k.attr("href");
                Info.add("https://www.mangoplate.com/"+ temp);
            }
            for (int a = 0; a < 14; a++) {
                if(!(PicURL.get(a).equals("/"))) {
                    DataSet_URL food = new DataSet_URL(StringName.get(a), PicURL.get(a),Info.get(a), Location.get(a));
                    foods.add(food);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        StringBuffer result = new StringBuffer();
        result.append("[");
        for(int a=0; a<3; a++){
            int random = (int) (Math.random() * foods.size());
            if(result.toString().contains(foods.get(random).toString())) a--;
            else {
                result.append(foods.get(random).toString());
                if(a<2) result.append(",");
            }
        }
        result.append("]");
        return result.toString();
    }

    public String crawlhotel(String data){
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