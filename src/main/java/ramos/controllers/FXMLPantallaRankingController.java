package ramos.controllers;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import ramos.core.Ficheros;
import ramos.core.Usuario;

/**
 * FXML Controller class
 *
 * @author carlu
 */
public class FXMLPantallaRankingController implements Initializable {
    
    private FXMLPantallaPrincipalController principal;
    
    @FXML
    protected ComboBox fxTamanio;
    
    @FXML
    protected ListView fxFacil;
    
    @FXML
    protected ListView fxMedio;
    
    @FXML
    protected ListView fxDificil;
    
    protected ArrayList<String> usuariofacil = new ArrayList<>();
    protected ArrayList<String> usuariomedio = new ArrayList<>();
    protected ArrayList<String> usuariodificil = new ArrayList<>();
    
    
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
    
    public void ShowRanking() throws FileNotFoundException, IOException{
        
        String tam = fxTamanio.getValue().toString();
        Ficheros fich = new Ficheros();
        
        
        switch(tam){
            case "Pequeño":
                if(!usuariofacil.isEmpty()){
                usuariofacil.clear();
                }else if(!usuariomedio.isEmpty()){
                usuariomedio.clear();
                }else if(!usuariodificil.isEmpty()){
                usuariodificil.clear();}
                
                
                DataInputStream ez = new DataInputStream(new FileInputStream("PeqFa.dat"));
                DataInputStream med = new DataInputStream(new FileInputStream("PeqMe.dat"));
                DataInputStream dif = new DataInputStream(new FileInputStream("PeqDi.dat"));
                
                usuariofacil.add(ez.readUTF());
                ObservableList fac = FXCollections.observableArrayList(usuariofacil);
                fxFacil.setItems(fac);
                
                usuariomedio.add(med.readUTF());
                ObservableList m = FXCollections.observableArrayList(usuariomedio);
                fxMedio.setItems(m);
                
                usuariodificil.add(dif.readUTF());
                ObservableList d = FXCollections.observableArrayList(usuariodificil);
                fxDificil.setItems(d);
                
                break;
            case "Mediano":
                if(!usuariofacil.isEmpty()){
                usuariofacil.clear();
                }else if(!usuariomedio.isEmpty()){
                usuariomedio.clear();
                }else if(!usuariodificil.isEmpty()){
                usuariodificil.clear();}
                
                DataInputStream medez = new DataInputStream(new FileInputStream("MedFa.dat"));
                DataInputStream medmed = new DataInputStream(new FileInputStream("MedMe.dat"));
                DataInputStream meddif = new DataInputStream(new FileInputStream("MedDif.dat"));
                
                usuariofacil.add(medez.readUTF());
                ObservableList mefac = FXCollections.observableArrayList(usuariofacil);
                fxFacil.setItems(mefac);
                
                usuariomedio.add(medmed.readUTF());
                ObservableList memed = FXCollections.observableArrayList(usuariomedio);
                fxMedio.setItems(memed);
                
                usuariodificil.add(meddif.readUTF());
                ObservableList medi = FXCollections.observableArrayList(usuariodificil);
                fxDificil.setItems(medi);
                
                break;
            case "Grande":
                
                if(!usuariofacil.isEmpty()){
                usuariofacil.clear();
                }else if(!usuariomedio.isEmpty()){
                usuariomedio.clear();
                }else if(!usuariodificil.isEmpty()){
                usuariodificil.clear();}
                
                DataInputStream grez = new DataInputStream(new FileInputStream("DifFa.dat"));
                DataInputStream grmed = new DataInputStream(new FileInputStream("DifMe.dat"));
                DataInputStream grdif = new DataInputStream(new FileInputStream("DifDi.dat"));
                
                
                usuariodificil.add(grez.readUTF());
                ObservableList grfa = FXCollections.observableArrayList(usuariofacil);
                fxFacil.setItems(grfa);
                
                usuariomedio.add(grmed.readUTF());
                ObservableList grm = FXCollections.observableArrayList(usuariomedio);
                fxFacil.setItems(grm);
                
                usuariodificil.add(grdif.readUTF());
                ObservableList grd = FXCollections.observableArrayList(usuariodificil);
                fxFacil.setItems(grd);
                break;
            case "Personalizado":
                
                if(!usuariofacil.isEmpty()){
                usuariofacil.clear();
                }else if(!usuariomedio.isEmpty()){
                usuariomedio.clear();
                }else if(!usuariodificil.isEmpty()){
                usuariodificil.clear();}
                
                DataInputStream perez = new DataInputStream(new FileInputStream("PersFa.dat"));
                DataInputStream perme = new DataInputStream(new FileInputStream("PersMe.dat"));
                DataInputStream perdi = new DataInputStream(new FileInputStream("PersDi.dat"));
                break;
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarTamanio();        
    }    
    
}
