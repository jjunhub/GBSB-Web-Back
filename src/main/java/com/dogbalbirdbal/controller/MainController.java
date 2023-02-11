package com.dogbalbirdbal.controller;

import com.dogbalbirdbal.database.data.DataSet_URL;
import com.dogbalbirdbal.database.data.RouteInfo;
import com.dogbalbirdbal.database.manager.DataBaseServiceManager;
import com.dogbalbirdbal.database.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;


@RestController
public class MainController {
    static int count = 0; // variable for choice path
    @PostMapping("api/login/")
    public HashMap<String, String> login(@RequestBody UserInfo userInfo) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        boolean existData = false;

        try (Connection connect = DataBaseServiceManager.getInstance().getConnection()) {
            String sql = "select uid, name\n" +
                    "from myuser\n" +                            // table 선택
                    "where uid = ? and password = ?";            // 조건문 uid랑 password 입력받은 값이 일치하는지
            PreparedStatement p = connect.prepareStatement(sql); // 질의문을 작성할 것을 만든다.2
            p.setString(1, userInfo.getId());       // 이게 첫번째 물음표로 이동한다.
            p.setString(2, userInfo.getPassword()); // 이게 두번째 물음표로 이동한다.
            ResultSet resultSet = p.executeQuery();

            while (resultSet.next()) {
                stringStringHashMap.put("id", userInfo.getId());
                stringStringHashMap.put("name", resultSet.getString(2));
                stringStringHashMap.put("token", userInfo.getId());
                System.out.println(userInfo.getId() + " 로그인 성공");
                return stringStringHashMap;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        stringStringHashMap.put("id", "fail");
        stringStringHashMap.put("token", "-1");
        return stringStringHashMap;
    }
    @PostMapping("api/signup/")
    public String signup(@RequestBody UserInfo userInfo){

        try(Connection connect = DataBaseServiceManager.getInstance().getConnection()){
            String sql = "insert into MyUser(uid, name, password, email) values(?, ?, ?, ?)";
            PreparedStatement p = connect.prepareStatement(sql);
            p.setString(1, userInfo.getId());
            p.setString(2, userInfo.getName());
            p.setString(3, userInfo.getPassword());
            p.setString(4, userInfo.getEmail());
            p.executeUpdate();
            System.out.println("ID: " + userInfo.getId() + " NAME: " + userInfo.getName() + " PW: " + userInfo.getPassword() + " EMAIL: " + userInfo.getEmail());
            return "id : " + userInfo.getId() + ", name : " + userInfo.getName() + ", email : " + userInfo.getEmail() + ", password " + userInfo.getPassword();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("ID 중복");
        }
        return "Duplicate";
    }

    @GetMapping("api/myinfo/{id}")
    public HashMap<String, String> myInfoControllers(@PathVariable String id) {
        LinkedHashMap<String, String> stringStringLinkedHashMap = new LinkedHashMap<>();

        try(Connection connect = DataBaseServiceManager.getInstance().getConnection()){
            String sql1 = "select uid, name, email\n" +
                    "from MyUser\n" +
                    "where uid = ? ";
            PreparedStatement p1 = connect.prepareStatement(sql1);
            p1.setString(1, id);
            ResultSet resultSet1 = p1.executeQuery();

            while ( resultSet1.next() ) {
                System.out.println(resultSet1.getString(1) + " mypage");
                stringStringLinkedHashMap.put("id", resultSet1.getString(1));
                stringStringLinkedHashMap.put("name", resultSet1.getString(2));
                stringStringLinkedHashMap.put("email", resultSet1.getString(3));
            }
            String sql2 = "select string_to_array(route, ',') from wishlist";
            PreparedStatement p2 = connect.prepareStatement(sql2);
            ResultSet resultSet2 = p2.executeQuery();

            DataBaseServiceManager.getInstance().taskTransaction(connection -> {
                String sql3 = "select route from wishlist where uid = ?";
                PreparedStatement p3 = connection.prepareStatement(sql3);
                p3.setString(1, id);
                ResultSet resultSet = p3.executeQuery();
                WishContainer wishContainer = new WishContainer();

                while ( resultSet.next() ) {
                    WishBox wishBox = new WishBox();
                    String route = resultSet.getString(1);
                    JSONParser jsonParser = new JSONParser();

                    try {
                        JSONArray jsonArray = (JSONArray) jsonParser.parse(route);
                        jsonArray.forEach(o -> {
                            JSONObject jsonObject = (JSONObject) o;
                            String name = jsonObject.get("name").toString();
                            String picURL = jsonObject.get("pic_url").toString();
                            String info = jsonObject.get("info").toString();
                            wishBox.addWishList(new WishList(name,picURL,info));
                        });
                    } catch ( Exception e ) {
                        e.printStackTrace();
                    }
                    wishContainer.addWishBox(wishBox);
                }

                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    String jsonData = objectMapper.writeValueAsString(wishContainer);
                    stringStringLinkedHashMap.put("result", jsonData);
                } catch ( Exception e ) {
                    e.printStackTrace();
                }
            });
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return stringStringLinkedHashMap;
    }

    @GetMapping("/api/crawlingfood/{location}")
    public String crawlingController(@PathVariable("location") String location) {
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

    @GetMapping("/api/crawlinghotel/{data}")
    public String crawlingController2(@PathVariable("data") String data) {
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
        return result;
    }

    @GetMapping("api/choicepath/{destination}")
    public String choicepathController(@PathVariable("destination") String destination) {
        // 입력 예시는 "부산 힐링", "부산 식도락", "부산 오락".
        StringBuffer result = new StringBuffer();

        if(destination == null)  return "empty input";
        String[] urlSplit = destination.split(" ");
        if(urlSplit.length != 2) return "error";

        int pick_location = 0, pick_theme = 0;

        if(urlSplit[0].equals("부산")) pick_location = 0;
        else if(urlSplit[0].equals("대구")) pick_location = 1;
        else if(urlSplit[0].equals("수원")) pick_location = 2;

        if(urlSplit[1].equals("힐링")) pick_theme = 0;
        else if(urlSplit[1].equals("음식")) pick_theme = 1;
        else if(urlSplit[1].equals("커플")) pick_theme = 2;
        else if(urlSplit[1].equals("랜덤")) pick_theme = (int)(Math.random()*3);

        result.append("[").append(RouteInfo.GetRoute(pick_location, pick_theme, count++ % 6)).append(",");
        result.append(RouteInfo.GetRoute(pick_location, pick_theme, count++ %6)).append(",");
        result.append(RouteInfo.GetRoute(pick_location, pick_theme, count++ %6)).append("]");
        return result.toString();
    }

    @PostMapping("api/myinfo/wishlist/")
    public String routesender(@RequestBody PlaceInfo placeInfo){

        try(Connection connect = DataBaseServiceManager.getInstance().getConnection()){
            String sql = "insert into wishlist(uid, route) values(?, ?)";
            PreparedStatement p = connect.prepareStatement(sql);
            p.setString(1, placeInfo.getId());
            p.setString(2, placeInfo.getRoute());
            p.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "id : " + placeInfo.getId() + ", route " + placeInfo.getRoute();
    }
}
