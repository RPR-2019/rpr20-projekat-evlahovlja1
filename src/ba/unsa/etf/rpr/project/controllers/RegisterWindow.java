package ba.unsa.etf.rpr.project.controllers;

import ba.unsa.etf.rpr.project.dtos.User;
import ba.unsa.etf.rpr.project.utilities.Window;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.List;

public class RegisterWindow {
    private char gender = 'M';
    @FXML private GridPane gridPaneInfo;
    @FXML private TextField txtFldUsername;
    @FXML private PasswordField pswdFldPassword;
    @FXML private TextField txtFldName;
    @FXML private TextField txtFldLastname;
    @FXML private ToggleGroup tglGroupGender;
    @FXML private RadioButton radioBtnGenderM;
    @FXML private RadioButton radioBtnGenderF;
    @FXML private DatePicker datePckrDateOfBirth;
    @FXML private ChoiceBox<String> choiceBoxCity;
    @FXML private CheckBox checkBoxStudent;
    @FXML private TextField txtFldInstitution;
    @FXML private ChoiceBox<String> choiceBoxCurrentLang;
    @FXML private ChoiceBox<String> choiceBoxFavoriteLang;
    @FXML private TextArea txtAreaAbout;
    @FXML private Button btnClose;
    @FXML private Button btnOk;
    @FXML private ImageView imgViewLoading;

    private void addCityOptions() {
        choiceBoxCity.setItems(FXCollections.observableList(List.of(
                "Sarajevo",
                "Banja Luka",
                "Tuzla",
                "Zenica",
                "Mostar",
                "Istocno Sarajevo",
                "Bihac",
                "Brcko",
                "Bijeljina",
                "Prijedor",
                "Trebinje",
                "Travnik",
                "Kiseljak",
                "Doboj",
                "Cazin",
                "Bugojno",
                "Velika Kladusa",
                "Visoko",
                "Gorazde",
                "Konjic",
                "Gracanica",
                "Gradacac",
                "Bosanska Krupa",
                "Mrkonjic Grad",
                "Foca",
                "Zavidovici",
                "Zivinice",
                "Sanski Most",
                "Bosanska Gradiska",
                "Bileca",
                "Lukavac",
                "Kakanj",
                "Livno",
                "Odzak",
                "Sipovo",
                "Prozor",
                "Novi Travnik"
        )).sorted());
        choiceBoxCity.getSelectionModel().select(0);
    }

    private void addLanguageOptions() {
        choiceBoxCurrentLang.setItems(FXCollections.observableList(List.of(
                "Python",
                "JavaScript",
                "Java",
                "C#",
                "C",
                "C++",
                "Go",
                "R",
                "Swift",
                "PHP",
                "Dart",
                "Kotlin",
                "Ruby",
                "Perl",
                "Rust",
                "Objective C",
                "Assembly"
        )).sorted());
        choiceBoxCurrentLang.getSelectionModel().select(0);

        choiceBoxFavoriteLang.setItems(FXCollections.observableList(List.of(
                "Python",
                "JavaScript",
                "Java",
                "C#",
                "C",
                "C++",
                "Go",
                "R",
                "Swift",
                "PHP",
                "Dart",
                "Kotlin",
                "Ruby",
                "Perl",
                "Rust",
                "Objective C",
                "Assembly"
        )).sorted());
        choiceBoxFavoriteLang.getSelectionModel().select(0);
    }

    private void addValidationStyleListener(TextField field) {
        field.getStyleClass().add("invalid-field");
        field.textProperty().addListener((observableValue, o, n) -> {
            if (n.isEmpty() || n.isBlank()) {
                field.getStyleClass().remove("valid-field");
                field.getStyleClass().add("invalid-field");
            }
            else if ((o.isEmpty() || o.isBlank()) && !n.equals(o)) {
                field.getStyleClass().remove("invalid-field");
                field.getStyleClass().add("valid-field");
            }
        });
    }

    private void validationStyle() {
        addValidationStyleListener(txtFldUsername);
        addValidationStyleListener(pswdFldPassword);
        addValidationStyleListener(txtFldName);
        addValidationStyleListener(txtFldLastname);
        addValidationStyleListener(txtFldInstitution);
    }

    private void genderListener() {
        tglGroupGender.selectedToggleProperty().addListener((observableValue, o, n) -> {
            if (n.equals(radioBtnGenderM)) gender = 'M';
            else gender = 'F';
            System.out.println(gender);
        });
    }

    private void finishGui() {
        addCityOptions();
        addLanguageOptions();
        datePckrDateOfBirth.setValue(LocalDate.now());
        validationStyle();
        genderListener();
    }

    private boolean anyFieldInvalid() {
        return txtFldUsername.getStyleClass().contains("invalid-field") ||
                pswdFldPassword.getStyleClass().contains("invalid-field") ||
                txtFldName.getStyleClass().contains("invalid-field") ||
                txtFldLastname.getStyleClass().contains("invalid-field") ||
                txtFldInstitution.getStyleClass().contains("invalid-field");
    }

    private void createAlert(Alert.AlertType type, String title, String header, String text) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(text);
        alert.showAndWait();
    }

    private User createUserFromFields() {
        return new User(
                txtFldUsername.getText().trim(),
                txtFldName.getText().trim(),
                txtFldLastname.getText().trim(),
                gender,
                datePckrDateOfBirth.getValue(),
                choiceBoxCity.getValue(),
                checkBoxStudent.isSelected(),
                txtFldInstitution.getText().trim(),
                choiceBoxCurrentLang.getValue(),
                choiceBoxFavoriteLang.getValue(),
                txtAreaAbout.getText().trim()
        );
    }

    private void openLoginWindow() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/loginWindow.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Prijava");
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/ikona.jpg")));
        stage.show();
    }


    @FXML public void initialize() {
        finishGui();
    }

    public void okAction(ActionEvent actionEvent) {

        if (anyFieldInvalid())
        {
            createAlert(Alert.AlertType.ERROR, "Prazno polje", "Nijedno polje ne smije biti prazno", "Molimo popunite sva polja");
            return;
        }

        Image loading = new Image("/images/loading.gif");
        this.imgViewLoading.setFitWidth(30);
        this.imgViewLoading.setFitHeight(30);
        this.imgViewLoading.setImage(loading);
    }

    public void cancelAction(ActionEvent actionEvent) {
        Window.closeWindow(btnClose);
    }
}
