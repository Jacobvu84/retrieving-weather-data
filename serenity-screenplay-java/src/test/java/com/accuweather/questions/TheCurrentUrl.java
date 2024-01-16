package com.accuweather.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class TheCurrentUrl {
    public static Question<String> ofPage() {
        return actor -> BrowseTheWeb.as(actor).getDriver().getCurrentUrl();
    }
}
