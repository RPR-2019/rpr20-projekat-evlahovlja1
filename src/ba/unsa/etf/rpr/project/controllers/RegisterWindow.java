package ba.unsa.etf.rpr.project.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class RegisterWindow {
    @FXML private GridPane gridPaneInfo;

    private void addGenderRadioButtons() {
        final ToggleGroup genderRadioGroup = new ToggleGroup();
        RadioButton male = new RadioButton("M");
        male.setSelected(true);
        male.setToggleGroup(genderRadioGroup);
        RadioButton female = new RadioButton("F");
        female.setToggleGroup(genderRadioGroup);
        gridPaneInfo.add(new HBox(15, male,female), 1, 1);
    }

    private void finishGui() {
        addGenderRadioButtons();
    }


    @FXML public void initialize() {
        finishGui();
    }
}
