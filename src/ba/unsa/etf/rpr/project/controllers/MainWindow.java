package ba.unsa.etf.rpr.project.controllers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainWindow {
    private final String serverUrl = "http://localhost:8080";
    @FXML private Button btnInitSearch;
    @FXML private HBox hboxMainContent;

    private void runOnAnotherThread(Runnable function){
        new Thread(function).start();
    }

    private void getAllUsersFromServer() {
        runOnAnotherThread(() -> {
            try {
                URL url = new URL(serverUrl);
                URLConnection request = url.openConnection();
                request.connect();

                // Convert to a JSON object to print data
                JsonElement root = JsonParser.parseReader(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
                JsonArray rootobj = root.getAsJsonArray();
                for (JsonElement j : rootobj) {
                    System.out.println(j);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
                System.exit(-20);
            }
        });
    }


    public void initSearch(ActionEvent actionEvent) {
        getAllUsersFromServer();
        hboxMainContent.getChildren().remove(btnInitSearch);
        ImageView x = new ImageView(new Image("/images/x.jpg"));
        x.setFitHeight(30);
        x.setFitWidth(30);
        StackPane usersDisplay = new StackPane();
        usersDisplay.getChildren().add(new Label("Elvir"));
        usersDisplay.getChildren().add(new Label("Sanelaaaaa"));
        ImageView checkmark = new ImageView(new Image("/images/checkmark.png"));
        checkmark.setFitHeight(30);
        checkmark.setFitWidth(30);
        hboxMainContent.getChildren().addAll(x, usersDisplay, checkmark);
        checkmark.setOnMouseClicked(mouseEvent -> usersDisplay.getChildren().remove(usersDisplay.getChildren().size()-1));
    }
}
