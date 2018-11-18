package ramos.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author carlu
 */
public class FXMLPantallaRankingController implements Initializable {
    
    private FXMLPantallaPrincipalController principal;
    
    @FXML
    protected ComboBox fxTamanio;
    
    
    public FXMLPantallaPrincipalController getPrincipal() {
        return principal;
    }

    public void setPrincipal(FXMLPantallaPrincipalController principal) {
        this.principal = principal;
    }

    
    public void cargarTamanio(){
        ObservableList<String> size = FXCollections.observableArrayList("Pequeño", "Mediano", "Grande", "Personalizado");
        fxTamanio.setItems(size);
    }
    
    public void BackMenu(){
        principal.cargarPantallaMenu(); 
    }
    
    public void ShowRanking(){
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarTamanio();        
    }    
    
}
