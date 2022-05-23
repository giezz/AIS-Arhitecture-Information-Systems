package giezz.jdbc_jfx.controllers;

import giezz.jdbc_jfx.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginFormController {

    @FXML
    private Button btnAuth;

    @FXML
    void initialize() {

    }

    @FXML
    private void handleAuthButtonClick(ActionEvent event) {
        System.out.println(btnAuth.getId());
        App.changeScene(event, "skeleton.fxml", "Добро пожаловать", true);
//        SELECT * FROM users WHERE login = ""
    }
}
