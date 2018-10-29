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

    private AnchorPane pantallaOpciones;
    private FXMLPantallaOpcionesController opcionesController;
    private AnchorPane pantallaPersonalizar;
    private FXMLPantallaPersonalizarController personalizarController;
    private AnchorPane pantallaPrincipiante;
    private FXMLPantallaPrincipianteController principianteController;
    private AnchorPane pantallaMenu;
    private FXMLPantallaMenuController menuController;
    private AnchorPane pantallaIntermedio;
    private FXMLPantallaIntermedioController intermedioController;
    private AnchorPane pantallaElegir;
    private FXMLPantallaElegirController elegirController;
    private AnchorPane pantallaDificil;
    private FXMLPantallaDificilController dificilController;
    private AnchorPane pantallaJuegoPersonalizado;
    private FXMLPantallaDificilController juegoPersonalizadoController;
    
    //PRECARGAR PANTALLAS
    
    @FXML
    public void precargarPantallaMenu() {
        
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/FXMLPantallaMenu.fxml"));
            pantallaMenu = loaderMenu.load();
            menuController
                    = loaderMenu.getController();

            menuController.setPrincipal(this);

        } catch (IOException ex) {

            Logger.getLogger(FXMLPantallaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void precargarPantallaOpciones() {
        
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/FXMLPantallaOpciones.fxml"));
            pantallaOpciones = loaderMenu.load();
            opcionesController
                    = loaderMenu.getController();

            opcionesController.setPrincipal(this);

        } catch (IOException ex) {

            Logger.getLogger(FXMLPantallaOpcionesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void precargarPantallaPersonalizar() {
        
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/FXMLPantallaPersonalizar.fxml"));
            pantallaPersonalizar = loaderMenu.load();
            personalizarController
                    = loaderMenu.getController();

            personalizarController.setPrincipal(this);

        } catch (IOException ex) {

            Logger.getLogger(FXMLPantallaPersonalizarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void precargarPantallaPrincipiante() {
        
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/FXMLPantallaPrincipiante.fxml"));
            pantallaPrincipiante = loaderMenu.load();
            principianteController
                    = loaderMenu.getController();

            principianteController.setPrincipal(this);

        } catch (IOException ex) {

            Logger.getLogger(FXMLPantallaPrincipianteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void precargarPantallaDificil() {
        
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/FXMLPantallaDificil.fxml"));
            pantallaDificil = loaderMenu.load();
            dificilController
                    = loaderMenu.getController();

            dificilController.setPrincipal(this);

        } catch (IOException ex) {

            Logger.getLogger(FXMLPantallaDificilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void precargarPantallaElegir() {
        
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/FXMLPantallaElegir.fxml"));
            pantallaElegir = loaderMenu.load();
            elegirController
                    = loaderMenu.getController();

            elegirController.setPrincipal(this);

        } catch (IOException ex) {

            Logger.getLogger(FXMLPantallaElegirController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void precargarPantallaIntermedio() {
        
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/FXMLPantallaIntermedio.fxml"));
            pantallaIntermedio = loaderMenu.load();
            intermedioController
                    = loaderMenu.getController();

            intermedioController.setPrincipal(this);

        } catch (IOException ex) {

            Logger.getLogger(FXMLPantallaIntermedioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void precargarPantallaJuegoPersonalizado() {
        
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/FXMLPantallaJuegoPersonalizado.fxml"));
            pantallaJuegoPersonalizado = loaderMenu.load();
            juegoPersonalizadoController
                    = loaderMenu.getController();

            juegoPersonalizadoController.setPrincipal(this);

        } catch (IOException ex) {

            Logger.getLogger(FXMLPantallaJuegoPersonalizadoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void cargarPantallaMenu() {
        fxMenu.setVisible(false);
        fxRoot.setCenter(pantallaMenu);
        fxRoot.setMinHeight(500);
        fxRoot.setMinWidth(600);
    }

    @FXML
    public void cargarPantallaOpciones() {
        
        fxRoot.setCenter(pantallaOpciones);
        fxRoot.setMinHeight(500);
        fxRoot.setMinWidth(600);
    }

    @FXML
    public void cargarPantallaElegir() {
        fxRoot.setCenter(pantallaElegir);
        fxRoot.setMinHeight(400);
        fxRoot.setMinWidth(600);
    }

    @FXML
    public void cargarPantallaPersonalizar() {
        fxRoot.setCenter(pantallaPersonalizar);
        fxRoot.setMinHeight(400);
        fxRoot.setMinWidth(600);
    }
    
    @FXML
    public void cargarPantallaPrincipiante() {
        fxRoot.setCenter(pantallaPrincipiante);
        fxRoot.setMinHeight(400);
        fxRoot.setMinWidth(600);

    }
    @FXML
    public void cargarNuevaPantallaPrincipiante() {
        String mina = elegirController.Tablero();
        principianteController.fxLabelNumeroMinasPrincipiante.setText(mina);
        fxRoot.setCenter(pantallaPrincipiante);
        fxRoot.setMinHeight(400);
        fxRoot.setMinWidth(600);

    }
    

    @FXML
    public void cargarPantallaDificil() {
        fxRoot.setCenter(pantallaDificil);
    }
    
    @FXML
    public void cargarNuevaPantallaDificil() {
        String mina = elegirController.Tablero();
        dificilController.fxLabelNumeroMinasDificil.setText(mina);
        fxRoot.setCenter(pantallaDificil);
    }
    
    //https://www.youtube.com/watch?v=JwcyxuKko_M&t=660s
    
    @FXML
    public void cargarPantallaIntermedio() {
        fxRoot.setCenter(pantallaIntermedio);
        fxRoot.setMinHeight(400);
        fxRoot.setMinWidth(600);
    }
    @FXML
    public void cargarNuevaPantallaIntermedio() {
        String mina = elegirController.Tablero();
        intermedioController.fxLabelNumeroMinasIntermedio.setText(mina);
        fxRoot.setCenter(pantallaIntermedio);
        fxRoot.setMinHeight(400);
        fxRoot.setMinWidth(600);
    }
    
    
    
    public void clickInicio() {

    }

    public void clickGuia() {

    }

    public void clickSalir() {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        precargarPantallaMenu();
        precargarPantallaOpciones();
        precargarPantallaDificil();
        precargarPantallaElegir();
        precargarPantallaIntermedio();
        precargarPantallaPersonalizar();
        precargarPantallaPrincipiante();
        //precargarPantallaJuegoPersonalizado();
        cargarPantallaMenu();
    }
}
