/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramos.controllers;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class FXMLPantallaPersonalizarController implements Initializable {

    int alto, ancho, total;

    private FXMLPantallaPrincipalController principal;

    private FXMLPantallaJuegoPersonalizadoController personalizado;

    public FXMLPantallaJuegoPersonalizadoController getPersonalizado() {
        return personalizado;
    }

    public void setPersonalizado(FXMLPantallaJuegoPersonalizadoController personalizado) {
        this.personalizado = personalizado;
    }

    public FXMLPantallaPrincipalController getPrincipal() {
        return principal;
    }

    public void setPrincipal(FXMLPantallaPrincipalController principal) {
        this.principal = principal;
    }

    @FXML
    private TextField fxAncho;

    @FXML
    private TextField fxAlto;

    @FXML
    private RadioButton fxPersonalizarFacil;

    @FXML
    private RadioButton fxPersonalizarMedio;

    @FXML
    private RadioButton fxPersonalizarDificil;

    @FXML
    private Slider fxAnchoSlider;

    @FXML
    private Slider fxAltoSlider;
    

    private static final int initValueAncho = 8;
    private static final int initValueAlto = 8;

    public void datiyos() {
        fxAltoSlider.setMin((int) 8);
        fxAltoSlider.setMax((int) 18);

        fxAnchoSlider.setMin((int) 8);
        fxAnchoSlider.setMax((int) 18);

        fxAltoSlider.valueProperty().addListener((obs, oldval, newVal)
                -> fxAltoSlider.setValue(newVal.intValue()));

        fxAnchoSlider.valueProperty().addListener((obs, oldval, newVal)
                -> fxAnchoSlider.setValue(newVal.intValue()));

        fxAncho.setText(new Double(initValueAlto).toString());
        fxAlto.setText(new Double(initValueAncho).toString());

        fxAlto.setDisable(true);
        fxAncho.setDisable(true);

        fxAncho.textProperty().bindBidirectional(fxAnchoSlider.valueProperty(), NumberFormat.getNumberInstance());
        fxAlto.textProperty().bindBidirectional(fxAltoSlider.valueProperty(), NumberFormat.getNumberInstance());

    }

    public int getAlto() {
        alto = Integer.parseInt(fxAlto.getText());
        return alto;
    }

    public int getAncho() {
        ancho = Integer.parseInt(fxAncho.getText());
        return ancho;
    }

    public void clickJugar() {

        if (fxPersonalizarDificil.isSelected() || fxPersonalizarFacil.isSelected() || fxPersonalizarMedio.isSelected()) {
            if (fxPersonalizarFacil.isSelected()) {
                principal.precargarPantallaJuegoPersonalizado(getMina(), getAlto(), getAncho());
                principal.cargarNuevaPantallaPersonalizado();
            } else if (fxPersonalizarMedio.isSelected()) {
                principal.precargarPantallaJuegoPersonalizado(getMina(), getAlto(), getAncho());
                principal.cargarNuevaPantallaPersonalizado();
            } else if (fxPersonalizarDificil.isSelected()) {
                principal.precargarPantallaJuegoPersonalizado(getMina(), getAlto(), getAncho());
                principal.cargarNuevaPantallaPersonalizado();
            }

        } else {
            alerta("Selecciona la dificultad");
        }

    }

    public int getMina() {

        total = getAlto() * getAncho();

        int mina = 0;

        if (fxPersonalizarDificil.isSelected() || fxPersonalizarFacil.isSelected() || fxPersonalizarMedio.isSelected()) {
            if (fxPersonalizarFacil.isSelected()) {
                mina = total / 5;

            } else if (fxPersonalizarMedio.isSelected()) {
                mina = total / 4;

            } else if (fxPersonalizarDificil.isSelected()) {
                mina = total / 3;
            }
        }
        return mina;
    }

    public void alerta(Alert.AlertType tipo, String mensaje) {
        Alert temp = new Alert(tipo);
        temp.setTitle("Nota informativa");
        temp.setHeaderText("Buscaminas");
        temp.setContentText(mensaje);
        temp.showAndWait();
    }

    public void alerta(String mensaje) {
        alerta(Alert.AlertType.INFORMATION, mensaje);
    }

    public void clickAtras() {

        principal.cargarPantallaOpciones();

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        datiyos();
    }

}