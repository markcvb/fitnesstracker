package dev.cunning.fitnesstracker;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class SignUpForm extends Application{

    //@Override is instructing the compiler that it is overriding a super function
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Signup Form");

        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Button signupButton = new Button("Sign Up");

        GridPane gridpane = new GridPane();
        gridpane.setVgap(10);
        gridpane.setHgap(10);

        gridpane.add(usernameLabel, 0, 0);
        gridpane.add(usernameField, 1, 0);
        gridpane.add(emailLabel, 0, 1);
        gridpane.add(emailField, 1, 1);
        gridpane.add(passwordLabel, 0, 2);
        gridpane.add(passwordField, 1, 2);
        gridpane.add(signupButton, 1, 4);

        Scene scene = new Scene(gridpane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
