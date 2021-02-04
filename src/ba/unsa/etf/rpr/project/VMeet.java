package ba.unsa.etf.rpr.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class VMeet extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/splashScreen.fxml"));
        primaryStage.setTitle("VMeet");
        primaryStage.setScene(new Scene(root));
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/ikona.jpg")));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
