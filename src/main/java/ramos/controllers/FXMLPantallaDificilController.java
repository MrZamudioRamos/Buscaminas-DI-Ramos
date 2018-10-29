/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramos.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import ramos.clases.Juego;
import ramos.clases.Temporizador;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class FXMLPantallaDificilController implements Initializable {

    private FXMLPantallaPrincipalController principal;
    private int rows=21, col=21;
    
    @FXML
    protected GridPane fxGridPaneMinasDificil;
    
    @FXML
    protected Label fxLabelNumeroMinasDificil;
    
    @FXML
    protected Text fxText;
    public Label getFxLabelNumeroMinasDificil() {
        return fxLabelNumeroMinasDificil;
    }
    

    public FXMLPantallaPrincipalController getPrincipal() {
        return principal;
    }
    
    public void Tablero(){
    Juego game = new Juego();   
   // game.rellenar(fxGridPaneMinasDificil, rows, col);
    }

    public void setPrincipal(FXMLPantallaPrincipalController principal) {
        this.principal = principal;
    }
    
    public void clickReiniciarDificil(){
       start();
    }
    
    public void start(){
        Temporizador temp = new Temporizador();
        temp.setSeconds(0);
        temp.time(fxText);
        temp.start();
    }
    
    public void clickSalirDificil(){
        principal.cargarPantallaElegir();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Tablero();
    }

}
