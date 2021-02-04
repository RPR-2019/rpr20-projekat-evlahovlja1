package ba.unsa.etf.rpr.project.controllers;

import ba.unsa.etf.rpr.project.dtos.User;
import com.google.gson.*;
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
import java.time.LocalDate;
import java.util.ArrayList;

public class MainWindow {
    private final String SERVER_URL = "http://localhost:8080";
    private final Integer IMAGEVIEWS_SIZE = 50;
    @FXML private Button btnInitSearch;
    @FXML private HBox hboxMainContent;

    private void runOnAnotherThread(Runnable function){
        new Thread(function).start();
    }

    private void getAllUsersFromServer() {
        runOnAnotherThread(() -> {
            try {
                URL url = new URL(SERVER_URL);
                URLConnection request = url.openConnection();
                request.connect();

                // Convert to a JSON object to print data
                JsonElement allUsersJson = JsonParser.parseReader(new InputStreamReader((InputStream) request.getContent()));
                JsonArray allUsersJsonArray = allUsersJson.getAsJsonArray();

                Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class,
                        (JsonDeserializer<LocalDate>) (jsonElement, type, jsonDeserializationContext) ->
                                LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString()))
                        .create();

                ArrayList<User> users = new ArrayList<>();

                for (JsonElement j : allUsersJsonArray) {
                    users.add(gson.fromJson(j, User.class));
                }

                System.out.println(users);
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
        ImageView x = new ImageView(new Image("/images/x.png"));
        x.setFitHeight(IMAGEVIEWS_SIZE);
        x.setFitWidth(IMAGEVIEWS_SIZE);
        StackPane usersDisplay = new StackPane();
        usersDisplay.getChildren().add(new Label("Elvir"));
        usersDisplay.getChildren().add(new Label("Sanelaaaaa"));
        ImageView checkmark = new ImageView(new Image("/images/checkmark.png"));
        checkmark.setFitHeight(IMAGEVIEWS_SIZE);
        checkmark.setFitWidth(IMAGEVIEWS_SIZE);
        hboxMainContent.getChildren().addAll(x, usersDisplay, checkmark);
        checkmark.setOnMouseClicked(mouseEvent -> usersDisplay.getChildren().remove(usersDisplay.getChildren().size()-1));
    }
}
