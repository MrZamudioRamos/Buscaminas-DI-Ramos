/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramos.constructor;

import ramos.clases.Tablero;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;
import ramos.interfaz.PersonalizarEventHandler;

/**
 * Class used to build Panes according to the model
 *
 * @author Gaetan
 */
public class PaneConstructor {

    /**
     * Create gridPane (adapted for Board2D)
     *
     * @param model Model
     * @param executor Service launching the imageRefresher
     * @return
     */
    public static void createButtonGrid(GridPane grid, int X, int Y) {
        // https://stackoverflow.com/a/35345799
        for (int rowIndex = 0; rowIndex < grid.impl_getRowCount(); rowIndex++) {
            RowConstraints rc = new RowConstraints();
            rc.setVgrow(Priority.ALWAYS); // allow row to grow
            rc.setFillHeight(true); // ask nodes to fill height for row
            // other settings as needed...
            grid.getRowConstraints().add(rc);
        }
        for (int colIndex = 0; colIndex < grid.impl_getColumnCount(); colIndex++) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setHgrow(Priority.ALWAYS); // allow column to grow
            cc.setFillWidth(true); // ask nodes to fill space for column
            // other settings as needed...
            grid.getColumnConstraints().add(cc);
        }

        // TODO: function is to long. Can't do static...
        Function<Button, Button> mouseClicked = it -> {
            it.setOnMouseClicked(e -> {
                if (e.getButton().equals(MouseButton.SECONDARY)) {
//                    markAsMine((Button) e.getSource());
                } else {
//                    openCell((Button) e.getSource());
                }
            });
            return it;
        };

        Function<Button, Button> mouseOn = it -> {
            it.setOnMouseMoved(e -> ((Button) e.getSource()).setStyle("-fx-text-fill: rgba(0,0,0,0.29);"));
            return it;
        };

//        Function<Button, Button> mouseOff = it -> {
//            it.setOnMouseExited(e-> ((Button)e.getSource()).setStyle("-fx-text-fill: rgb(0,0,0);") );
//            return it;
//        };
        // Slightly shorter/cleaner version (like above commented code)
        UnaryOperator<Button> mouseOff = it -> {
            it.setOnMouseExited(e -> ((Button) e.getSource()).setStyle("-fx-text-fill: rgb(0,0,0);"));
            return it;
        };

        Function<Button, Button> mouseHover = mouseOn.andThen(mouseOff);  //Same as: it-> mouseOff.apply( mouseOn.apply(it) );

        // shorten version
        grid.getChildren().addAll(
//                game.stream()
//                        .map(Util::createButton)
//                        .map(mouseClicked)
//                        .map(mouseHover)
//                        .collect(Collectors.toList())
        );
    
    }
    public static GridPane crearGridPane(Tablero model, ExecutorService executor) {
        return buildGridPane(model, executor);
    }

    /**
     * Method to build the playing grid
     *
     * @param model
     * @param executor
     * @return
     */
    private static GridPane buildGridPane(Tablero model, ExecutorService executor) {
        int column = 0;
        int row = 0;
        GridPane gPane = new GridPane();

        for (int i = 0; i < model.getTablero().size(); i++) {
            for (int j = 0; j < model.getTablero().get(i).size(); j++) {
//                Node n = GUI.createImageView();
//                gPane.add(n, column++, row);
//                GUI.getCaseNodes().get(i).add(n);

                //When reaching end of a row
                if (column > model.getTablero().get(row).size() - 1) {
                    column = 0;
                    row++;
                }
//                n.setOnMouseClicked(new PersonalizarEventHandler(model, i, j, executor));
            }
        }
        gPane.setBorder(Border.EMPTY);
        gPane.setPadding(new Insets(2, 2, 2, 2));
        return gPane;
    }

    /**
     * Create stack pane (header)
     *
     * @param smiley
     * @param image
     * @param model
     * @param executor
     * @return
     */
    public static StackPane createStackPane(Button smiley, Image image, Tablero model, ExecutorService executor) {

        StackPane stack = new StackPane();
        stack.getChildren().addAll(smiley);
        stack.setAlignment(Pos.CENTER);     // Right-justify nodes in stack
        return stack;
    }

    /**
     * Create a BorderPane (used with TableroPyramid)
     *
     * @param model
     * @param executor
     * @return
     */
    public static BorderPane createBorderPane(Tablero model, ExecutorService executor, Double sizeSideTriangle) {
        return buildBorderPane(model, executor, sizeSideTriangle);
    }

    /**
     * Build the border pane according to the model (Tablero) given
     *
     * @param model
     * @return the border pane built
     */
    private static BorderPane buildBorderPane(Tablero model, ExecutorService executor, Double sizeSideTriangle) {
        BorderPane borderPane = new BorderPane();

        List<List<Polygon>> pyramid = createPyramid(model.getTablero().size(), sizeSideTriangle);
        for (int i = 0; i < pyramid.size(); i++) {
            for (int j = 0; j < pyramid.get(i).size(); j++) {
                Polygon p = pyramid.get(i).get(j);
//                p.setOnMouseClicked(new PersonalizarEventHandler(model, i, j, executor));
//                borderPane.getChildren().add(p);
//                p.setFill(new ImagePattern(GUI.createImageView().getImage())); // Todo maybe change here
//                GUI.getCaseNodes().get(i).add(p);
            }
        }
        return borderPane;
    }

    private static List<List<Polygon>> createPyramid(int sideSize, Double sizeSideTriangle) {
        Double y, x = y = 0.0;
        Double sideX = sizeSideTriangle;
        Double sideY = sideX;// Math.cos(Math.PI / 6) * sideX;
        List<List<Polygon>> list = new ArrayList<>();
        for (int i = sideSize; i > 0; i--) {
            list.add(createRowPolygons(x, y, sideX, sideY, i));
            x += sideX / 2;
            y += sideY;
        }
        return list;
    }

    private static ArrayList<Polygon> createRowPolygons(Double x, Double y, Double sideX, Double sideY, int nbShapes) {
        ArrayList<Polygon> polygons = new ArrayList<>();
        Double ax = x, ay = y;
        Double bx, by;
        Double cx = x, cy = y;
        for (int i = 0; i < nbShapes; i++) {
            ax = cx;
            ay = cy;
            bx = ax + sideX / 2;
            by = y + sideY;
            cx += sideX;
            cy = y;
            Polygon poly = new Polygon();
            Polygon poly2 = new Polygon();
            poly.getPoints().addAll(new Double[]{
                ax, ay,
                bx, by,
                cx, cy,});
            polygons.add(poly);
            if (i + 1 != nbShapes) {
                poly2.getPoints().addAll(new Double[]{
                    bx + sideX, by,
                    bx, by,
                    cx, cy,});
                polygons.add(poly2);
            }
        }

        return polygons;
    }
}