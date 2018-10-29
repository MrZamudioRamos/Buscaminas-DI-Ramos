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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import ramos.clases.Juego;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class FXMLPantallaIntermedioController implements Initializable {

    private FXMLPantallaPrincipalController principal;
    
    private int rows=16, col=16;

    @FXML
    protected GridPane fxGridPaneMinasIntermedio;
    
    @FXML
    protected Label fxLabelNumeroMinasIntermedio;

    public Label getFxLabelNumeroMinasIntermedio() {
        return fxLabelNumeroMinasIntermedio;
    }
    

    public FXMLPantallaPrincipalController getPrincipal() {
        return principal;
    }

    public void setPrincipal(FXMLPantallaPrincipalController principal) {
        this.principal = principal;
    }

    public void setFxLabelNumeroMinasIntermedio(Label fxLabelNumeroMinasIntermedio) {
        this.fxLabelNumeroMinasIntermedio = fxLabelNumeroMinasIntermedio;
    }
    
    
    
    public void clickReiniciarIntermedio() {

    }

    public void clickSalirIntermedio() {
        principal.cargarPantallaElegir();
    }

    public void Tablero(){
    Juego game = new Juego();
    
    game.rellenar(fxGridPaneMinasIntermedio, rows, col);
    
    }

    @FXML
    private Button btn_cara2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Tablero();
    }

}
