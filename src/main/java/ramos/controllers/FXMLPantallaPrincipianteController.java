/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramos.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import ramos.clases.Juego;
import ramos.clases.Temporizador;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class FXMLPantallaPrincipianteController implements Initializable {

    Juego game = new Juego();
    
    @FXML
    public Label fxLabelNumeroMinasPrincipiante;

    @FXML
    protected GridPane fxGridPaneMinasPrincipiante;

    private final int rows = 8;
    private final int col = 8;
    private FXMLPantallaPrincipalController principal;
    private FXMLPantallaElegirController elegir;

    @FXML
    protected Text fxText;

    public Label getFxLabelNumeroMinasPrincipiante() {
        return fxLabelNumeroMinasPrincipiante;
    }

    public void setFxLabelNumeroMinasPrincipiante(Label fxLabelNumeroMinasPrincipiante) {
        this.fxLabelNumeroMinasPrincipiante = fxLabelNumeroMinasPrincipiante;
    }

    public FXMLPantallaPrincipalController getPrincipal() {
        return principal;
    }

    public void setPrincipal(FXMLPantallaPrincipalController principal) {
        this.principal = principal;
    }

    public void clickSalirPrincipiante() {
        principal.cargarPantallaElegir();
    }

    public void start() {
        Temporizador temp = new Temporizador();
        temp.setSeconds(0);
        temp.time(fxText);
        temp.start();
    }

    public void clickReiniciarPrincipiante() {
        start();
    }

    /**
     * Initializes the controller class.
     * @return 
     */
    public Button[][] Tablero() {

        return game.rellenar(fxGridPaneMinasPrincipiante, rows, col);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Tablero();
    }

}
