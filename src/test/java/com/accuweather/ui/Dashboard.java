package com.accuweather.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Dashboard {
    public static Target HAMBURGER_BUTTON = Target.the("hamburger button")
            .locatedBy("//*[local-name()='svg' and @data-qa='navigationMenu']");
}
