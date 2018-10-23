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

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class FXMLPantallaDificilController implements Initializable {

    private FXMLPantallaPrincipalController principal;

    public FXMLPantallaPrincipalController getPrincipal() {
        return principal;
    }

    public void setPrincipal(FXMLPantallaPrincipalController principal) {
        this.principal = principal;
    }
    
    public void clickReiniciarDificil(){
        
    }
    
    public void clickSalirDificil(){
        principal.cargarPantallaElegir();
    }
    
    @FXML
    private Button btn_cara3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
