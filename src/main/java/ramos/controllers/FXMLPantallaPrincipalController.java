/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramos.controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ramos.core.Ficheros;
import ramos.core.NumeroDeVidasFueraDeRangoException;
import ramos.core.Usuario;

/**
 * FXML Controller class
 *
 * @author dam2
 */
public class FXMLPantallaPrincipalController implements Initializable {

    @FXML
    protected BorderPane fxRoot;

    Ficheros fich = new Ficheros();

    protected ArrayList<Usuario> ez = new ArrayList<>();
    protected ArrayList<Usuario> med = new ArrayList<>();
    protected ArrayList<Usuario> dif = new ArrayList<>();
    protected ArrayList<Usuario> pers = new ArrayList<>();

    protected ArrayList<String> ezrank = new ArrayList<>();
    protected ArrayList<String> medrank = new ArrayList<>();
    protected ArrayList<String> difrank = new ArrayList<>();
    protected ArrayList<String> persrank = new ArrayList<>();

    public void Rankings() {
        ezrank.add("PeqFa.dat");
        ezrank.add("PeqMe.dat");
        ezrank.add("PeqDi.dat");
        
        medrank.add("MedFa.dat");
        medrank.add("MedMe.dat");
        medrank.add("MedDif.dat");
        
        difrank.add("DifFa.dat");
        difrank.add("DifMe.dat");
        difrank.add("DifDi.dat");
        
        persrank.add("PersFa.dat");
        persrank.add("PersMe.dat");
        persrank.add("PersDi.dat");
        
    }

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
    private String rank;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
    

    public FXMLPantallaPersonalizarController getPersonalizar() {
        return personalizar;
    }

    public void setPersonalizar(FXMLPantallaPersonalizarController personalizar) {
        this.personalizar = personalizar;
    }

    //FICHEROS
    public ArrayList<Usuario> getEz() {
        return ez;
    }

    public void setEz(ArrayList<Usuario> ez) {
        this.ez = ez;
    }

    public ArrayList<Usuario> getMed() {
        return med;
    }

    public void setMed(ArrayList<Usuario> med) {
        this.med = med;
    }

    public ArrayList<Usuario> getDif() {
        return dif;
    }

    public void setDif(ArrayList<Usuario> dif) {
        this.dif = dif;
    }

    public ArrayList<Usuario> getPers() {
        return pers;
    }

    public void setPers(ArrayList<Usuario> pers) {
        this.pers = pers;
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

    public void ArchivosRanking() throws FileNotFoundException, IOException {
        //verifica los rankings del pequeño
        File archivo;
        BufferedWriter bw;
        for (int i = 0; i < ezrank.size(); i++) {
            archivo = new File(ezrank.get(i));
            if(!archivo.exists()){
                bw = new BufferedWriter(new FileWriter(archivo));
            }
        }
        //verifica los rankings del mediano
        for (int i = 0; i < medrank.size(); i++) {
            archivo = new File(medrank.get(i));
            if(!archivo.exists()){
                bw = new BufferedWriter(new FileWriter(archivo));
            }
        }
        //verifica los rankings del grande
        for (int i = 0; i < difrank.size(); i++) {
            archivo = new File(difrank.get(i));
            if(!archivo.exists()){
                bw = new BufferedWriter(new FileWriter(archivo));
            }
        }
        //verifica los rankings del personalizado
        for (int i = 0; i < persrank.size(); i++) {
            archivo = new File(persrank.get(i));
            if(!archivo.exists()){
                bw = new BufferedWriter(new FileWriter(archivo));
            }
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Rankings();
        precargarPantallaMenu();
        precargarPantallaRanking();
        precargarPantallaAyuda();
        precargarPantallaOpciones();
        precargarPantallaElegir();
        precargarPantallaPersonalizar();
        precargarPantallaJuegoPersonalizado();
        cargarPantallaMenu();
        try {
            ArchivosRanking();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLPantallaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPantallaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
