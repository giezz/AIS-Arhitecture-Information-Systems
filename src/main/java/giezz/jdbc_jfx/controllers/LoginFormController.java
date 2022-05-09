package giezz.jdbc_jfx.controllers;

import java.io.IOException;
import giezz.jdbc_jfx.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginFormController {

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
        System.out.println(btnAuth.getId());
//        if (tfLogin.getText() != null && pfPassword.getText() != null) {
//            if (tfLogin.getText().equals("admin") && pfPassword.getText().equals("admin")) {
                App.changeScene(event, "skeleton.fxml", "Добро пожаловать", true);
//            }
//        }
    }
}
