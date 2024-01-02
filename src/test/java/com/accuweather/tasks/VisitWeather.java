package com.accuweather.tasks;

import com.accuweather.models.Session;
import com.accuweather.models.Weather;
import com.accuweather.questions.TheInformation;
import com.accuweather.ui.DailyView;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;

import static com.accuweather.utils.DateUtils.dateInformation;
import static com.accuweather.utils.DateUtils.dayValue;

public class VisitWeather {
    public static Performable byAllOfDaily() {
        return Task.where("{0} visit the daily weather", actor -> {
            int durationOfDay = 45;
            for(int counter = 1; counter<= durationOfDay; counter++){
                //Day & Night
                actor.attemptsTo(
                        Visit.theWeather(Session.DAILY).onDate(counter),
                        Ensure.that(DailyView.DATE_DAILY).hasText(dayValue(counter))
                );
            }
        });
    }

    public static Performable allBySession(Session session) {
        return Task.where("", actor -> {
            for(int counter = 1; counter<= 16; counter++){

                // Evening
                actor.attemptsTo(
                        Visit.theWeather(session).onDate(counter),
                        Ensure.that(DailyView.DATE).hasText(dateInformation(counter))
                );

                Weather evening = actor.asksFor(TheInformation.ofWeather());
                Serenity.recordReportData().withTitle(session.name()+" Weather").andContents(evening.toString());
            }
        });
    }
}
