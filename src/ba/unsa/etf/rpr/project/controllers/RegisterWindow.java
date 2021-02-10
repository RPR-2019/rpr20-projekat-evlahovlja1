package ba.unsa.etf.rpr.project.controllers;

import ba.unsa.etf.rpr.project.dtos.User;
import ba.unsa.etf.rpr.project.utilities.Json;
import ba.unsa.etf.rpr.project.utilities.Threading;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;

public class RegisterWindow {
    private char gender;
    @FXML private GridPane gridPaneInfo;
    @FXML private TextField txtFldUsername;
    @FXML private PasswordField pswdFldPassword;
    @FXML private TextField txtFldName;
    @FXML private TextField txtFldLastname;
    @FXML private DatePicker datePckrDateOfBirth;
    @FXML private ChoiceBox<String> choiceBoxCity;
    @FXML private CheckBox checkBoxStudent;
    @FXML private TextField txtFldInstitution;
    @FXML private ChoiceBox<String> choiceBoxFavoriteLang;
    @FXML private TextArea txtAreaAbout;

    private void addGenderRadioButtons() {
        final ToggleGroup genderRadioGroup = new ToggleGroup();
        RadioButton male = new RadioButton("M");
        male.setToggleGroup(genderRadioGroup);
        RadioButton female = new RadioButton("F");
        female.setToggleGroup(genderRadioGroup);

        genderRadioGroup.selectedToggleProperty().addListener((observableValue, oldVal, newVal) -> {
            if (newVal.equals(male)) {
                gender = 'M';
            }
            else {
                gender = 'F';
            }
        });
        male.setSelected(true);
        gridPaneInfo.add(new HBox(15, male,female), 1, 1);
    }

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
        choiceBoxFavoriteLang.setItems(FXCollections.observableList(List.of(
                "Python",
                "JavaScript",
                "Java",
                "C#",
                "C",
                "C++",
                "GO",
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

    private void validationStyle() {
        txtFldUsername.getStyleClass().add("invalid-field");
        txtFldUsername.textProperty().addListener((observableValue, o, n) -> {
            if (n.isEmpty() || n.isBlank()) {
                txtFldUsername.getStyleClass().remove("valid-field");
                txtFldUsername.getStyleClass().add("invalid-field");
            }
            else if ((o.isEmpty() || o.isBlank()) && !n.equals(o)) {
                txtFldUsername.getStyleClass().remove("invalid-field");
                txtFldUsername.getStyleClass().add("valid-field");
            }
        });

        pswdFldPassword.getStyleClass().add("invalid-field");
        pswdFldPassword.textProperty().addListener((observableValue, o, n) -> {
            if (n.isEmpty() || n.isBlank()) {
                pswdFldPassword.getStyleClass().removeAll("valid-field");
                pswdFldPassword.getStyleClass().add("invalid-field");
            }
            else if ((o.isEmpty() || o.isBlank()) && !n.equals(o)) {
                pswdFldPassword.getStyleClass().removeAll("invalid-field");
                pswdFldPassword.getStyleClass().add("valid-field");
            }
        });

        txtFldName.getStyleClass().add("invalid-field");
        txtFldName.textProperty().addListener((observableValue, o, n) -> {
            System.out.println(n);
            if (n.isEmpty() || n.isBlank()) {
                txtFldName.getStyleClass().remove("valid-field");
                txtFldName.getStyleClass().add("invalid-field");
            }
            else if ((o.isEmpty() || o.isBlank()) && !n.equals(o)) {
                txtFldName.getStyleClass().remove("invalid-field");
                txtFldName.getStyleClass().add("valid-field");
            }
        });

        txtFldLastname.getStyleClass().add("invalid-field");
        txtFldLastname.textProperty().addListener((observableValue, o, n) -> {
            if (n.isEmpty() || n.isBlank()) {
                txtFldLastname.getStyleClass().remove("valid-field");
                txtFldLastname.getStyleClass().add("invalid-field");
            }
            else if ((o.isEmpty() || o.isBlank()) && !n.equals(o)) {
                txtFldLastname.getStyleClass().remove("invalid-field");
                txtFldLastname.getStyleClass().add("valid-field");
            }
        });

        txtFldInstitution.getStyleClass().add("invalid-field");
        txtFldInstitution.textProperty().addListener((observableValue, o, n) -> {
            if (n.isEmpty() || n.isBlank()) {
                txtFldInstitution.getStyleClass().remove("valid-field");
                txtFldInstitution.getStyleClass().add("invalid-field");
            }
            else if ((o.isEmpty() || o.isBlank()) && !n.equals(o)) {
                txtFldInstitution.getStyleClass().remove("invalid-field");
                txtFldInstitution.getStyleClass().add("valid-field");
            }
        });
    }

    private void finishGui() {
        addGenderRadioButtons();
        addCityOptions();
        addLanguageOptions();
        datePckrDateOfBirth.setValue(LocalDate.now());
        validationStyle();
    }


    @FXML public void initialize() {
        finishGui();

    }

    public void okAction(ActionEvent actionEvent) {
        Threading.runOnAnotherThread(() -> {
            try {
                HashMap<String, String> payload = new HashMap<>();
                payload.put("username", txtFldUsername.getText());
                payload.put("password", pswdFldPassword.getText());
                String sendablePayload = Json.generatePayload(payload);
                String ret = Json.sendPost("http://localhost:8080/cred", sendablePayload);
                System.out.println(ret);

                User user = new User(
                        txtFldName.getText(),
                        txtFldLastname.getText(),
                        gender,
                        datePckrDateOfBirth.getValue(),
                        Period.between(datePckrDateOfBirth.getValue(), LocalDate.now()).getYears(),
                        choiceBoxCity.getValue(),
                        checkBoxStudent.isSelected(),
                        txtFldInstitution.getText(),
                        choiceBoxFavoriteLang.getValue(),
                        txtAreaAbout.getText()
                );
                ret = Json.sendPost("http://localhost:8080", user.getJsonFormat());
                System.out.println(ret);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(-20);
            }
        });
    }

    public void cancelAction(ActionEvent actionEvent) {

    }
}
