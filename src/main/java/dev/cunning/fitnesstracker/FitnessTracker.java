package dev.cunning.fitnesstracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

// #FFA500 Orange
// #FFFFFF White

public class FitnessTracker extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FitnessTracker.class.getResource("Start.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Welcome!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
        DBUtils.getConnection();
        //this is to create a sample user
        /*try {
            DBUtils.uploadUser(new User(-1, "user", "password", "samplename", true));
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        try {
            for (int uuid : DBUtils.retrieveUuids()) {
                System.out.println(uuid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try{
            //this finds the uuid of 7 and prints the username of that person
            User u = DBUtils.retrieveUserInfoUUID(7);
            System.out.println(u.getUsername());

            //this finds the first username of tyler (maybe we should make usernames unique) and then prints the password of that user
            User g = DBUtils.retrieveUserInfoUsername("tyler");
            System.out.println(g.getPassword());
        } catch (SQLException e) {e.printStackTrace();}




    }
}