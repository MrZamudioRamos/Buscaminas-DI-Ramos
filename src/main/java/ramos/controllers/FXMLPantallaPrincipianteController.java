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
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class FXMLPantallaPrincipianteController implements Initializable {
    
    private FXMLPantallaPrincipalController principal;

    public FXMLPantallaPrincipalController getPrincipal() {
        return principal;
    }

    public void setPrincipal(FXMLPantallaPrincipalController principal) {
        this.principal = principal;
    }
    
    public void clickSalirPrincipiante(){
        
    }
    
    public void clickReiniciarPrincipiante(){
        
    }
    
    @FXML
    private Circle btn_cara;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
