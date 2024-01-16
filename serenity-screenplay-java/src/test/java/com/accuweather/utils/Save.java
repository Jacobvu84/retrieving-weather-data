package com.accuweather.utils;
import com.accuweather.models.Weather;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Save {

    public static void jsonFile(Weather weather, String fileName) {
        String filePath = String.join(".",DateUtils.getTime(),fileName.toLowerCase(),"json");

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(filePath), weather);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
