package com.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    private Label label1;
    long num1 =0;
    String op="";
    Boolean condition= true;
    private Modal modal = new Modal();
    @FXML
    public void clickNumber(ActionEvent event)
    {
        if(Boolean.TRUE.equals(condition)){
            label1.setText("");
            condition=false;
        }
        String value=((Button)event.getSource()).getText();
        label1.setText(label1.getText() + value);
    }
    @FXML
    public void clickOp(ActionEvent event)
    {
        String value=((Button)event.getSource()).getText();

        if(!value.equals("=")){
            if(!op.isEmpty())
                return;
            op=value;
            num1 = Long.parseLong(label1.getText());
            label1.setText("");
        }else{
            if(op.isEmpty())
                return;
            long num2= Long.parseLong(label1.getText());
            float output = modal.calculate(num1, num2, op);
            label1.setText(String.valueOf(output));
            op= "";
            condition=true;
        }
    }
    @FXML
    public void clickCE()
    {
        label1.setText("");
    }
}
