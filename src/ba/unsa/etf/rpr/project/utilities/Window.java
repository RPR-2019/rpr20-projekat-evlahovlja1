package ba.unsa.etf.rpr.project.utilities;

import javafx.scene.Node;
import javafx.stage.Stage;

public class Window {
    public static void closeWindow(Node node) {
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
}
