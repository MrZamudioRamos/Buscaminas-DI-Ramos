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
import ramos.clases.Juego;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class FXMLPantallaElegirController implements Initializable {

    private FXMLPantallaPrincipalController principal;
    private FXMLPantallaPrincipianteController principiante;
    private FXMLPantallaIntermedioController intermedio;
    private FXMLPantallaDificilController dificil;

    Juego j = new Juego();

    public FXMLPantallaPrincipalController getPrincipal() {
        return principal;
    }

    public void setPrincipal(FXMLPantallaPrincipalController principal) {
        this.principal = principal;
    }

    public FXMLPantallaPrincipianteController getPrincipiante() {
        return principiante;
    }

    public void setPrincipiante(FXMLPantallaPrincipianteController principiante) {
        this.principiante = principiante;
    }

    public FXMLPantallaIntermedioController getIntermedio() {
        return intermedio;
    }

    public void setIntermedio(FXMLPantallaIntermedioController intermedio) {
        this.intermedio = intermedio;
    }

    public FXMLPantallaDificilController getDificil() {
        return dificil;
    }

    public void setDificil(FXMLPantallaDificilController dificil) {
        this.dificil = dificil;
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

    public RadioButton getFxElegirFacil() {
        return fxElegirFacil;
    }

    public void setFxElegirFacil(RadioButton fxElegirFacil) {
        this.fxElegirFacil = fxElegirFacil;
    }

    public RadioButton getFxElegirMedio() {
        return fxElegirMedio;
    }

    public void setFxElegirMedio(RadioButton fxElegirMedio) {
        this.fxElegirMedio = fxElegirMedio;
    }

    public RadioButton getFxElegirDificil() {
        return fxElegirDificil;
    }

    public void setFxElegirDificil(RadioButton fxElegirDificil) {
        this.fxElegirDificil = fxElegirDificil;
    }

    public RadioButton getFxElegirGrande() {
        return fxElegirGrande;
    }

    public void setFxElegirGrande(RadioButton fxElegirGrande) {
        this.fxElegirGrande = fxElegirGrande;
    }

    public RadioButton getFxElegirMediano() {
        return fxElegirMediano;
    }

    public void setFxElegirMediano(RadioButton fxElegirMediano) {
        this.fxElegirMediano = fxElegirMediano;
    }

    public RadioButton getFxElegirPequeño() {
        return fxElegirPequeño;
    }

    public void setFxElegirPequeño(RadioButton fxElegirPequeño) {
        this.fxElegirPequeño = fxElegirPequeño;
    }

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

    public String getDificultad() {
        String mines = "";
        if (fxElegirFacil.isSelected()) {
            mines = "96";
        } else if (fxElegirMedio.isSelected()) {
            mines = "120";
        } else if (fxElegirDificil.isSelected()) {
            mines = "160";
        } else {
            mines = "96";
        }
        return mines;
    }

    public int darMinas() {
        
        int mines = 0;
        
        if (fxElegirPequeño.isSelected()) {

            if (fxElegirFacil.isSelected()) {
                mines = 12;
//                j.minasAleatorias(principiante.Tablero(), Integer.parseInt(principiante.getFxLabelNumeroMinasPrincipiante().toString()), mines);
            } else if (fxElegirMedio.isSelected()) {
                mines = 16;
//                j.minasAleatorias(principiante.Tablero(), Integer.parseInt(principiante.getFxLabelNumeroMinasPrincipiante().toString()), mines);
            } else if (fxElegirDificil.isSelected()) {
                mines = 21;
//                j.minasAleatorias(principiante.Tablero(), Integer.parseInt(principiante.getFxLabelNumeroMinasPrincipiante().toString()), mines);
            }
        } else if (fxElegirMediano.isSelected()) {

            if (fxElegirFacil.isSelected()) {
                mines = 51;
//                j.minasAleatorias(principiante.Tablero(), Integer.parseInt(intermedio.getFxLabelNumeroMinasIntermedio().toString()), mines);
            } else if (fxElegirMedio.isSelected()) {
                mines = 64;
//                j.minasAleatorias(principiante.Tablero(), Integer.parseInt(intermedio.getFxLabelNumeroMinasIntermedio().toString()), mines);
            } else if (fxElegirDificil.isSelected()) {
                mines = 85;
//                j.minasAleatorias(principiante.Tablero(), Integer.parseInt(intermedio.getFxLabelNumeroMinasIntermedio().toString()), mines);
            }

        } else if (fxElegirGrande.isSelected()) {

            if (fxElegirFacil.isSelected()) {
                mines = 96;
//                j.minasAleatorias(principiante.Tablero(), Integer.parseInt(dificil.getFxLabelNumeroMinasDificil().toString()), mines);
            } else if (fxElegirMedio.isSelected()) {
                mines = 120;
//                j.minasAleatorias(principiante.Tablero(), Integer.parseInt(dificil.getFxLabelNumeroMinasDificil().toString()), mines);
            } else if (fxElegirDificil.isSelected()) {
                mines = 160;
//                j.minasAleatorias(principiante.Tablero(), Integer.parseInt(dificil.getFxLabelNumeroMinasDificil().toString()), mines);
            }
        }
        return mines;
    }

    public void clickSalirElegir() {
        if (fxElegirPequeño.isSelected()) {
            principal.cargarNuevaPantallaPrincipiante();
        } else if (fxElegirMediano.isSelected()) {
//           principal.cargarNuevaPantallaIntermedio();
            
            principal.precargarPantallaIntermedio(darMinas());
            principal.cargarPantallaIntermedio();
        } else if (fxElegirGrande.isSelected()) {
            principal.cargarNuevaPantallaDificil();
        }
    }

    public void clickAtrasElegir() {
        principal.cargarPantallaOpciones();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
