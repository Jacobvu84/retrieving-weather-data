package com.accuweather.questions;

import com.accuweather.models.Weather;
import com.accuweather.ui.DailyView;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheInformation implements Question<Weather> {

    public static Question<Weather> ofWeather() {
        return new TheInformation();
    }

    @Override
    public Weather answeredBy(Actor actor) {
        String temperature = Text.of(DailyView.TEMPERATURE).answeredBy(actor);
        String mainWeather = Text.of(DailyView.MAIN_WEATHER).answeredBy(actor);
        String realFeel =  Text.of(DailyView.REAL_FEEL).answeredBy(actor);
        String humidity =  Text.of(DailyView.MAIN_WEATHER).answeredBy(actor);

        return new Weather(temperature, mainWeather, realFeel, humidity);
    }
}
