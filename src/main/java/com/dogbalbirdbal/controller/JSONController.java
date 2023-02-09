package com.dogbalbirdbal.controller;

import com.dogbalbirdbal.database.data.DataSet_URL;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JSONController {
    public static int JSONchanger() throws IOException {
        File fl = new File("/Users/sangjun/GBSB-Web-Back/src/main/java/com/dogbalbirdbal/controller/DataSet.txt");
        FileReader fir = new FileReader(fl);
        BufferedReader bfr = new BufferedReader(fir);
        String line = "";
        while ((line = bfr.readLine()) != null) {
            JSONObject jsonObj = new JSONObject(line);
            System.out.println(jsonObj.toString());
        }
        return 0;
    }
}
