package com.dogbalbirdbal.controller;

import com.dogbalbirdbal.database.vo.PlaceInfo;
import com.dogbalbirdbal.database.vo.UserInfo;
import com.dogbalbirdbal.service.CrawlingService;
import com.dogbalbirdbal.service.UserService;
import java.util.HashMap;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class MainController {

    private final CrawlingService crawlingService;
    private final UserService userService;

    @PostMapping("/api/login")
    public HashMap<String, String> login(@RequestBody UserInfo userInfo) {
        return userService.login(userInfo);
    }

    @PostMapping("/api/signup")
    public String signup(@RequestBody UserInfo userInfo) {
        return userService.signUp(userInfo);
    }

    @GetMapping("/api/myinfo/{id}")
    public HashMap<String, String> myInfo(@PathVariable String id){
        return userService.myInfo(id);
    }

    @PostMapping("/api/myinfo/wishlist")
    public String addRoute(@RequestBody PlaceInfo placeInfo) {
        return userService.addRoute(placeInfo);
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
}
