package ramos.clases;

import java.util.Random;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import ramos.controllers.FXMLPantallaElegirController;

/**
 *
 * @author carlu
 */
public class Juego {
    
    protected Button[][] tablero;
    
    public void Game() {
        
    }
    
    public Button[][] rellenar(GridPane pane, int rows, int col) {
        tablero = new Button[rows][col];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                ImageView im = new ImageView("/images/Square.png");
                tablero[i][j] = new Button();
                tablero[i][j].setMinSize(30, 20);
                tablero[i][j].setStyle("-fx-border-color: black;");
                tablero[i][j].setGraphic(im);
                int columna = i;
                int fila = j;
                tablero[i][j].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("row: " + fila + " col: " + columna);
                        if (tablero[columna][fila].isPressed()) {
                            tablero[columna - 1][fila - 1].setDisable(true);
                            tablero[columna - 1][fila - 1].setVisible(false);
                            
                            tablero[columna - 1][fila].setDisable(true);
                            tablero[columna - 1][fila].setVisible(false);
                            
                            tablero[columna - 1][fila + 1].setDisable(true);
                            tablero[columna - 1][fila + 1].setVisible(false);
                            
                            tablero[columna][fila - 1].setDisable(true);
                            tablero[columna][fila - 1].setVisible(false);
                            
                            tablero[columna][fila + 1].setDisable(true);
                            tablero[columna][fila + 1].setVisible(false);
                            
                            tablero[columna + 1][fila - 1].setDisable(true);
                            tablero[columna + 1][fila - 1].setVisible(false);
                            
                            tablero[columna + 1][fila].setDisable(true);
                            tablero[columna + 1][fila].setVisible(false);
                            
                            tablero[columna + 1][fila + 1].setDisable(true);
                            tablero[columna + 1][fila + 1].setVisible(false);
                        }
                        tablero[columna][fila].setDisable(true);
                        tablero[columna][fila].setVisible(false);
                        
                    }
                });
                pane.add(tablero[i][j], i, j);
            }
        }
        return tablero;
    }
    
    public void sortear(Button[][] tablero, int numMinas, int tamanio) {
        for (int i = 0; i < numMinas; i++) {
            int xCor = (int) (Math.random() * (tamanio - 1)); //xCor variable auxiliar de coordenada X
            int yCor = (int) (Math.random() * (tamanio - 1)); //yCor variable auxiliar de coordenada Y
            //Condicion que verifica que no se repita una mina en el mismo lugar
//            if (tablero[xCor][yCor] != null) {
//                tablero[xCor][yCor] = ;
//            } else {
//                i--;
//            }

        }
    }
    
    public int parsearMinas(String minas) {
        
        int nMinas = Integer.parseInt(minas);
        
        return nMinas;
        
    }
    
    public void MeterMinas() {
        
        Random rnd = new Random();
        FXMLPantallaElegirController elegir = new FXMLPantallaElegirController();
        
        int Minas = elegir.darMinas();
        
    }
    
    public void DetectarMinas(int rows, int col) {
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                
                if (tablero[i][j].isPressed()) {
                    for (int k = 0; k < 10; k++) {

//                        tablero[k][l].equals("*");
//                        tablero[k][l].setDisable(true);
//                        tablero[k][l].setVisible(false);
                    }
                    
                }
                
            }
        }
        
    }
    
}
