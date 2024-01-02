package com.accuweather.ui;

import net.serenitybdd.screenplay.targets.Target;

public class DailyView {
    public static final Target DAYS = Target.the("days")
            .locatedBy("//div[starts-with(@data-qa,'dailyCard')]");
    public static Target PERIOD = Target.the("period date")
            .locatedBy("css:p.module-title");
}
