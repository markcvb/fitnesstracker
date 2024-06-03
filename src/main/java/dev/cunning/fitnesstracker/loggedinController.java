package dev.cunning.fitnesstracker;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class loggedinController implements Initializable {

    @FXML
    private Button logoutButton;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label successfulLabel;


    @Override
    public void initialize(URL location, ResourceBundle resourceBundle){


        logoutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "Start.fxml", "Log In!", null, null);
            }
        });

    }

    public void setUserInformation(String username){
        usernameLabel.setText("Username: " + username + "!");
    }
}
