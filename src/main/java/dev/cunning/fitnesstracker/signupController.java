package dev.cunning.fitnesstracker;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class signupController implements Initializable {

    @FXML
    private Button signupButton;
    @FXML
    private Button loginButton;

    @FXML
    private RadioButton zoomerRadio;
    @FXML
    private RadioButton boomerRadio;

    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;

    @Override
    public void initialize(URL location, ResourceBundle resouces) {
        ToggleGroup toggleGroup = new ToggleGroup();
        zoomerRadio.setToggleGroup(toggleGroup);
        boomerRadio.setToggleGroup(toggleGroup);

        zoomerRadio.setSelected(true);

        signupButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String toggleName = ((RadioButton) toggleGroup.getSelectedToggle()).getText();

                boolean toggleBool;
                toggleBool = toggleName != "Zoomer";

                if(!usernameField.getText().trim().isEmpty() && !passwordField.getText().trim().isEmpty()) {
                    DBUtils.signUpUser(event, usernameField.getText(), passwordField.getText(), toggleBool);
                } else {
                    System.out.println("Please fill all information");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill in all information");
                    alert.show();
                }
            }


        });

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "Start.fxml", "Log in!", null, null);
            }
        });

    }


}
