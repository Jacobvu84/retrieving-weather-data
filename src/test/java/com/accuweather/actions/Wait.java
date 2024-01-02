package com.accuweather.actions;

import com.accuweather.tasks.Navigate;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class Wait {
    public static Performable aBit(long second) {
        return Task.where("{0} waits a bit", actor -> {
            try {
                Thread.sleep(second* 1_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
