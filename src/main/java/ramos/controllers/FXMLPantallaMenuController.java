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
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class FXMLPantallaMenuController implements Initializable {
    
    @FXML
    private Rectangle Icon;

    private FXMLPantallaPrincipalController principal;

    public FXMLPantallaPrincipalController getPrincipal() {
        return principal;
    }

    public void setPrincipal(FXMLPantallaPrincipalController principal) {
        this.principal = principal;
    }
    
    public void clickJugar() {
        principal.cargarPantallaPrincipiante();
    }

    public void clickPersonalizar() {
        principal.cargarPantallaOpciones();
        
    }

    public void clickVerRanking() {

    }

    public void clickAyuda() {

    }

    public void clickSalir() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ImagePattern imagePattern = new ImagePattern(new Image("/images/icon.png"));
        Icon.setFill(imagePattern);
    }

}
