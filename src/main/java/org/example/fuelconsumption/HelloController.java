package org.example.fuelconsumption;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private Label distanceLbl;
    @FXML
    private TextField distanceFld;

    @FXML
    private Label fuelLbl;
    @FXML
    private TextField fuelFld;

    @FXML
    private Button calculate;

    @FXML
    private Label result;

    private ResourceBundle bundle;

    private Locale locale;

    /*@FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }*/

    @FXML
    protected void onCalculateButtonClick() {
        try {
            double distance = Double.parseDouble(distanceFld.getText());
            double fuel = Double.parseDouble(fuelFld.getText());
            double consumption = fuel / distance * 100;

            String resultText = bundle.getString("result.label");
            result.setText(String.format(resultText, consumption));
        } catch (NumberFormatException e) {
            result.setText(bundle.getString("invalid.input"));
        }
    }

    @FXML
    private void loadLanguage(String lang, String country) {
        locale = new Locale(lang, country);
        bundle = ResourceBundle.getBundle("messages", locale);
        distanceLbl.setText(bundle.getString("distance"));
        fuelLbl.setText(bundle.getString("fuel"));
        calculate.setText(bundle.getString("calculate"));
        //result.setText(bundle.getString("result"));
    }

    @FXML
    protected void onEnglishButtonClick(ActionEvent actionEvent) {
        loadLanguage("en", "US");
    }

    @FXML
    protected void onFrenchButtonClick(ActionEvent actionEvent) {
        loadLanguage("fr", "FR");
    }

    @FXML
    protected void onJapaneseButtonClick(ActionEvent actionEvent) {
        loadLanguage("ja", "JP");
    }

    public void onFarsiButtonClick(ActionEvent actionEvent) {
        loadLanguage("fa", "IR");
    }
}