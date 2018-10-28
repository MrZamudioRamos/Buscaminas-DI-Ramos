/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramos.clases;

import java.util.LinkedList;

/**
 *
 * @author Ricardo
 */
public class Caso {
    private boolean bandera;
    private boolean trampa;
    private boolean visible;
    private LinkedList<Caso> vecinos;
    private int nbMina; //Number of bonbs neighbour to current case
    private EstadoDiferente estado;

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        if (this.bandera = bandera) {
            this.setEstado(EstadoDiferente.BANDERA);
        } else {
            this.setEstado();
        }
    }

    public boolean isTrampa() {
        return trampa;
    }

    public void setTrampa(boolean trampa) {
        this.trampa = trampa;
        this.setEstado(EstadoDiferente.ATRAPADO);
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
        this.setEstado();
    }

    public LinkedList getVecinos() {
        return vecinos;
    }

    public void setVecinos(LinkedList vecinos) {
        this.vecinos = vecinos;
    }

    public void addVecino(Caso c) {
        vecinos.add(c);
    }

    public int getNbMina() {
        return nbMina;
    }

    public Caso() {
        this.setBandera(false);
        this.setTrampa(false);
        this.vecinos = new LinkedList<Caso>();
        this.setVisible(false);
        this.setEstado();
    }

    public void reset() {
        this.setBandera(false);
        this.setTrampa(false);
        this.vecinos = new LinkedList<>();
        this.setVisible(false);
        this.setEstado();
    }

    public void setBandera() {
        this.setEstado((this.bandera = !this.bandera) ? EstadoDiferente.BANDERA : EstadoDiferente.NODESCUBIERTO);

    }

    /**
     * @return the estado
     */
    public EstadoDiferente getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(EstadoDiferente estado) {
        this.estado = estado;
    }

    public void setEstado() {
        if (this.estado == EstadoDiferente.ACTIVADO) {
            return;
        }

        if (!isVisible()) {
            setEstado(EstadoDiferente.NODESCUBIERTO);
        } else if (bandera) {
            setEstado(EstadoDiferente.BANDERA);
        } else if (isTrampa() && isVisible()) {
            setEstado(EstadoDiferente.ATRAPADO);
        } else if (isVisible() && nbMina == 0) {
            setEstado(EstadoDiferente.VACÍO);
        } else {
            setEstado(EstadoDiferente.DESCUBIERTO);
        }
    }

    public void descubrirVecinos() {
        if (!isTrampa()) {
            for (Caso c : this.vecinos) {
                if (!c.isVisible() && !c.bandera) {
                    c.descubrir();
                    if (c.nbMina == 0) {
                        c.descubrirVecinos();
                    }
                }
            }
        }
    }

    public void descubrir() {
        if (!isVisible()) {
            this.setVisible(true);
            nbMina = calcularNbMina();
        }
        this.setEstado();
    }

    public int calcularNbMina() {
        nbMina = 0;
        for (Caso c : this.vecinos) {
            if (c.isTrampa()) {
                nbMina++;
            }
        }
        return nbMina;
    }

    @Override
    public String toString() {
        String r = "";
        r += this.getEstado();
        return r;
    }
}
