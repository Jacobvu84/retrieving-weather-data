package com.accuweather.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather {
    private String temperature;
    private String mainWeather;
    private String realFeel;
    private String humidity;

    public Weather(String temperature, String mainWeather, String realFeel, String humidity) {
        this.temperature = temperature;
        this.mainWeather = mainWeather;
        this.realFeel = realFeel;
        this.humidity = humidity;
    }

    public String toString() {
        return "{\n" +
                "\t\"temperature\":\"" + temperature + "\",\n" +
                "\t\"mainWeather\":\"" + mainWeather + "\",\n" +
                "\t\"realFeel\":\"" + realFeel + "\",\n" +
                "\t\"humidity\":\"" + humidity + "\"\n" +
                "}";
    }

}
