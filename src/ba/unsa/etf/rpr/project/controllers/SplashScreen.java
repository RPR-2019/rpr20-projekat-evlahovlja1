package ba.unsa.etf.rpr.project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class SplashScreen {


    public void loginAction(ActionEvent actionEvent) throws Exception {

    }

    public void registerAction(ActionEvent actionEvent) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/registerWindow.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Registracija");
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/ikona.jpg")));
        stage.show();
    }
}
