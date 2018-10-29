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
    
    
    public String Tablero() {
        String mines = null;
        if (fxElegirPequeño.isSelected()) {

            if (fxElegirFacil.isSelected()) {
                mines = "12";
            } else if (fxElegirMedio.isSelected()) {
                mines = "16";
            } else if (fxElegirDificil.isSelected()) {
                mines = "21";
            }
        } else if (fxElegirMediano.isSelected()) {

            if (fxElegirFacil.isSelected()) {
                mines = "51";
            } else if (fxElegirMedio.isSelected()) {
                mines = "64";
            } else if (fxElegirDificil.isSelected()) {
                mines = "85";
            }

        } else if (fxElegirGrande.isSelected()) {

            if (fxElegirFacil.isSelected()) {
                mines = "96";
            } else if (fxElegirMedio.isSelected()) {
                mines = "120";
            } else if (fxElegirDificil.isSelected()) {
                mines = "160";
            }
        }
        return mines;
    }


    public void clickSalirElegir() {
        if (fxElegirPequeño.isSelected()) {
            principal.cargarNuevaPantallaPrincipiante();
        } else if (fxElegirMediano.isSelected()) {
            principal.cargarNuevaPantallaIntermedio();
        } else if (fxElegirGrande.isSelected()) {
            principal.cargarNuevaPantallaDificil();
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
