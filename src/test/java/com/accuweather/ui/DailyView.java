package com.accuweather.ui;

import net.serenitybdd.screenplay.targets.Target;

public class DailyView {
    public static Target TITLE = Target.the("period date")
            .locatedBy("css:p.module-title");
}
