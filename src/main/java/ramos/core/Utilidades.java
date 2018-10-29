/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramos.core;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;

/**
 *
 * @author Ricardo
 */
public class Utilidades {

    
//    static final int TILE_SIZE = 40;
//    private static final int W = 800;
//    private static final int H = 600;
//
//    private static final int X_TILES = W / TILE_SIZE;
//    private static final int Y_TILES = H / TILE_SIZE;
//
//    private Casilla[][] grid = new Casilla[X_TILES][Y_TILES];
//
//    public Parent createContent() {
//        Pane root = new Pane();
//        root.setPrefSize(W, H);
//
//        for (int y = 0; y < Y_TILES; y++) {
//            for (int x = 0; x < X_TILES; x++) {
//                Casilla tile = new Casilla(x, y, Math.random() < 0.2);
//
//                grid[x][y] = tile;
//                root.getChildren().add(tile);
//            }
//        }
//
//        for (int y = 0; y < Y_TILES; y++) {
//            for (int x = 0; x < X_TILES; x++) {
//                Casilla tile = grid[x][y];
//
//                if (tile.hasBomb) {
//                    continue;
//                }
//
//                long bombs = getNeighbors(tile).stream().filter(t -> t.hasBomb).count();
//
//                if (bombs > 0) {
//                    tile.text.setText(String.valueOf(bombs));
//                }
//            }
//        }
//
//        return root;
//    }

}
