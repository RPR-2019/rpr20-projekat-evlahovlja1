package ba.unsa.etf.rpr.project.controllers;

import ba.unsa.etf.rpr.project.dtos.User;
import ba.unsa.etf.rpr.project.utilities.Json;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

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

        String userId = Json.sendPost("http://localhost:8080", user.getJsonFormat());
        user.setId((long) Integer.parseInt(userId));
    }

    public void registerAction(ActionEvent actionEvent) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/registerWindow.fxml"));
//        loader.setController(new RegisterWindow());
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Registracija");
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/ikona.jpg")));
        stage.show();
    }
}
