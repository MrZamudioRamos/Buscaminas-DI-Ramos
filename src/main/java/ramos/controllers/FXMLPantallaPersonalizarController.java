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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class FXMLPantallaPersonalizarController implements Initializable {
private FXMLPantallaPrincipalController principal;

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
    
    public int getValorAncho(){
        
        int ancho = Integer.parseInt(fxTextFieldAncho.getText());
        
        return ancho;
    }
    
    public int getValorAlto(){
        
        int alto = Integer.parseInt(fxTextFieldAlto.getText());
        
        return alto;
    }
    
    public void clickJugar(){
        
        //principal.cargarPantallaJuegoPersonalizado();
    }
    
    public void clickAtras(){
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
