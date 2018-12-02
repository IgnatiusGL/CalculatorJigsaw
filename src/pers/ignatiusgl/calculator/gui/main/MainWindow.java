package pers.ignatiusgl.calculator.gui.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Create a main window,extends the Application that JavaFX's application have to do;
 * How to use:
 *      Just to use the Application.launch(MainWindow.class, args) to start this window,
 *      the args is a String param.
 *
 * Create in October.9th.2018
 * Last change in October.10th.2018 by IgnatiusGL
 *
 * @author IgnatiusGL
 */
public class MainWindow extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = FXMLLoader.load(getClass().getResource("/resources/fxml/main/main_window.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(getClass().getResource("/resources/img/menu/about/Calculator.png").toString()));
        primaryStage.setTitle("计算器");
        primaryStage.show();
    }
}
