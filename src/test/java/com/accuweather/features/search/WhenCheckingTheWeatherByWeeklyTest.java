package com.accuweather.features.search;

import com.accuweather.models.Menu;
import com.accuweather.models.Key;
import com.accuweather.models.Session;
import com.accuweather.models.Weather;
import com.accuweather.questions.TheInformation;
import com.accuweather.tasks.Visit;
import com.accuweather.tasks.VisitWeather;
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

    public static final int TODAY = 1;
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

        //Day & Night
        jacob.attemptsTo(
                //visit the weather from today until the end list of daily date on the page
                //VisitWeather.byAllOfDaily()
                Visit.theWeather(Session.DAILY).onDate(TODAY),
                Ensure.that(DailyView.DATE_DAILY).hasText(dayValue(TODAY))
        );

        /*
        //visit the weather from today until the next 16 days
        jacob.attemptsTo(
                VisitWeather.allBySession(Session.EVENING),
                VisitWeather.allBySession(Session.OVERNIGHT),
                VisitWeather.allBySession(Session.MORNING),
                VisitWeather.allBySession(Session.AFTERNOON)
        );*/

        // Evening
        jacob.attemptsTo(
                Visit.theWeather(Session.EVENING).onDate(TODAY),
                Ensure.that(DailyView.DATE).hasText(dateInformation(TODAY))
        );

        Weather evening = jacob.asksFor(TheInformation.ofWeather());
        Serenity.recordReportData().withTitle("Evening Weather").andContents(evening.toString());

        // overnight
        jacob.attemptsTo(
                Visit.theWeather(Session.OVERNIGHT).onDate(TODAY),
                Ensure.that(DailyView.DATE).hasText(dateInformation(TODAY))
        );

        Weather overnight = jacob.asksFor(TheInformation.ofWeather());
        Serenity.recordReportData().withTitle("Overnight Weather").andContents(overnight.toString());

        // morning
        jacob.attemptsTo(
                Visit.theWeather(Session.MORNING).onDate(TODAY),
                Ensure.that(DailyView.DATE).hasText(dateInformation(TODAY))
        );

        Weather morning = jacob.asksFor(TheInformation.ofWeather());
        Serenity.recordReportData().withTitle("Morning Weather").andContents(morning.toString());

        // afternoon
        jacob.attemptsTo(
                Visit.theWeather(Session.AFTERNOON).onDate(TODAY),
                Ensure.that(DailyView.DATE).hasText(dateInformation(TODAY))
        );

        Weather afternoon = jacob.asksFor(TheInformation.ofWeather());
        Serenity.recordReportData().withTitle("Afternoon Weather").andContents(afternoon.toString());
    }
}
