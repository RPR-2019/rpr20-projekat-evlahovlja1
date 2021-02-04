package ba.unsa.etf.rpr.project.controllers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainWindow {
    private final String serverUrl = "http://localhost:8080";
    @FXML private Button btnInitSearch;

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
    }
}
