package com.dogbalbirdbal.service;

import com.dogbalbirdbal.database.vo.LoginForm;
import com.dogbalbirdbal.database.vo.LoginResponse;
import com.dogbalbirdbal.database.vo.PlaceInfo;
import com.dogbalbirdbal.database.vo.UserInfo;
import com.dogbalbirdbal.database.vo.UserMyPageInfo;
import com.dogbalbirdbal.database.vo.WishBox;
import com.dogbalbirdbal.database.vo.WishContainer;
import com.dogbalbirdbal.database.vo.WishList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final NamedParameterJdbcTemplate template;

    public UserService(DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
    }

    public LoginResponse login(LoginForm loginForm) {
        String sql = "select name from myuser where uid=:id and password=:password";
        SqlParameterSource param = new BeanPropertySqlParameterSource(loginForm);
        try {
            String name = template.queryForObject(sql, param, String.class);
            return LoginResponse.builder()
                    .id(loginForm.getId())
                    .name(name)
                    .token(name)
                    .build();

        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return LoginResponse.builder()
                    .id("fail")
                    .name("fail")
                    .token("-1")
                    .build();
        }
    }

    public String signUp(UserInfo userInfo) {
        String sql = "insert into MyUser(uid, name, password, email) values(:id, :name, :password, :email)";
        SqlParameterSource param = new BeanPropertySqlParameterSource(userInfo);
        try {
            template.update(sql, param);
            return userInfo.getName() + "님 회원가입을 축하합니다.";
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            System.out.println("ID 중복");
            return "Duplicate";
        }
    }

    public UserMyPageInfo myInfo(String id) {
        UserMyPageInfo userMyPageInfo = new UserMyPageInfo();

        String sql1 = "SELECT uid, name, email FROM MyUser WHERE uid = :id";
        Map<String, Object> paramMap = Collections.singletonMap("id", id);
        try {
            Map<String, Object> result = template.queryForMap(sql1, paramMap);
            userMyPageInfo.setId((String) result.get("uid"));
            userMyPageInfo.setName((String) result.get("name"));
            userMyPageInfo.setEmail((String) result.get("email"));
        } catch (EmptyResultDataAccessException ex) {
            ex.printStackTrace();
            return null;
        }

        String sql2 = "SELECT route FROM wishlist WHERE uid = :id";
        try {
            List<Map<String, Object>> rows = template.queryForList(sql2, paramMap);
            WishContainer wishContainer = new WishContainer();
            for (Map<String, Object> row : rows) {
                String route = (String) row.get("route");
                JSONParser jsonParser = new JSONParser();

                try {
                    JSONArray jsonArray = (JSONArray) jsonParser.parse(route);
                    WishBox wishBox = new WishBox();
                    for (Object o : jsonArray) {
                        JSONObject jsonObject = (JSONObject) o;
                        String name = jsonObject.get("name").toString();
                        String picURL = jsonObject.get("pic_url").toString();
                        String info = jsonObject.get("info").toString();
                        WishList wishList = new WishList(name, picURL, info);
                        wishBox.addWishList(wishList);
                    }
                    wishContainer.addWishBox(wishBox);
                } catch (ParseException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            userMyPageInfo.setWishContainer(wishContainer);
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return null;
        }
        return userMyPageInfo;
    }


    public String addRoute(PlaceInfo placeInfo) {
        String sql = "insert into wishlist(uid, route) values(:id, :route)";
        SqlParameterSource param = new BeanPropertySqlParameterSource(placeInfo);
        template.update(sql, param);
        return "id : " + placeInfo.getId() + ", route " + placeInfo.getRoute();
    }
}
