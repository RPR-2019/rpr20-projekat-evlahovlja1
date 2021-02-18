package ba.unsa.etf.rpr.project.controllers;


import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DialogPane;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @AfterEach
    public void closeAlert(FxRobot fxRobot) {
        Stage stage = getTopModalStage(fxRobot);
        if (stage != null) Platform.runLater(stage::close);
    }


    private static boolean hasStyle(TextField fld, String style) {
        for (String s : fld.getStyleClass())
            if (s.equals(style)) return true;
        return false;
    }



    private javafx.stage.Stage getTopModalStage(FxRobot fxRobot) {
        final List<Window> allWindows = new ArrayList<>(fxRobot.robotContext().getWindowFinder().listWindows());
        Collections.reverse(allWindows);

        return (javafx.stage.Stage) allWindows
                .stream()
                .filter(window -> window instanceof javafx.stage.Stage)
                .filter(window -> ((javafx.stage.Stage) window).getModality() == Modality.APPLICATION_MODAL)
                .findFirst()
                .orElse(null);
    }

    private void alertDialogHasContent(FxRobot fxRobot, final String expectedContent) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final javafx.stage.Stage actualAlertDialog = getTopModalStage(fxRobot);
        assertNotNull(actualAlertDialog);

        final DialogPane dialogPane = (DialogPane) actualAlertDialog.getScene().getRoot();
        assertTrue(dialogPane.getContentText().contains(expectedContent));
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

    @Test
    public void okButtonPressedWhileFieldsStillEmpty(FxRobot fxRobot) {
        fxRobot.clickOn("#btnOk");

        alertDialogHasContent(fxRobot, "Molimo popunite sva polja");
    }

    @Test
    public void usernameAlreadyExists(FxRobot fxRobot) {
        fxRobot.clickOn("#txtFldUsername").write("test");
        fxRobot.clickOn("#pswdFldPassword").write("test");
        fxRobot.clickOn("#txtFldName").write("test");
        fxRobot.clickOn("#txtFldLastname").write("test");
        fxRobot.clickOn("#txtFldInstitution").write("test");
        fxRobot.clickOn("#btnOk");
        alertDialogHasContent(fxRobot, "Username already taken");
    }

    @Test
    @Disabled
    //restriction that 2 users cannot have same firstname and lastname is removed
    public void userAlreadyExists(FxRobot fxRobot) {
        fxRobot.clickOn("#txtFldUsername").write("test2");
        fxRobot.clickOn("#pswdFldPassword").write("test2");
        fxRobot.clickOn("#txtFldName").write("test");
        fxRobot.clickOn("#txtFldLastname").write("test");
        fxRobot.clickOn("#txtFldInstitution").write("test");
        fxRobot.clickOn("#btnOk");
        alertDialogHasContent(fxRobot, "Firstname and lastname already taken");
    }

    @Test
    public void successfullyRegister(FxRobot fxRobot) {
        fxRobot.clickOn("#txtFldUsername").write("SUCCESS");
        fxRobot.clickOn("#pswdFldPassword").write("SUCCESS");
        fxRobot.clickOn("#txtFldName").write("SUCCESS");
        fxRobot.clickOn("#txtFldLastname").write("SUCCESS");
        fxRobot.clickOn("#txtFldInstitution").write("SUCCESS");
        fxRobot.clickOn("#btnOk");
        alertDialogHasContent(fxRobot, "uspjesna");
    }

    @Test
    @Disabled
    public void serverNotReachable(FxRobot fxRobot) {
        fxRobot.clickOn("#txtFldUsername").write("test2");
        fxRobot.clickOn("#pswdFldPassword").write("test2");
        fxRobot.clickOn("#txtFldName").write("test");
        fxRobot.clickOn("#txtFldLastname").write("test");
        fxRobot.clickOn("#txtFldInstitution").write("test");
        fxRobot.clickOn("#btnOk");
        alertDialogHasContent(fxRobot, "nedostupan");
    }
}
