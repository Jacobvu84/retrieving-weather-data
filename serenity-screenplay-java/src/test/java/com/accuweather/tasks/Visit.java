package com.accuweather.tasks;

import com.accuweather.models.Key;
import com.accuweather.models.Session;
import com.accuweather.utils.UrlHelper;
import com.ibm.icu.text.CurrencyMetaInfo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class Visit {
    public static VisitBuilder theWeather(Session session) {
        return new VisitBuilder(session);
    }

    public static class VisitBuilder{

        private Session session;
        public VisitBuilder(Session session) {
            this.session = session;
        }

        public Performable onDate(int dayIndex) {
            return Task.where("{0} visits the "+session+" weather",
                    actor -> {
                        String url =actor.recall(Key.DAILY);
                        String newUrl = UrlHelper.changeTheUrl(url, session);

                        actor.attemptsTo(
                                Open.url(newUrl + "?day="+dayIndex)
                        );
                    });
        }
    }
}
