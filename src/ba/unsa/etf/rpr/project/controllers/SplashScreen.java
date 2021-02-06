package ba.unsa.etf.rpr.project.controllers;

import ba.unsa.etf.rpr.project.dtos.User;
import ba.unsa.etf.rpr.project.utilities.Json;
import javafx.event.ActionEvent;

import java.time.LocalDate;
import java.time.Period;

public class SplashScreen {


    public void loginAction(ActionEvent actionEvent) throws Exception {
        User user = new User(
                null,
                "test",
                "testovic",
                'F',
                LocalDate.of(2000, 01, 01),
                Period.between(LocalDate.of(2000, 01, 01), LocalDate.now()).getYears(),
                "Varvare",
                false,
                "ETF",
                "C#",
                "beze nesto"
        );

        String userId = Json.sendRequest("http://localhost:8080", user.getJsonFormat());
        user.setId((long) Integer.parseInt(userId));
    }
}
