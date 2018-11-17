package ramos.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author carlu
 */
public class FXMLPantallaAyudaController implements Initializable {
    
    private FXMLPantallaPrincipalController principal;
    
    @FXML
    protected AnchorPane AyudaScene;
    
    public FXMLPantallaPrincipalController getPrincipal() {
        return principal;
    }

    public void setPrincipal(FXMLPantallaPrincipalController principal) {
        this.principal = principal;
    }
    
    public void BackMenu(){
    principal.cargarPantallaMenu();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
