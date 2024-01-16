package com.accuweather.tasks;

//import net.serenitybdd.annotations.Step;
import com.accuweather.models.Menu;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.accuweather.ui.Dashboard;
import com.accuweather.ui.SettingUI;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.StringUtils;

public class Navigate implements Task {

    private final String menu;

    public Navigate(Menu menu) {
        this.menu = StringUtils.capitalize(menu.name().toLowerCase());
    }

    @Step("navigate to the #menu view")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(Dashboard.HAMBURGER_BUTTON),
                Click.on(SettingUI.DAILY_VIEW.of(menu))
        );
    }

    public static Navigate toViewOf(Menu menu) {
        return instrumented(Navigate.class, menu);
    }

}
