package com.accuweather.ui;

import net.serenitybdd.screenplay.targets.Target;

public class SettingUI {
    public static Target DAILY_VIEW = Target.the("{0} text")
            .locatedBy("//a[text()='{0}']");
}
