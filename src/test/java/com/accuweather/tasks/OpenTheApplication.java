package com.accuweather.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import com.accuweather.ui.HomePage;
import net.thucydides.core.annotations.Step;

public class OpenTheApplication implements Task {

    HomePage homePage;

    @Step("Open the application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(homePage)
        );
    }
}
