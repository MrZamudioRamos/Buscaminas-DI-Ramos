package ramos.clases;

import java.util.Random;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import ramos.controllers.FXMLPantallaElegirController;

/**
 *
 * @author carlu
 */
public class Juego {
    
    protected Button[][] tablero;
    
    public void Game(){
    
    }
    
    public void rellenar(GridPane pane,int rows, int col ){
        tablero = new Button[rows][col];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                tablero[i][j] = new Button();
                tablero[i][j].setMinSize(30, 20);
                int columna = i;
                int fila = j;
                tablero[i][j].setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("row: "+fila +" col: "+columna);
                        tablero[columna][fila].setDisable(true);
                        tablero[columna][fila].setVisible(false);
                        
                        
                        
                    }
                });
                
                pane.add(tablero[i][j], i, j);
            }
        }
    }
    
    
    
    public void MeterMinas(){
    
        Random rnd = new Random();
        FXMLPantallaElegirController elegir = new FXMLPantallaElegirController();
        
        int Minas = elegir.darMinas();
        
        
        
    
    
    }
    
}
