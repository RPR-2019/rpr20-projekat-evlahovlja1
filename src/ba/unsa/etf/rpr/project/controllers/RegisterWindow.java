package ba.unsa.etf.rpr.project.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class RegisterWindow {
    @FXML
    GridPane gridPaneInfo;

    public Node getNodeByRowColumnIndex (final int row, final int column) {
        Node result = null;
        ObservableList<Node> childrens = gridPaneInfo.getChildren();

        for (Node node : childrens) {
            if(gridPaneInfo.getRowIndex(node) == row && gridPaneInfo.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }

        return result;
    }

    private void finishGui() {
        final ToggleGroup genderRadioGroup = new ToggleGroup();
        RadioButton male = new RadioButton("M");
        male.setToggleGroup(genderRadioGroup);
        RadioButton female = new RadioButton("F");
        female.setToggleGroup(genderRadioGroup);
        gridPaneInfo.add(new HBox(15, male,female), 1, 1);

    }

    @FXML public void initialize() {
        finishGui();
    }
}
