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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ramos.core.NumeroDeVidasFueraDeRangoException;

/**
 * FXML Controller class
 *
 * @author dam2
 */
public class FXMLPantallaPrincipalController implements Initializable {

    @FXML
    protected BorderPane fxRoot;

   
    private FXMLPantallaIntermedioController intermedio;

    private FXMLPantallaPersonalizarController personalizar;

    private FXMLPantallaElegirController elegir;

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
    private FXMLPantallaJuegoPersonalizadoController juegoPersonalizadoController;
    private AnchorPane pantallaAyuda;
    private FXMLPantallaAyudaController AyudaController;
    private AnchorPane pantallaRanking;
    private FXMLPantallaRankingController RankingController;

    public FXMLPantallaPersonalizarController getPersonalizar() {
        return personalizar;
    }

    public void setPersonalizar(FXMLPantallaPersonalizarController personalizar) {
        this.personalizar = personalizar;
    }

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
    public void precargarPantallaAyuda() {

        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/FXMLPantallaAyuda.fxml"));
            pantallaAyuda = loaderMenu.load();
            AyudaController
                    = loaderMenu.getController();
            AyudaController.setPrincipal(this);

        } catch (IOException ex) {

            Logger.getLogger(FXMLPantallaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    public void precargarPantallaRanking() {

        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/FXMLPantallaRanking.fxml"));
            pantallaRanking = loaderMenu.load();
            RankingController
                    = loaderMenu.getController();
            RankingController.setPrincipal(this);

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
    public void precargarPantallaPrincipiante(int minas) {

        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/FXMLPantallaPrincipiante.fxml"));
            pantallaPrincipiante = loaderMenu.load();
            principianteController
                    = loaderMenu.getController();

            principianteController.setMinas(minas);
            principianteController.Tablero();
            principianteController.setPrincipal(this);

        } catch (IOException ex) {

            Logger.getLogger(FXMLPantallaIntermedioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void precargarPantallaDificil(int minas) {

        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/FXMLPantallaDificil.fxml"));
            pantallaDificil = loaderMenu.load();
            dificilController
                    = loaderMenu.getController();
            dificilController.setMinas(minas);
            dificilController.Tablero();
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
    public void precargarPantallaIntermedio(int minas) {

        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/FXMLPantallaIntermedio.fxml"));
            pantallaIntermedio = loaderMenu.load();
            intermedioController
                    = loaderMenu.getController();
//            pantallaIntermedio.setMinSize(640, 481);
            intermedioController.setMinas(minas);
            intermedioController.Tablero();
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
        fxRoot.setCenter(pantallaMenu);
//        fxRoot.setMinHeight(500);
//        fxRoot.setMinWidth(600);
    }

    @FXML
    public void cargarPantallaOpciones() {

        fxRoot.setCenter(pantallaOpciones);
//        fxRoot.setMinHeight(500);
//        fxRoot.setMinWidth(600);
    }

    @FXML
    public void cargarPantallaElegir() {
        fxRoot.setCenter(pantallaElegir);
//        fxRoot.setMinHeight(400);
//        fxRoot.setMinWidth(600);
    }

    @FXML
    public void cargarPantallaPersonalizar() {
        fxRoot.setCenter(pantallaPersonalizar);
//        fxRoot.setMinHeight(400);
//        fxRoot.setMinWidth(600);
    }

    @FXML
    public void cargarPantallaPrincipiante() {
        principianteController.start();
        fxRoot.setCenter(pantallaPrincipiante);
//        fxRoot.setMinHeight(400);
//        fxRoot.setMinWidth(600);

    }

    @FXML
    public void cargarNuevaPantallaPrincipiante() {
        String mina = elegirController.Tablero();
        principianteController.fxLabelNumeroMinasPrincipiante.setText(mina);
        fxRoot.setCenter(pantallaPrincipiante);
//        fxRoot.setMinHeight(400);
//        fxRoot.setMinWidth(600);

    }
    
    @FXML
    public void cargarNuevaPantallaIntermedio() {
        String mina = elegirController.Tablero();
        intermedioController.fxLabelNumeroMinasIntermedio.setText(mina);
        fxRoot.setCenter(pantallaIntermedio);
//        fxRoot.setMinHeight(400);
//        fxRoot.setMinWidth(600);

    }

    @FXML
    public void cargarPantallaDificil() {
        dificilController.start();
//        fxRoot.setMinHeight(643);
//        fxRoot.setMinWidth(840);
        fxRoot.setCenter(pantallaDificil);
        
    }

    @FXML
    public void cargarNuevaPantallaDificil() {
        String mina = elegirController.Tablero();
        dificilController.fxLabelNumeroMinasDificil.setText(mina);
//        fxRoot.setMinHeight(800);
//        fxRoot.setMinWidth(1000);
        fxRoot.setCenter(pantallaDificil);
        
    }

    @FXML
    public void cargarPantallaIntermedio() {
        intermedioController.start();
//        fxRoot.setMinHeight(481);
//        fxRoot.setMinWidth(640);
        fxRoot.setCenter(pantallaIntermedio);
        
    }

    @FXML
    public void cargarPantallaJuegoPersonalizado() {
        try {
            juegoPersonalizadoController.juegoNuevo(personalizar.getValorAncho(), personalizar.getValorAlto(), personalizar.darMinas(), 1);
        } catch (NumeroDeVidasFueraDeRangoException ex) {
            Logger.getLogger(FXMLPantallaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fxRoot.setCenter(pantallaJuegoPersonalizado);
//        fxRoot.setMinHeight(400);
//        fxRoot.setMinWidth(600);
    }
    
    @FXML
    public void cargarPantallaAyuda() {
        fxRoot.setCenter(pantallaAyuda);
        
    }
    
    @FXML
    public void cargarPantallaRanking() {
        fxRoot.setCenter(pantallaRanking);
        
    }

    public void clickInicio() {
        cargarPantallaOpciones();
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
        precargarPantallaRanking();
        precargarPantallaAyuda();
        precargarPantallaOpciones();
        // precargarPantallaDificil();
        precargarPantallaElegir();
        
        //precargarPantallaIntermedio();
        precargarPantallaPersonalizar();
        //precargarPantallaPrincipiante();
        precargarPantallaJuegoPersonalizado();
        cargarPantallaMenu();
    }
}
