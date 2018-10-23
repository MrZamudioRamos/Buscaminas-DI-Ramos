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
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author dam2
 */
public class FXMLPantallaPrincipalController implements Initializable {

    @FXML
    private BorderPane fxRoot;

    @FXML
    private MenuBar fxMenu;

    private FXMLPantallaMenuController MenuCon;
    private AnchorPane MenuPane;

    

    public void clickInicio() {
    }

    public void clickGuia() {
    }

    public void clickSalir() {
    }

    @FXML
    public void cargarPantallaMenu() {
        fxMenu.setVisible(false);
        fxRoot.setCenter(MenuPane);
    }

    private void preCargaMenu() {
        
        
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/FXMLPantallaMenu.fxml"));
            MenuPane = loaderMenu.load();
            MenuCon = loaderMenu.getController();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preCargaMenu();
        cargarPantallaMenu();
    }

}
