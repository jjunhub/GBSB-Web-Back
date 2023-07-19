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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.dogbalbirdbal.service.CrawlingService;


@RestController
public class MainController {

    @Autowired
    CrawlingService crawlingService;

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
    public String crawlingfood(@PathVariable("location") String location) {
        return crawlingService.crawlfood(location);
    }

    @GetMapping("/api/crawlinghotel/{data}")
    public String crawlinghotel(@PathVariable("data") String data) {
        return crawlingService.crawlhotel(data);
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
