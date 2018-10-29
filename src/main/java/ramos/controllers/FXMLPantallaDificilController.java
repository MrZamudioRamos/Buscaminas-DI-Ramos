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
import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

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
        int cont = 0;
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                Button b = new Button();
                b.setMinSize(20,20);
                fxGridPaneMinasDificil.add(b, i, j);
                
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
