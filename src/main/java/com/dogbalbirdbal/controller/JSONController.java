package com.dogbalbirdbal.controller;

import com.dogbalbirdbal.database.data.DataSet_URL;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JSONController {
    public static int JSONchanger() throws IOException {
        File fl = new File("/Users/sangjun/GBSB-Web-Back/src/main/java/com/dogbalbirdbal/controller/DataSet");
        FileReader fir = new FileReader(fl);
        BufferedReader bfr = new BufferedReader(fir);
        String input_line;
        while((input_line = bfr.readLine())!= null) {
            //System.out.println(input_line);
            JSONObject jsonObject = new JSONObject(input_line);
            System.out.println(jsonObject);

            //System.out.println(jsonObject);
        }
//            DataSet_URL dataset_url = new DataSet_URL();
//        DataSet_URL dataset_url = new DataSet_URL();
//        JSONObject jsonObj;
//        jsonObj = new JSONObject(dataset_url);
//        System.out.println(jsonObj.toString());
//
//            //parsing한거 넣기


        return 0;
    }
}
