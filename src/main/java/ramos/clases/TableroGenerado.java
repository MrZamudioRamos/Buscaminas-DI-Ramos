/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramos.clases;

/**
 *
 * @author Ricardo
 */
public class TableroGenerado extends Tablero{

    public TableroGenerado(int row, int col, int bomb) {
        super(row, col, bomb);
    }

    @Override
    public void setUpVecinos() {
        for (int row = 0; row < this.getTablero().size(); row++) {
            for (int col = 0; col < this.getTablero().get(row).size(); col++) {
                if (row < this.getTablero().size() - 1) {
                    tablero.get(row).get(col).addVecino(tablero.get(row + 1).get(col));
                    if (col < this.getTablero().get(row).size() - 1) {
                        tablero.get(row).get(col).addVecino(tablero.get(row + 1).get(col + 1));
                    }
                    if (col > 0) {
                        tablero.get(row).get(col).addVecino(tablero.get(row + 1).get(col - 1));
                    }
                }
                if (row > 0) {
                    tablero.get(row).get(col).addVecino(tablero.get(row - 1).get(col));
                    if (col < this.getTablero().get(row).size() - 1) {
                        tablero.get(row).get(col).addVecino(tablero.get(row - 1).get(col + 1));
                    }
                    if (col > 0) {
                        tablero.get(row).get(col).addVecino(tablero.get(row - 1).get(col - 1));
                    }
                }
                if (col < this.getTablero().get(row).size() - 1) {
                    tablero.get(row).get(col).addVecino(tablero.get(row).get(col + 1));
                }
                if (col > 0) {
                    tablero.get(row).get(col).addVecino(tablero.get(row).get(col - 1));
                }
            }
        }
    }
    
}
