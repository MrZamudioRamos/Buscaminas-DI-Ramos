/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramos.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class FXMLPantallaMenuController implements Initializable {

    @FXML
    private Rectangle fondoMenu;
    
    @FXML
    private Rectangle Icon;
    
    @FXML
    private BorderPane fxRoot;

//    private FXMLPantallaOpcionesController OpcionesController;
//    private AnchorPane OpcionesPane;

    private FXMLPantallaPrincipalController principal;

    public FXMLPantallaPrincipalController getPrincipal() {
        return principal;
    }

    public void setPrincipal(FXMLPantallaPrincipalController principal) {
        this.principal = principal;
    }
    
    public void clickJugar() {

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

//    private void preCargaOpciones() {
//
//        try {
//            FXMLLoader loaderMenu = new FXMLLoader(
//                    getClass().getResource(
//                            "/fxml/FXMLPantallaOpciones.fxml"));
//            OpcionesPane = loaderMenu.load();
//            OpcionesController = loaderMenu.getController();
//        } catch (IOException ex) {
//            Logger.getLogger(FXMLPantallaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//    
//    @FXML
//    public void cargarPantallaOpciones() {
//        fxRoot.setCenter(OpcionesPane);
//    }
//    
//    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        preCargaOpciones();
        ImagePattern imagePattern = new ImagePattern(new Image("/images/icon.png"));
        Icon.setFill(imagePattern);
    }

}
