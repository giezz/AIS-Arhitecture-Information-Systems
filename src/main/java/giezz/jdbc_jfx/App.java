package giezz.jdbc_jfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Авторизация");
        stage.setResizable(false);
        stage.show();
    }

    /**
     *
     * @param event event
     * @param fxmlFile fxml file
     * @param title title of page
     * @param isResizable will window be resizable
     */
    public static void changeScene(ActionEvent event, String fxmlFile, String title, boolean isResizable) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxmlFile));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(title);
            stage.setResizable(isResizable);
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openScene (Window owner, Modality modality, String fxmlFile, String title, boolean isResizable) {
        try {
            Stage stage = loadStage(fxmlFile);
            stage.setTitle(title);
            stage.initModality(modality);
            stage.initOwner(owner);
            stage.centerOnScreen();
            stage.setResizable(isResizable);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Stage loadStage(String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        return stage;
    }

    public static void main(String[] args) {
        launch();
    }
}