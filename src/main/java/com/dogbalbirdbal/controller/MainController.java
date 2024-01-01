package com.dogbalbirdbal.controller;

import com.dogbalbirdbal.database.manager.DataBaseServiceManager;
import com.dogbalbirdbal.database.vo.PlaceInfo;
import com.dogbalbirdbal.database.vo.UserInfo;
import com.dogbalbirdbal.database.vo.WishBox;
import com.dogbalbirdbal.database.vo.WishContainer;
import com.dogbalbirdbal.database.vo.WishList;
import com.dogbalbirdbal.service.CrawlingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class MainController {

    private final CrawlingService crawlingService;
    private final DataBaseServiceManager dataBaseServiceManager;

    @PostMapping("api/login/")
    public HashMap<String, String> login(@RequestBody UserInfo userInfo) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        boolean existData = false;

        try (Connection con = dataBaseServiceManager.getConnection()) {
            String sql = "select uid, name from myuser where uid = ? and password = ?";
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, userInfo.getId());
            p.setString(2, userInfo.getPassword());
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
    public String signup(@RequestBody UserInfo userInfo) {

        try (Connection connect = dataBaseServiceManager.getConnection()) {
            String sql = "insert into MyUser(uid, name, password, email) values(?, ?, ?, ?)";
            PreparedStatement p = connect.prepareStatement(sql);
            p.setString(1, userInfo.getId());
            p.setString(2, userInfo.getName());
            p.setString(3, userInfo.getPassword());
            p.setString(4, userInfo.getEmail());
            p.executeUpdate();
            System.out.println(
                    "ID: " + userInfo.getId() + " NAME: " + userInfo.getName() + " PW: " + userInfo.getPassword()
                            + " EMAIL: " + userInfo.getEmail());
            return "id : " + userInfo.getId() + ", name : " + userInfo.getName() + ", email : " + userInfo.getEmail()
                    + ", password " + userInfo.getPassword();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("ID 중복");
        }
        return "Duplicate";
    }

    @GetMapping("api/myinfo/{id}")
    public HashMap<String, String> myInfoControllers(@PathVariable String id) throws SQLException {
        LinkedHashMap<String, String> stringStringLinkedHashMap = new LinkedHashMap<>();

        try (Connection connect = dataBaseServiceManager.getConnection()) {
            String sql1 = "select uid, name, email\n" +
                    "from MyUser\n" +
                    "where uid = ? ";
            PreparedStatement p1 = connect.prepareStatement(sql1);
            p1.setString(1, id);
            ResultSet resultSet1 = p1.executeQuery();

            while (resultSet1.next()) {
                System.out.println(resultSet1.getString(1) + " mypage");
                stringStringLinkedHashMap.put("id", resultSet1.getString(1));
                stringStringLinkedHashMap.put("name", resultSet1.getString(2));
                stringStringLinkedHashMap.put("email", resultSet1.getString(3));
            }
            String sql2 = "select string_to_array(route, ',') from wishlist";
            PreparedStatement p2 = connect.prepareStatement(sql2);
            ResultSet resultSet2 = p2.executeQuery();

            try (Connection connection2 = dataBaseServiceManager.getConnection()) {
                String sql3 = "select route from wishlist where uid = ?";
                PreparedStatement p3 = connection2.prepareStatement(sql3);
                p3.setString(1, id);
                ResultSet resultSet = p3.executeQuery();
                WishContainer wishContainer = new WishContainer();

                while (resultSet.next()) {
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
                            wishBox.addWishList(new WishList(name, picURL, info));
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    wishContainer.addWishBox(wishBox);
                }

                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    String jsonData = objectMapper.writeValueAsString(wishContainer);
                    stringStringLinkedHashMap.put("result", jsonData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
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

    @GetMapping("api/choicepath/{pathInfo}")
    public String choicepathController(@PathVariable("pathInfo") String pathInfo) {
        // 입력 예시는 "부산 힐링", "부산 식도락", "부산 오락".
        if (pathInfo.split(" ").length != 2) {
            return "잘못된 입력입니다.";
        }
        String destination = pathInfo.split(" ")[0];
        String theme = pathInfo.split(" ")[1];

        return crawlingService.selectPath(destination, theme);
    }

    @PostMapping("api/myinfo/wishlist/")
    public String routesender(@RequestBody PlaceInfo placeInfo) {

        try (Connection connect = dataBaseServiceManager.getConnection()) {
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
