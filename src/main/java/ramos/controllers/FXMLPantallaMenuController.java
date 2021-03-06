package ramos.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import ramos.core.NumeroDeVidasFueraDeRangoException;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class FXMLPantallaMenuController implements Initializable {
    
    @FXML
    private Rectangle Icon;
    
    @FXML
    private javafx.scene.control.Button closeButton;
    
    private FXMLPantallaPrincipianteController fXMLPantallaPrincipianteController;
    
    @FXML 
    private AnchorPane anchor;

    private FXMLPantallaPrincipalController principal;

    public FXMLPantallaPrincipalController getPrincipal() {
        return principal;
    }

    public void setPrincipal(FXMLPantallaPrincipalController principal) {
        this.principal = principal;
    }
    
    public void clickJugar() throws NumeroDeVidasFueraDeRangoException {
        principal.precargarPantallaPrincipiante(12);
        principal.cargarNuevaPantallaPrincipiante();
    }

    public void clickPersonalizar() {
        principal.cargarPantallaOpciones();
        
    }

    public void clickVerRanking() {
        principal.cargarPantallaRanking();
    }

    public void clickAyuda() {
        principal.cargarPantallaAyuda();
        
    }

    public void clickSalir() {
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ImagePattern imagePattern = new ImagePattern(new Image("/images/icon.png"));
        Icon.setFill(imagePattern);
    }

}
