package com.dogbalbirdbal.coreserver;

import com.dogbalbirdbal.database.manager.DataBaseServiceManager;
import com.dogbalbirdbal.database.vo.WishBox;
import com.dogbalbirdbal.database.vo.WishContainer;
import com.dogbalbirdbal.database.vo.WishList;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.sql.ResultSet;

@SpringBootApplication
@ComponentScan ( basePackages = {"com.dogbalbirdbal.controller"})
public class CoreServerApplication {

    public static void main(String[] args) {
        DataBaseServiceManager.getInstance().loadDataSource("postgres", "sangjun0206",
                "127.0.0.1", 5432, "GBSB_JUN");
        SpringApplication.run(CoreServerApplication.class, args);
        System.out.println("테스트!");
    }



}
