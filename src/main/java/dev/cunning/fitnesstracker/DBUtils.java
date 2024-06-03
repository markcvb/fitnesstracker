package dev.cunning.fitnesstracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class DBUtils {
    static {
        createTable(Objects.requireNonNull(getConnection()));
    }

    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Reused connection.");
                return connection;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://minecraft.hodgman.net:3306/s6_db1",
                    "u6_DHfmUo6352",
                    "bPiI@K@rq0ToNBymWG9wFYjg"
            );
            System.out.println("Connected to database successfully.");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void createTable(Connection conn) {
        try {
            assert conn != null;
            Statement statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS userInfo (" +
                    "uuid TINYINT(255) primary key," +
                    "username varchar(36)," +
                    "password varchar(36)," +
                    "age BOOL," +
                    "name varchar(36)" +
                    ");";
            statement.execute(sql);
            statement.close();

            System.out.println("The table is set up.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void uploadUser(User user) throws SQLException {
        String username = user.getUsername();
        String password = user.getPassword();
        String name = user.getName();
        boolean age = user.getAge();

        ArrayList<Integer> uuids = retrieveUuids();
        boolean notUnique = true;
        int uuid = 0;
        while (notUnique) {
            uuid++;
            notUnique = false;
            for (int existingUuid : uuids) {
                if (uuid == existingUuid) notUnique = true;
            }
        }

        PreparedStatement statement = getConnection().prepareStatement("INSERT INTO userInfo (uuid, username, password, age, name) VALUES (?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE username=?, password=?, age=?, name=?");
        statement.setInt(1, uuid);
        statement.setString(2, username);
        statement.setString(3, password);
        statement.setBoolean(4, age);
        statement.setString(5, name);
        statement.setString(6, username);
        statement.setString(7, password);
        statement.setBoolean(8, age);
        statement.setString(9, name);
        statement.executeUpdate();
        statement.close();
    }

    public static ArrayList<Integer> retrieveUuids() throws SQLException {
        ArrayList<Integer> uuids = new ArrayList<>();

        //Objects.requireNonNull(getConnection()).close();
        Connection conn = getConnection();
        System.out.println("closed=" + conn.isClosed());
        PreparedStatement statement = conn
                .prepareStatement("SELECT * FROM userInfo");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            uuids.add(resultSet.getInt("uuid"));
        }
        return uuids;
    }

    public static User retrieveUserInfoUUID(int uuid) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM userInfo WHERE uuid = ?");
        statement.setInt(1, uuid);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return new User(
                    resultSet.getInt("uuid"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("name"),
                    resultSet.getBoolean("age")
            );
        }
        return null;
    }

    public static User retrieveUserInfoUsername(String username) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM userInfo WHERE username = ?");
        statement.setString(1, username);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return new User(
                    resultSet.getInt("uuid"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("name"),
                    resultSet.getBoolean("age")
            );
        }
        return null;
    }

   /* public static void changeScene(ActionEvent event, String fxmlFile, String title, String username, Boolean age) {
        Parent root = null;

        if (username != null) {
            try {
                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                root = loader.load();
                loggedinController loggedinController = loader.getController();
                loggedinController.setUserInformation(username);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root, 680, 400));
        stage.show();
    } */

    public static void changeScene(ActionEvent event, String fxmlFile, String title, String username, Boolean age) {
        try {
            FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
            Parent root = loader.load(); // Load the FXML content

            if (username != null) {
                loggedinController loggedinController = loader.getController();
                loggedinController.setUserInformation(username);
            }

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(title);
            stage.setScene(new Scene(root, 680, 400)); // Set scene dimensions
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void signUpUser(ActionEvent event, String username, String password, boolean age) {
        User user = new User(-1, username, password, "default name", age);
        try {
            uploadUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        changeScene(event, "loggedin.fxml", "FINALLY", username, age);
    }


    public static void logInUser(ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://minecraft.hodgman.net:3306/s6_db1",
                    "u6_DHfmUo6352",
                    "bPiI@K@rq0ToNBymWG9wFYjg");
            preparedStatement = connection.prepareStatement("SELECT password FROM userInfo WHERE username = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("User not found in the database");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Provided creditals are incorrect");
                alert.show();
            } else {
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("password");
                    if (retrievedPassword.equals(password)) {
                        changeScene(event, "loggedin.fxml", "Welcome", username, null);
                    } else {
                        System.out.println("passwords did not match");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Incorrect Password");
                        alert.show();
                    }
                }


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}