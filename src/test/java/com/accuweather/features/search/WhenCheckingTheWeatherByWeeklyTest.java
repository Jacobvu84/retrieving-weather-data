package com.accuweather.features.search;

import com.accuweather.models.Menu;
import com.accuweather.models.Key;
import com.accuweather.models.Session;
import com.accuweather.models.Weather;
import com.accuweather.questions.TheInformation;
import com.accuweather.tasks.Visit;
import com.accuweather.utils.Period;
import com.accuweather.questions.TotalOfDays;
import com.accuweather.ui.DailyView;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import com.accuweather.tasks.OpenTheApplication;
import com.accuweather.tasks.Navigate;
import com.accuweather.actions.Wait;
import com.accuweather.questions.TheCurrentUrl;

import static com.accuweather.utils.DateUtils.dateInformation;
import static com.accuweather.utils.DateUtils.dayValue;
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

        jacob.remember(Key.DAILY, TheCurrentUrl.ofPage());

        for(int counter = 1; counter<= durationOfDay; counter++){
            //Day & Night
            jacob.attemptsTo(
                    Visit.theWeather(Session.DAILY).onDate(counter),
                    Ensure.that(DailyView.DATE_DAILY).hasText(dayValue(counter))
            );
        }

        for(int counter = 1; counter<= 16; counter++){

            // Evening
            jacob.attemptsTo(
                    Visit.theWeather(Session.EVENING).onDate(counter),
                    Ensure.that(DailyView.DATE).hasText(dateInformation(counter))
            );

            Weather evening = jacob.asksFor(TheInformation.ofWeather());
            Serenity.recordReportData().withTitle("Evening Weather").andContents(evening.toString());

            // overnight
            jacob.attemptsTo(
                    Visit.theWeather(Session.OVERNIGHT).onDate(counter),
                    Ensure.that(DailyView.DATE).hasText(dateInformation(counter))
            );

            Weather overnight = jacob.asksFor(TheInformation.ofWeather());
            Serenity.recordReportData().withTitle("Overnight Weather").andContents(overnight.toString());
        }
    }
}
