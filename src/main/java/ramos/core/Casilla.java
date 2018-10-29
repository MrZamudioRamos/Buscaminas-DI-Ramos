/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramos.core;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

/**
 *
 * @author dam2
 */
public class Casilla extends Button {

    private int x;
    private int y;

    public Casilla(int x, int y, String texto) {
        super(texto);
        this.x = x;
        this.y = y;

        // Adjudico una ID con las coordenadas a la casilla. Esto me será
        // útil para hacer referencia a dicha casilla en el futuro, aunque
        // aún no sé cómo, lo que hago de momento es meter cada objeto en
        // una matriz.
        this.setId("casilla_" + this.x + "_" + this.y);

        // Le adjudico el estilo llamado "casilla" de la plantilla CSS.
        this.getStyleClass().add("casilla");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

//	private int x, y;
//        boolean hasBomb;
//        private boolean isOpen = false;
//
//        private Text text = new Text();
//        private FXMLPantallaIntermedioController intermedio;
//        public Casilla(int x, int y, boolean hasBomb) {
//            this.x = x;
//            this.y = y;
//            this.hasBomb = hasBomb;
//
//            intermedio.getFxRectangleIntermedio().setStroke(Color.LIGHTGRAY);
//
//            text.setFont(Font.font(18));
//            text.setText(hasBomb ? "X" : "");
//            text.setVisible(false);
//
//            getChildren().addAll(intermedio.getFxRectangleIntermedio(), text);
//
//            setTranslateX(x * TILE_SIZE);
//            setTranslateY(y * Utilidades.TILE_SIZE);
//
//            setOnMouseClicked(e -> open());
//        }
//
//        public void open() {
//            if (isOpen)
//                return;
//
//            if (hasBomb) {
//               System.out.println("Game Over");
//               scene.setRoot(createContent());
//               return;
//            }
//
//            isOpen = true;
//            text.setVisible(true);
//            intermedio.getFxRectangleIntermedio().setFill(null);
//
//            if (text.getText().isEmpty()) {
//                getNeighbors(this).forEach(Casilla::open);
//            }
//        }
//        
//        private List<Casilla> getNeighbors(Casilla tile) {
//        List<Casilla> neighbors = new ArrayList<>();
//
//        // ttt
//        // tXt
//        // ttt
//
//        int[] points = new int[] {
//              -1, -1,
//              -1, 0,
//              -1, 1,
//              0, -1,
//              0, 1,
//              1, -1,
//              1, 0,
//              1, 1
//        };
//
//        for (int i = 0; i < points.length; i++) {
//            int dx = points[i];
//            int dy = points[++i];
//
//            int newX = tile.x + dx;
//            int newY = tile.y + dy;
//
//            if (newX >= 0 && newX < Utilidades.X_TILES
//                    && newY >= 0 && newY < Y_TILES) {
//                neighbors.add(grid[newX][newY]);
//            }
//        }
//
//        return neighbors;
//    }
}
