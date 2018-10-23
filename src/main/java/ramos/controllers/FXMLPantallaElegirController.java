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

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class FXMLPantallaElegirController implements Initializable {
    private FXMLPantallaPrincipalController principal;

    public FXMLPantallaPrincipalController getPrincipal() {
        return principal;
    }

    public void setPrincipal(FXMLPantallaPrincipalController principal) {
        this.principal = principal;
    }
    
    @FXML
    private RadioButton fxElegirFacil;
    
    @FXML
    private RadioButton fxElegirMedio;
    
    @FXML
    private RadioButton fxElegirDificil;
    
    @FXML
    private RadioButton fxElegirGrande;
    
    @FXML
    private RadioButton fxElegirMediano;
    
    @FXML
    private RadioButton fxElegirPequeño;
    
    
    public void clickSalirElegir(){
        if (fxElegirPequeño.isSelected()) {
            principal.cargarPantallaPrincipiante();
        }else if (fxElegirMediano.isSelected()) {
            principal.cargarPantallaIntermedio();
        }else if (fxElegirGrande.isSelected()){
            principal.cargarPantallaDificil();
        }
        
    }
    
    public void clickAtrasElegir(){
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
