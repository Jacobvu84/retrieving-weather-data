package com.accuweather.features.search;

import com.accuweather.models.Menu;
import com.accuweather.models.Period;
import com.accuweather.questions.TotalOfDays;
import com.accuweather.ui.DailyView;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ensure.web.ElementLocated;
import net.serenitybdd.screenplay.ensure.web.ElementsLocated;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import com.accuweather.tasks.OpenTheApplication;
import com.accuweather.tasks.Navigate;
import com.accuweather.actions.Wait;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

@RunWith(SerenityRunner.class)
public class WhenCheckingTheWeatherByWeeklyTest {

    Actor jacob = Actor.named("Jacob");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenTheApplication openTheApplication;

    @Before
    public void jacobCanBrowseTheWeb() {
        jacob.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void check_results_should_show_the_weather_information_by_daily() {

        int durationOfDay = 45;

        givenThat(jacob).wasAbleTo(openTheApplication);

        when(jacob).attemptsTo(
                Navigate.toViewOf(Menu.DAILY),
                Wait.aBit(5),
                Ensure.that(DailyView.PERIOD).hasText(Period.of(durationOfDay)),
                Ensure.that("total days display in view",
                        TotalOfDays.ofPeriod()).isEqualTo(durationOfDay)
        );
    }
}
