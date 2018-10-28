/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramos.clases;

import ramos.constructor.TiempoJuego;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Observable;

/**
 *
 * @author Ricardo
 */
public abstract class Tablero extends Observable{
    protected List<List<Caso>> tablero;
    protected int nbMina; //Number of bomb
    protected int nbFlag;
    private TiempoJuego timer;
    private int score;

    /**
     * Represents the estado of the game
     */
    protected EstadoJuego estado;

    public EstadoJuego getEstado() {
        return estado;
    }

    public List<List<Caso>> getTablero() {
        return tablero;
    }

    public int getNbFlag() {
        return nbFlag;
    }

    public TiempoJuego getTimer() {
        return timer;
    }

    public int getScore() {
        return score;
    }

    /**
     * Constructor
     *
     * @param row Number of rows in the playing grid
     * @param col Number of columns in the playing grid
     * @param bomb Number of bomb to be generated on the grid
     */
    public Tablero(int row, int col, int bomb) {
        this.nbMina = bomb;
        this.nbFlag = 0;
        this.estado = EstadoJuego.EJECUTANDO;
        this.tablero = createTablero(row, col);
        this.timer = new TiempoJuego();

        generarMina(tablero);
        setUpVecinos();
    }

    /**
     * Create the tablero
     *
     * @param row
     * @param col
     * @return
     */
    protected List<List<Caso>> createTablero(int row, int col) {
        List<List<Caso>> grid = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            grid.add(new ArrayList<>());
            for (int j = 0; j < col; j++) {
                grid.get(i).add(new Caso());
            }
        }
        return grid;
    }

    /**
     * Reset the tablero to the initial estado (empty, ready to play)
     */
    public void resetTablero() {
        for (List<Caso> list : tablero) {
            for (Caso c : list) {
                c.reset();
            }
        }
        this.nbFlag = 0;
        this.estado = EstadoJuego.EJECUTANDO;
        generarMina(tablero);
        setUpVecinos();
        this.update();
    }

    /**
     * Methode to redine the tablero properties when changing the difficulty level
     *
     * @param row New number of row
     * @param col New number of column
     * @param nbomb New nulber of bomb
     */
    public void changeLevel(int row, int col, int nbomb) {
        this.nbMina = nbomb;
        this.nbFlag = 0;
        this.estado = EstadoJuego.EJECUTANDO;
        this.tablero = createTablero(row, col);
        generarMina(tablero);
        setUpVecinos();
    }

    /**
     * Set the neighbours for every cases
     */
    public abstract void setUpVecinos();

    /**
     * Set a flag on the grid according to the coordinates entered in the
     * arguments
     *
     * @param row the row id of the case clicked
     * @param col the col id of the case clicked
     */
    public void clickDerecho(int row, int col) {

        if (juegoFinalizado()) {
            return; // Do Nothing
        }
        Caso c = this.getCaso(row, col);

        switch (c.getEstado()) {
            case BANDERA:
                c.setBandera(false);
                this.nbFlag--;
                break;
            case NODESCUBIERTO:
                c.setBandera(true);
                this.nbFlag++;
                break;
            case ATRAPADO:
                c.setBandera(true);
                this.nbFlag++;
                break;
            default:
                return;
        }
        if (juegoGanado()) {
            this.estado = EstadoJuego.GANADO;
            this.gestionarVictoria();
        }
        this.update();
    }

    /**
     * Manage the left click on a case
     *
     * @param row : the row id of the case clicked
     * @param col : the col id of the case clicked
     */
    public void clickIzquierdo(int row, int col) {

        Caso c = this.getCaso(row, col);

        switch (c.getEstado()) {
            case DESCUBIERTO:
                return; // Do Nothing
            case VACÍO:
                return; // Do Nothing
            case ATRAPADO:
                this.estado = EstadoJuego.PERDIDO;
                c.setEstado(EstadoDiferente.ACTIVADO);
                this.gestionarDerrota();
                break;
            case NODESCUBIERTO:
                c.descubrir();
                if (!(c.calcularNbMina() > 0)) {
                    c.descubrirVecinos();
                }
                if (this.juegoGanado()) {
                    this.estado = EstadoJuego.GANADO;
                    gestionarVictoria();
                }
                break;
            default:
                break;
        }
        this.update();
    }

    /**
     * Game won if all bombs are flagged or if every case undescubrired remaining
     * are bombs
     *
     * @return true if the game is won, false if not yet
     */
    protected boolean juegoGanado() {
        int nbNoDescurbierto = this.nbAllNoDescurbierto();
        return (nbNoDescurbierto == this.nbMina
                || (nbMinaTieneBandera() == this.nbMina && this.nbFlag == this.nbMina)); // Maybe remove this
    }

    /**
     * Return the number of bombs flagged
     *
     * @return the number of bombs flagged
     */
    protected int nbMinaTieneBandera() {
        int nb = 0;
        for (int row = 0; row < this.getTablero().size(); row++) {
            for (int col = 0; col < this.getTablero().get(row).size(); col++) {
                Caso c = this.getCaso(row, col);
                if (c.isTrampa()&& c.isBandera()) {
                    nb++;
                }
            }
        }
        return nb;
    }

    /**
     * Test if the game is finished
     *
     * @return false if the game is still running, true else
     */
    public boolean juegoFinalizado() {

        return (!(this.estado == EstadoJuego.EJECUTANDO));
    }

    /**
     * Manage the defeat
     */
    protected void gestionarDerrota() {
        if (this.estado == EstadoJuego.PERDIDO) {
            descubrirAll();
        }
    }

    /**
     * Manage the victory
     */
    protected void gestionarVictoria() {
        this.score = this.getTimer().getValorInt();
        if (this.estado == EstadoJuego.GANADO) {
            this.descubrirAll();
        }
    }

    /**
     * Discover all the cases
     */
    protected void descubrirAll() {
        for (int row = 0; row < this.getTablero().size(); row++) {
            for (int col = 0; col < this.getTablero().get(row).size(); col++) {
                this.getCaso(row, col).descubrir();
            }
        }
    }

    /**
     * Return the number of cases not visible
     *
     * @return
     */
    protected int nbAllNoDescurbierto() {
        int counter = 0;
        for (int row = 0; row < this.getTablero().size(); row++) {
            for (int col = 0; col < this.getTablero().get(row).size(); col++) {
                if (!this.getCaso(row, col).isVisible()) {
                    counter++;
                }
            }
        }
        return counter;
    }

    /**
     * Method to generate randomly a list of bombs and put it on the grid
     *
     * @param tablero
     */
    protected void generarMina(List<List<Caso>> tablero) {
        Random r = new Random();
        int i_random, j_random;
        for (int i = 0; i < nbMina; i++) {
            do {
                i_random = r.nextInt(tablero.size());
                j_random = r.nextInt(tablero.get(i_random).size());
            } while (tablero.get(i_random).get(j_random).isTrampa());
            System.out.println(i_random + "   " + j_random);
            tablero.get(i_random).get(j_random).setTrampa(true);
        }
        System.out.println("");
    }

    /**
     * Get the case specified
     *
     * @param i
     * @param j
     * @return The case according to the coordinates
     */
    public Caso getCaso(int i, int j) {
        return this.tablero.get(i).get(j);
    }

    /**
     * Ask the view to update the GUI content
     */
    public void update() {
        // Notify the view to update
        setChanged();
        notifyObservers();
    }

    /**
     * Methode to return the total number of case
     *
     * @return
     */
    public int getNbCaso() {
        int cmpt = 0;
        for (int i = 0; i < this.tablero.size(); i++) {
            for (int j = 0; j < this.tablero.get(i).size(); j++) {
                cmpt++;
            }
        }
        return cmpt;
    }

    @Override
    public String toString() {
        String r = "";
        for (List<Caso> row : tablero) {
            r = row.stream().map((c) -> c + " ").reduce(r, String::concat);
            r += "\n";
        }
        return r;
    }

}
