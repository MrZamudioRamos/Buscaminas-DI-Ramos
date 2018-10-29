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

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class FXMLPantallaPrincipianteController implements Initializable {
    
    @FXML
    public Label fxLabelNumeroMinasPrincipiante;
    
    @FXML
    protected GridPane fxGridPaneMinasPrincipiante;
    
    private FXMLPantallaPrincipalController principal;
    private FXMLPantallaElegirController elegir;

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
    
    public void clickSalirPrincipiante(){
        principal.cargarPantallaElegir();
    }
    
    public void clickReiniciarPrincipiante(){
        
    }
    
    /**
     * Initializes the controller class.
     */
    
    public void rellenar(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Button b = new Button();
                b.setMinSize(30, 20);
                fxGridPaneMinasPrincipiante.add(b, i, j);
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rellenar();
    }    
    
}
