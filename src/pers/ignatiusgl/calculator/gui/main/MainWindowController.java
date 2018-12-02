package pers.ignatiusgl.calculator.gui.main;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pers.ignatiusgl.calculator.algorithm.Arithmetic;
import pers.ignatiusgl.ui.menu.about.About;

import java.io.IOException;

/**
 * The control of main window by this Class
 * All of the component logic
 *
 * Create in October.9th.2018
 * Last change in October.10th.2018 by IgnatiusGL
 *
 * @author IgnatiusGL
 */
public class MainWindowController {
    //Is the calculator screen'text result
    private boolean isResult = false;
    @FXML
    private TextField textScreen;

    @FXML
    public void buttonOneOnClick(){
        setDigitalInScreen(1);
    }
    @FXML
    public void buttonTwoOnClick(){
        setDigitalInScreen(2);
    }
    @FXML
    public void buttonThreeOnClick(){
        setDigitalInScreen(3);
    }
    @FXML
    public void buttonFourOnClick(){
        setDigitalInScreen(4);
    }
    @FXML
    public void buttonFiveOnClick(){
        setDigitalInScreen(5);
    }
    @FXML
    public void buttonSixOnClick(){
        setDigitalInScreen(6);
    }
    @FXML
    public void buttonSevenOnClick(){
        setDigitalInScreen(7);
    }
    @FXML
    public void buttonEightOnClick(){
        setDigitalInScreen(8);
    }
    @FXML
    public void buttonNineOnClick(){
        setDigitalInScreen(9);
    }
    @FXML
    public void buttonZeroOnClick(){
        setDigitalInScreen(0);
    }
    @FXML
    public void buttonCLearAllClick(){
        textScreen.setText("");
    }
    @FXML
    public void buttonDeleteOnClick(){
        if(isResult){
            textScreen.setText("");
            isResult = false;
            return;
        }
        String tmp = textScreen.getText();
        if(!tmp.equals("")) {
            tmp = tmp.substring(0, tmp.length() - 1);
            textScreen.setText(tmp);
        }
    }
    @FXML
    public void buttonPointOnClick(){
        if(isResult){
            textScreen.setText("");
            isResult = false;
            return;
        }
        String tmp = textScreen.getText();
        char[] check;
        if(!tmp.equals("")){
            check = tmp.toCharArray();
            boolean flag = true;
            for(int i=check.length-1;i>=0;i--){
                if(check[i] == '.'){
                    flag = false;
                    break;
                }else if(check[i] == '+' || check[i] == '-' || check[i] == '*' || check[i] == '/'){
                    break;
                }
            }
            if(flag)
                textScreen.setText(tmp + ".");
        }


    }
    @FXML
    public void buttonAddOnClick(){
        setOperatorInScreen("+");
    }
    @FXML
    public void buttonSubtractionOnClick(){
        setOperatorInScreen("-");
    }
    @FXML
    public void buttonMultiplicationOnClick(){
        setOperatorInScreen("*");
    }
    @FXML
    public void buttonDivisionOnClick(){
        setOperatorInScreen("/");
    }
    @FXML
    public void buttonEqualOnClick(){
        if(!isResult) {
            Arithmetic arithmetic = new Arithmetic();
            arithmetic.setFormula(textScreen.getText());
            textScreen.setText(arithmetic.getResult());
            isResult = true;
        }
    }
    @FXML
    public void menuCloseOnClick(){
        System.exit(0);
    }
    @FXML
    public void menuAboutOnClick(){
        About about = new About();
        try {
            about.showWindow();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    /**
     * set the digital in the screen
     * this method Block illegal operations
     * to sure that the "01" "000" and many others disappear
     * @param Digital the digital that you want to appear the screen
     */
    private void setDigitalInScreen(int Digital){
        if(isResult){
            textScreen.setText("");
            isResult = false;
        }
        String tmp = textScreen.getText();
        if(tmp.equals("0"))
            textScreen.setText(Digital + "");
        else
            textScreen.setText(tmp + Digital);
    }

    /**
     * set the operator in the screen
     * this method Block illegal operations
     * to sure that the "++" "+*" and many others disappear
     * @param operator the operator that you want to appear the screen
     */
    private void setOperatorInScreen(String operator){
        if(isResult){
            textScreen.setText("");
            isResult = false;
            return;
        }
        String tmp = textScreen.getText();
        if(!tmp.equals("")){
            char check = tmp.toCharArray()[tmp.length()-1];
            if(check != '+' && check != '-' && check != '*' && check != '/')
                textScreen.setText(tmp + operator);
        }
    }
}
