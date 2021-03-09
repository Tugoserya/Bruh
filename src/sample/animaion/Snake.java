package sample.animaion;

import javafx.animation.TranslateTransition;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import org.w3c.dom.Node;

public class Snake {
    private TranslateTransition tt;

    public Snake(TextField node){
        tt=new TranslateTransition(Duration.millis(70), (javafx.scene.Node) node);
        tt.setFromX(0f);
        tt.setByX(10f);
        tt.setCycleCount(3);
        tt.setAutoReverse(true);
    }
    public Snake(Button node){
        tt=new TranslateTransition(Duration.millis(70), (javafx.scene.Node) node);
        tt.setFromX(0f);
        tt.setByX(10f);
        tt.setCycleCount(3);
        tt.setAutoReverse(true);
    }
    public Snake(DatePicker node){
        tt=new TranslateTransition(Duration.millis(70), (javafx.scene.Node) node);
        tt.setFromX(0f);
        tt.setByX(10f);
        tt.setCycleCount(3);
        tt.setAutoReverse(true);
    }

    public  void playAnim(){
        tt.playFromStart();
    }
}
