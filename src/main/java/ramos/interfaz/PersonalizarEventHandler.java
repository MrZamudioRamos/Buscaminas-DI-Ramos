/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramos.interfaz;

import java.util.concurrent.ExecutorService;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import ramos.clases.Tablero;

/**
 *
 * @author Ricardo
 */
public class PersonalizarEventHandler implements EventHandler {

    private final Tablero model;
    private final int i;
    private final int j;
    private final ExecutorService executor;

    public PersonalizarEventHandler(Tablero model, int i, int j, ExecutorService executor) {
        this.model = model;
        this.i = i;
        this.j = j;
        this.executor = executor;
    }

    public void handle(MouseEvent event) {
        if (model.juegoFinalizado()) {
            System.out.println("Game Finished ! ");
            return;
        }
        if (event.getButton() == MouseButton.SECONDARY) {
            executor.execute(() -> {
                model.clickDerecho(i, j);
            });
        } else if (event.getButton() == MouseButton.PRIMARY) {
            executor.execute(() -> {
                model.clickIzquierdo(i, j);
            });
        }
    }

    @Override
    public void handle(Event event) {
        if (event instanceof MouseEvent) {
            this.handle((MouseEvent) event);
        } else {
            System.err.println("Eventos excepto eventos de ratón no gestionados");
        }
    }

}
