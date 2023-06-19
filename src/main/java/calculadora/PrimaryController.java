package calculadora;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PrimaryController {

    @FXML
    private Label lblResult;

    @FXML
    private Pane btn7;

    @FXML
    private Pane btn8;

    @FXML
    private Pane btn9;

    @FXML
    private Pane btnPlus;

    @FXML
    private Pane btnPorcentaje;

    @FXML
    private Pane btnRaizCuadrada;

    @FXML
    private Pane btn4;

    @FXML
    private Pane btn5;

    @FXML
    private Pane btn6;

    @FXML
    private Pane btnMinus;

    @FXML
    private Pane btn1;

    @FXML
    private Pane btn2;

    @FXML
    private Pane btn3;

    @FXML
    private Pane btnMultiply;

    @FXML
    private Pane btn0;

    @FXML
    private Pane btnEquals;

    @FXML
    private Pane btnDivide;

    @FXML
    private Pane btnC;

    @FXML
    private Pane btnMMenos;

    @FXML
    private Pane btnMMas;

    @FXML
    private Pane btnMS;

    @FXML
    private Pane btnMR;

    @FXML
    private Pane btnCE;

    @FXML
    private Pane btnMC;

    @FXML
    private Pane titlePane;

    @FXML
    private ImageView btnMinimize;

    @FXML
    private ImageView btnClose;

    @FXML
    void onClearErrorClicked(MouseEvent event) {
        String currentText = lblResult.getText();
        if (currentText.length() > 0) {
            String newText = currentText.substring(0, currentText.length() - 1);
            lblResult.setText(newText);
        }
    }

    @FXML
    void onMemoryClearClicked(MouseEvent event) {

        memory = 0.0;

    }

    @FXML
    void onMemoryRecallClicked(MouseEvent event) {

        lblResult.setText(String.valueOf(memory));

    }

    @FXML
    void onMemoryStorageClicked(MouseEvent event) {

        memory = Double.parseDouble(lblResult.getText());
        lblResult.setText("0.0");

    }

    @FXML
    void onMemoryAddClicked(MouseEvent event) {
        memory += Double.parseDouble(lblResult.getText());
    }

    @FXML
    void onMemorySubtractClicked(MouseEvent event) {
        memory -= Double.parseDouble(lblResult.getText());
    }

    @FXML
    void onNumberClicked(MouseEvent event) {
        int value = Integer.parseInt(((Pane) event.getSource()).getId().replace("btn", ""));
        lblResult.setText(Double.parseDouble(lblResult.getText()) == 0 ? String.valueOf((double) value)
                : String.valueOf(Double.parseDouble(lblResult.getText()) * 10 + value));

    }

    @FXML
    void onSymbolClicked(MouseEvent event) {
        String symbol = ((Pane) event.getSource()).getId().replace("btn", "");
        if (symbol.equals("Equals")) {
            double num2 = Double.parseDouble(lblResult.getText());
            switch (operator) {
                case "+":
                    values.add(num2);
                    double sum = 0.0;
                    for (Double num : values) {
                        sum += num;
                    }
                    lblResult.setText(sum + "");
                    break;
                case "-":
                    values.add(num2);
                    double diff = values.get(0);
                    for (int i = 1; i < values.size(); i++) {
                        diff -= values.get(i);
                    }
                    lblResult.setText(diff + "");
                    break;
                case "*":
                    values.add(num2);
                    double product = 1.0;
                    for (Double num : values) {
                        product *= num;
                    }
                    lblResult.setText(product + "");
                    break;
                case "/":
                    values.add(num2);
                    double quotient = values.get(0);
                    for (int i = 1; i < values.size(); i++) {
                        quotient /= values.get(i);
                    }
                    lblResult.setText(quotient + "");
                    break;
                case "√":
                    double sqrt = Math.sqrt(num2);
                    lblResult.setText(sqrt + "");
                    break;

                case "%":
                    double percent = (num1 * num2) / 100;
                    lblResult.setText(percent + "");
                    break;
            }
            values.clear();
            num1 = Double.parseDouble(lblResult.getText());
            operator = ".";
        } else if (symbol.equals("C")) {
            lblResult.setText(String.valueOf(0.0));
            operator = ".";
            values.clear();
        } else {
            switch (symbol) {
                case "Plus":
                    operator = "+";
                    break;
                case "Minus":
                    operator = "-";
                    break;
                case "Multiply":
                    operator = "*";
                    break;
                case "Divide":
                    operator = "/";
                    break;
                case "RaizCuadrada":
                    operator = "√";
                    break;
                case "Porcentaje":
                    operator = "%";
                    break;
            }
            values.add(Double.parseDouble(lblResult.getText()));
            lblResult.setText(String.valueOf(0.0));
        }
    }

    private double memory = 0.0;
    private double num1 = 0.0;
    private String operator = "+";
    private List<Double> values = new ArrayList<>();

    @FXML
    void initialize() {
        assert lblResult != null : "fx:id=\"lblResult\" was not injected: check your FXML file 'primary.fxml'.";
        assert btn7 != null : "fx:id=\"btn7\" was not injected: check your FXML file 'primary.fxml'.";
        assert btn8 != null : "fx:id=\"btn8\" was not injected: check your FXML file 'primary.fxml'.";
        assert btn9 != null : "fx:id=\"btn9\" was not injected: check your FXML file 'primary.fxml'.";
        assert btnPlus != null : "fx:id=\"btnPlus\" was not injected: check your FXML file 'primary.fxml'.";
        assert btn4 != null : "fx:id=\"btn4\" was not injected: check your FXML file 'primary.fxml'.";
        assert btn5 != null : "fx:id=\"btn5\" was not injected: check your FXML file 'primary.fxml'.";
        assert btn6 != null : "fx:id=\"btn6\" was not injected: check your FXML file 'primary.fxml'.";
        assert btnMinus != null : "fx:id=\"btnMinus\" was not injected: check your FXML file 'primary.fxml'.";
        assert btn1 != null : "fx:id=\"btn1\" was not injected: check your FXML file 'primary.fxml'.";
        assert btn2 != null : "fx:id=\"btn2\" was not injected: check your FXML file 'primary.fxml'.";
        assert btn3 != null : "fx:id=\"btn3\" was not injected: check your FXML file 'primary.fxml'.";
        assert btnMultiply != null : "fx:id=\"btnMultiply\" was not injected: check your FXML file 'primary.fxml'.";
        assert btn0 != null : "fx:id=\"btn0\" was not injected: check your FXML file 'primary.fxml'.";
        assert btnEquals != null : "fx:id=\"btnEquals\" was not injected: check your FXML file 'primary.fxml'.";
        assert btnDivide != null : "fx:id=\"btnDivide\" was not injected: check your FXML file 'primary.fxml'.";
        assert btnC != null : "fx:id=\"btnC\" was not injected: check your FXML file 'primary.fxml'.";
        assert btnMMenos != null : "fx:id=\"btnMMenos\" was not injected: check your FXML file 'primary.fxml'.";
        assert btnMMas != null : "fx:id=\"btnMMas\" was not injected: check your FXML file 'primary.fxml'.";
        assert btnMS != null : "fx:id=\"btnMS\" was not injected: check your FXML file 'primary.fxml'.";
        assert btnMR != null : "fx:id=\"btnMR\" was not injected: check your FXML file 'primary.fxml'.";
        assert btnMC != null : "fx:id=\"btnMC\" was not injected: check your FXML file 'primary.fxml'.";
        assert btnPorcentaje != null : "fx:id=\"btnPorcentaje\" was not injected: check your FXML file 'primary.fxml'.";
        assert btnRaizCuadrada != null
                : "fx:id=\"btnRaizCuadrada\" was not injected: check your FXML file 'primary.fxml'.";
        assert btnCE != null : "fx:id=\"btnCE\" was not injected: check your FXML file 'primary.fxml'.";
        assert titlePane != null : "fx:id=\"titlePane\" was not injected: check your FXML file 'primary.fxml'.";
        assert btnClose != null : "fx:id=\"btnClose\" was not injected: check your FXML file 'primary.fxml'.";
        assert btnMinimize != null : "fx:id=\"btnMinimize\" was not injected: check your FXML file 'primary.fxml'.";

    }

}
