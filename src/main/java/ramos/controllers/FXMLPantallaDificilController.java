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
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class FXMLPantallaDificilController implements Initializable {

    private FXMLPantallaPrincipalController principal;
    
    @FXML
    protected GridPane fxGridPaneMinasDificil;

    public FXMLPantallaPrincipalController getPrincipal() {
        return principal;
    }
    
    public void rellenar(){
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                fxGridPaneMinasDificil.add(new Button(), i, j);
            }
        }
    }

    public void setPrincipal(FXMLPantallaPrincipalController principal) {
        this.principal = principal;
    }
    
    public void clickReiniciarDificil(){
        
    }
    
    public void clickSalirDificil(){
        principal.cargarPantallaElegir();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rellenar();
    }

}
