module pers.ignatiusgl.calculator.gui {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.base;
    requires pers.ignatiusgl.calculator.algorithm;

    opens pers.ignatiusgl.calculator.gui.main to javafx.fxml, javafx.graphics;
    opens pers.ignatiusgl.calculator.gui.menu.about to javafx.fxml, javafx.graphics;
}