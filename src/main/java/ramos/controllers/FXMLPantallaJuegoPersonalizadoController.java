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
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class FXMLPantallaJuegoPersonalizadoController implements Initializable {

    @FXML
    private final GridPane fxGridPanePersonalizado = new GridPane();

    private FXMLPantallaPersonalizarController personalizar;

    public FXMLPantallaPersonalizarController getPersonalizar() {
        return personalizar;
    }

    public void setPersonalizar(FXMLPantallaPersonalizarController personalizar) {
        this.personalizar = personalizar;
    }
    
    public void clickReiniciarPersonalizado(){
        
    }
    
    public void clickSalirPersonalizado(){
        
    }
    
//    public GridPane obtenerDimensiones() {
//
//        int numeroAlto = personalizar.getValorAlto();
//
//        int numeroAncho = personalizar.getValorAncho();
//        
//        return null;
//        
//    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        fxGridPanePersonalizado.setLayoutX(324);
//        fxGridPanePersonalizado.setLayoutY(201);
//        
//        int numFilas = personalizar.getValorAncho();
//        int numColumnas = personalizar.getValorAlto();
//        for (int filas = 0; filas <= numFilas; filas++) {
//            RowConstraints rc = new RowConstraints();
//            rc.setVgrow(Priority.ALWAYS);
//            rc.setFillHeight(true);
//            fxGridPanePersonalizado.getRowConstraints().add(rc);
//        }
//        for (int columnas = 0; columnas <= numColumnas; columnas++) {
//            ColumnConstraints cc = new ColumnConstraints();
//            cc.setHgrow(Priority.ALWAYS);
//            cc.setFillWidth(true);
//            fxGridPanePersonalizado.getColumnConstraints().add(cc);
//        }
    }

}
