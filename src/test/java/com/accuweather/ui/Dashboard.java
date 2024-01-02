package com.accuweather.ui;

import net.serenitybdd.screenplay.targets.Target;

public class Dashboard {
    public static Target HAMBURGER_BUTTON = Target.the("hamburger button")
            .locatedBy("//*[local-name()='svg' and @data-qa='navigationMenu']");
}
