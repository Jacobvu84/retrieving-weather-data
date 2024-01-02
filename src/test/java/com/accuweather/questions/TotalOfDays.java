package com.accuweather.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import com.accuweather.ui.DailyView;

public class TotalOfDays{
    public static Question<Integer> ofPeriod() {
        return actor -> BrowseTheWeb.as(actor).findAll(DailyView.DAYS).size();
    }
}
