package pers.ignatiusgl.calculator.gui.menu.about;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * The control of about window by this Class
 * All of the component logic
 *
 * Create in October.10th.2018
 * Last change in October.10th.2018 by IgnatiusGL
 *
 * @author IgnatiusGL
 */
public class AboutController {
    @FXML
    private Button buttonOK;
    @FXML
    public void buttonOKOnClick(){
        Stage stage = (Stage) buttonOK.getScene().getWindow();
        stage.close();
    }
}
