package com.accuweather.features.search;

//import net.serenitybdd.annotations.Managed;
//import net.serenitybdd.annotations.Steps;
import com.accuweather.models.Menu;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import com.accuweather.tasks.OpenTheApplication;
import com.accuweather.tasks.Navigate;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
public class WhenCheckingTheWeatherByWeeklyTest {

    Actor jacob = Actor.named("Jacob");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenTheApplication openTheApplication;

    @Before
    public void annaCanBrowseTheWeb() {
        jacob.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void check_results_should_show_the_weather_information_by_daily() {

        givenThat(jacob).wasAbleTo(openTheApplication);

        when(jacob).attemptsTo(Navigate.toViewOf(Menu.DAILY));



    }
}