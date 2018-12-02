package pers.ignatiusgl.ui.menu.about;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Create a about window
 * How to use:
 *      Just to use the showWindow()
 *
 * Create in October.10th.2018
 * Last change in October.10th.2018 by IgnatiusGL
 *
 * @author IgnatiusGL
 */
public class About {
    /**
     * show the about window
     * @throws IOException fxml not found
     */
    public void showWindow() throws IOException {
        BorderPane root = FXMLLoader.load(getClass().getResource("/resources/fxml/menu/about_window.fxml"));
        Stage stage = new Stage();
        stage.setTitle("About");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
