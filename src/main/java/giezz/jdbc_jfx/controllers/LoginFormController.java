package giezz.jdbc_jfx.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import giezz.jdbc_jfx.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAuth;

    @FXML
    private PasswordField pfPassword;

    @FXML
    private TextField tfLogin;

    @FXML
    void initialize() {

    }

    @FXML
    private void handleAuthButtonClick(ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(""));
//        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//        stage.setScene(new Scene(fxmlLoader.load()));
//        stage.centerOnScreen();
//        stage.setTitle("");
//        stage.show();
//        stage.setResizable(true);
        App.changeScene(event, "page-1.fxml", "Title", true);
    }

}
