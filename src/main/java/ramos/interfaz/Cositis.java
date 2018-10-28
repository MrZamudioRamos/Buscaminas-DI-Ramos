/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramos.interfaz;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Ricardo
 */
public class Cositis {
    public static ImageView createImageView() {
        Image image = imageRefresher.buildImage("/images/Square.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(SQUARESIZE);
        imageView.setFitHeight(SQUARESIZE);
        imageView.setSmooth(true);
        return imageView;
    }

    /**
     * Create and set up a button
     *
     * @param image
     * @return
     */
    private Button createSmileyButton(Image image) {
        Button button = new Button();
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(25);
        imageView.setFitHeight(25);
        button.setGraphic(imageView);

        button.setOnMouseClicked((MouseEvent event)
                -> {
                    if (event.getButton() == MouseButton.PRIMARY) {
                        executor.execute(()
                                -> {
                            model.resetBoard();
                            modelTimer.restart();
                        });
                    }
                });
        return button;
    }

}
