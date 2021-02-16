package ba.unsa.etf.rpr.project.controllers;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(ApplicationExtension.class)
public class RegisterWindowTest {
    private Stage stage;


    @Start
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/registerWindow.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
        stage.toFront();
        this.stage = stage;
    }

    public static boolean hasStyle(TextField fld, String style) {
        for (String s : fld.getStyleClass())
            if (s.equals(style)) return true;
        return false;
    }

    @Test
    public void initialInvalidFieldsStyle(FxRobot fxRobot) {
        assertAll(
                () -> assertTrue(hasStyle(fxRobot.lookup("#txtFldUsername").queryAs(TextField.class), "invalid-field")),
                () -> assertTrue(hasStyle(fxRobot.lookup("#pswdFldPassword").queryAs(PasswordField.class), "invalid-field")),
                () -> assertTrue(hasStyle(fxRobot.lookup("#txtFldName").queryAs(TextField.class), "invalid-field")),
                () -> assertTrue(hasStyle(fxRobot.lookup("#txtFldLastname").queryAs(TextField.class), "invalid-field")),
                () -> assertTrue(hasStyle(fxRobot.lookup("#txtFldInstitution").queryAs(TextField.class), "invalid-field"))
        );
    }
}
