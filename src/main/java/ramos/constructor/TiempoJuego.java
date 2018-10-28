/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramos.constructor;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Ricardo
 */
public class TiempoJuego extends Observable{
      private Timer t;
    private int valor; //Valor of counter

    /**
     *
     * @return the valor of counter in string
     */
    public String getValor() {
        return Integer.toString(valor);
    }

    /**
     *
     * @return the valor of counter in integer
     */
    public int getValorInt() {
        return valor;
    }

    public TiempoJuego() {
        this.valor = 300;
        t = new Timer();
    }

    /**
     * Method to empezar the counter
     */
    public void empezar() {
        this.valor = 300;
        this.t.schedule(new TimerTask() {
            @Override
            public void run() {
                valor--;
                // notify the view
                setChanged();
                notifyObservers();
                if (valor == 0) // if counter arrives zero
                {
                    parar();
                }
            }
        }, 0, 1000);
    }

    /*
     * Method to parar the counter
     */
    public void parar() {
        this.t.cancel();
        this.t.purge();
    }

    /**
     * REempezar the counter
     */
    public void reempezar() {
        parar();
        t = new Timer();
        empezar();
    }
    
    /**
     * Return true if the timer reached 0, false else
     * @return 
     */
    public boolean isFinalizado() {
        return (this.getValorInt() <= 0);
    }

}
