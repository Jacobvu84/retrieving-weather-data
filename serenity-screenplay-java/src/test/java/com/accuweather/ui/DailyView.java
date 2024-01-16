package com.accuweather.ui;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class DailyView {
    public static final Target DAYS = Target.the("days")
            .locatedBy("//div[starts-with(@data-qa,'dailyCard')]");
    public static final Target DATE = Target.the("date title")
            .locatedBy("//div[@class='content-module subnav-pagination']/div");
    public static final Target DATE_DAILY = Target.the("date title")
            .locatedBy("//div[@class='subnav-pagination']/div");
    public static Target PERIOD = Target.the("period date")
            .locatedBy("css:p.module-title");
    public static Target TEMPERATURE = Target.the("temperature text")
            .locatedBy("css:div.weather div.temperature");
    public static Target MAIN_WEATHER = Target.the("main weather")
            .locatedBy("css:div.phrase");
    public static Target REAL_FEEL = Target.the("real feel")
            .locatedBy("css:div.real-feel > div:nth-child(1)");
    public static Target DETAIL_INFOR = Target.the("{0} text")
            .locatedBy("//p[text()='{0}']/span");

}
