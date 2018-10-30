/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramos.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class FXMLPantallaPersonalizarController implements Initializable {

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
    private TextField fxTextFieldAncho;

    @FXML
    private TextField fxTextFieldAlto;

    @FXML
    private RadioButton fxPersonalizarFacil;

    @FXML
    private RadioButton fxPersonalizarMedio;

    @FXML
    private RadioButton fxPersonalizarDificil;

    public int getValorAncho() {

        int ancho = Integer.parseInt(fxTextFieldAncho.getText());

        return ancho;
    }

    public int getValorAlto() {

        int alto = Integer.parseInt(fxTextFieldAlto.getText());

        return alto;
    }

    public int darMinas() {
        int mines = 0;

        if (fxPersonalizarFacil.isSelected()) {
            mines = 12;
        } else if (fxPersonalizarMedio.isSelected()) {
            mines = 16;
        } else if (fxPersonalizarDificil.isSelected()) {
            mines = 21;
        }
        return mines;
    }

    public String getDificultad() {
        String mines = "";
        if (fxPersonalizarFacil.isSelected()) {
            mines = "12";
        } else if (fxPersonalizarMedio.isSelected()) {
            mines = "16";
        } else if (fxPersonalizarDificil.isSelected()) {
            mines = "21";
        }
        return mines;
    }

    public void clickJugar() {

        principal.precargarPantallaJuegoPersonalizado();
        principal.cargarPantallaJuegoPersonalizado();
    }

    public void clickAtras() {

        principal.cargarPantallaOpciones();

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
