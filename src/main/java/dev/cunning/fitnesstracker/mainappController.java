package dev.cunning.fitnesstracker;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
/*
public class mainappController implements Initializable {

    @FXML
    private TextField nameField;
    @FXML
    private TextField typeField;
    @FXML
    private TextField setsField;
    @FXML
    private TextField repsField;

    @FXML
    private Label exercise1Label;
    @FXML
    private Label exercise2Label;
    @FXML
    private Label exercise3Label;
    @FXML
    private Label exercise4Label;
    @FXML
    private Label exercise5Label;
    @FXML
    private Label exercise6Label;
    @FXML
    private Label exercise7Label;
    @FXML
    private Label exercise8Label;
    @FXML
    private Label exercise9Label;
    @FXML
    private Label exercise10Label;

    @FXML
    private Button submitButton;

    private ArrayList<Label> labelList = new ArrayList<Label>();
    private ArrayList<Exercise> exerciseList = new ArrayList<Exercise>();

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle){
    labelList.add(exercise1Label); labelList.add(exercise2Label); labelList.add(exercise3Label); labelList.add(exercise4Label); labelList.add(exercise5Label); labelList.add(exercise6Label); labelList.add(exercise7Label); labelList.add(exercise8Label); labelList.add(exercise9Label); labelList.add(exercise10Label);


    submitButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if(exerciseList.isEmpty()){
            if (exerciseList.size() > 10) {
                System.out.println("no mas");
            } else {
                exerciseList.add(new Exercise(nameField.getText(), typeField.getText(), setsField.getText(), repsField.getText() ));

            }




        }
    });

    }
                          ){

    }

}
*/