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
    private FXMLPantallaPrincipianteController principiante;

    public FXMLPantallaPrincipalController getPrincipal() {
        return principal;
    }

    public void setPrincipal(FXMLPantallaPrincipalController principal) {
        this.principal = principal;
    }
    
    @FXML
    public RadioButton fxElegirFacil;
    
    @FXML
    public RadioButton fxElegirMedio;
    
    @FXML
    public RadioButton fxElegirDificil;
    
    @FXML
    public RadioButton fxElegirGrande;
    
    @FXML
    public RadioButton fxElegirMediano;
    
    @FXML
    public RadioButton fxElegirPequeño;
    
    
    public void clickSalirElegir() {
        dameMinas();
        if (fxElegirPequeño.isSelected()) {
            principal.precargarPantallaPrincipiante();
            principal.cargarPantallaPrincipiante();
        } else if (fxElegirMediano.isSelected()) {
            principal.cargarPantallaIntermedio();
        } else if (fxElegirGrande.isSelected()) {
            principal.cargarPantallaDificil();
        }
    }
    
    public void dameMinas(){
        if (fxElegirFacil.isSelected()) {
        }else if (fxElegirMedio.isSelected()) {
        }else if (fxElegirDificil.isSelected()){
           
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
      
    }    
    
}
