/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramos.core;

import ramos.clases.Temporizador;

/**
 *
 * @author Ricardo
 */
public class Buscaminas {

    private boolean[][] tablero_minas;
    private int[][] minas_alrededor;
    private boolean[][] destapadas;
    private boolean[][] banderas;
    private boolean[][] preguntas;
    private boolean[][] banderamarcada;
    private boolean preguntamarcada;
    private boolean[][] interrogacion;

    private int vidas;
    private int totalMinas;
    private int ancho;
    private int alto;
    private boolean soportaBanderas;
    private boolean soportaInterrogacion;
    private boolean gameOver;
    private boolean ganador;
    private int vidasRestantes;
    private int casillasTapadasRestantes;
    private int minasSinBanderaRestantes;

    /**
     * Constructor principal. Crea una instancia de un tablero de juego.
     *
     * @param x Ancho del tablero (Nmero de columnas).
     * @param y Alto del tablero (Nmero de filas).
     * @param minas Nmero de minas
     * @param vidas Nmero de errores permitidos.
     * @throws DemasiadasMinasException Esta excepcin debe ser capturada para
     * saber si ha sido posible construir el tablero dado su tama o y n mero de
     * minas. No se puede crear un tablero con m s minas que casillas
     * disponibles. En caso de intentar crearlo, el objeto no se crear , y
     * lanzar esta excepci n.
     * @throws NumeroDeVidasFueraDeRangoException Esta excepci n se lanza cuando
     * trates de crear un nuevo juego con un n mero de vidas superior o inferior
     * al n mero de minas.
     */
    public Buscaminas(int x, int y, int minas, int vidas)
            throws DemasiadasMinasException, NumeroDeVidasFueraDeRangoException {

        if (minas > x * y) {
            throw new DemasiadasMinasException();
        }
        if (vidas > minas || vidas < 1) {
            throw new NumeroDeVidasFueraDeRangoException();
        }

        tablero_minas = new boolean[y][x];
        minas_alrededor = new int[y][x];
        destapadas = new boolean[y][x];
        banderas = new boolean[y][x];
        interrogacion = new boolean[x][y];
        banderamarcada = new boolean[x][y];
        preguntamarcada = false;

        this.vidas = vidas;
        vidasRestantes = vidas;
        totalMinas = minas;
        ancho = x;
        alto = y;

        casillasTapadasRestantes = ancho * alto - totalMinas;
        minasSinBanderaRestantes = minas;

        soportaInterrogacion = false;
        soportaBanderas = false;
        gameOver = false;
        ganador = false;

        /*
		 * Ponemos minas alrededor.
         */
        ponerMinas(minas);

        /*
		 * Generamos la matriz de pistas.
         */
        minasAlrededor();

    }

    /**
     * Este constructor crea un juego de Buscaminas sin necesidad de especificar
     * el n mero de vidas. El n mero de vidas ser el mismo n mero que el de
     * minas. Por tanto, el usuario tendr tantas oportunidades como minas halla.
     *
     * @param x N mero de columnas del tablero.
     * @param y N mero de filas del tablero.
     * @param minas N mero de minas que tendr el tablero.
     * @throws DemasiadasMinasException
     * @throws NumeroDeVidasFueraDeRangoException
     */
    public Buscaminas(int x, int y, int minas) throws DemasiadasMinasException, NumeroDeVidasFueraDeRangoException {
        this(x, y, minas, minas);
    }

    public void marcarBandera(int x, int y) {

        // Si se ha configurado para que el juego soporte banderas, se ejecutar 
        // el m todo. De lo contrario, no debe hacer nada.
        if (soportaBanderas && !gameOver) {
            banderas[y][x] = !banderas[y][x];

            // Al poner una bandera, calculo si es correcta o no para saber si
            // el juego ha terminado.
            if (hayMina(x, y) && tieneBandera(x, y)) {
                minasSinBanderaRestantes--;
            } else if (hayMina(x, y) && !tieneBandera(x, y)) {
                minasSinBanderaRestantes++;
            } else if (!hayMina(x, y) && tieneBandera(x, y)) {
                minasSinBanderaRestantes++;
            } else if (!hayMina(x, y) && !tieneBandera(x, y)) {
                minasSinBanderaRestantes--;
            }

            if (minasSinBanderaRestantes == 0 && casillasTapadasRestantes == 0) {
                gameOver = true;
                ganador = true;
            }

        }
    }

    public void marcarInterrogacion(int x, int y) {

        // Si se ha configurado para que el juego soporte interrogaciones, se ejecutar 
        // el m todo. De lo contrario, no debe hacer nada.
        if (soportaInterrogacion && !gameOver) {
            interrogacion[y][x] = true;

        }
    }

    public void marcarBanderaPorInterrogacion(int x, int y) {

        banderamarcada[x][y] = true;
    }

    public boolean getMarcarBanderaPorInterrogacion(int x, int y) {

        return banderamarcada[x][y];
    }

    /**
     * Te dice si la casilla especificada tiene o no una bandera puesta.
     * Recuerda que si una casilla tiene bandera, el m todo cavar() no tendr
     * efecto.
     *
     * @param x Columna
     * @param y Fila
     * @return true = tiene bandera, false = no tiene bandera.
     */
    public boolean tieneBandera(int x, int y) {
        return banderas[y][x];
    }

    public boolean tienePregunta(int x, int y) {

        return interrogacion[y][x];
    }

    public void setInterrogacion(boolean[][] interrogacion) {
        this.preguntas = interrogacion;
    }

    /**
     * Nos dice el tama o actual del tablero. Concretamente, el ancho, width,
     * "x" o columnas.
     *
     * @return
     */
    public int ancho() {
        return ancho;
    }

    /**
     * Nos dice el tama o actual del tablero. Concretamente, el alto, height,
     * "y" o filas.
     *
     * @return
     */
    public int alto() {
        return alto;
    }

    /**
     * Da informaci n sobre el estado actual del juego.
     *
     * @return false si el juego prosigue. true si el juego ha terminado.
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * Cava en la casilla seleccionada.
     *
     * Si la casilla tiene una mina, el n mero de vidas decrementa.
     *
     * Si se han perdido todas las vidas, el juego termina. Consultar
     * isGameOver()
     *
     * Si la casilla est despejada, se despeja junto a las adyacentes.
     *
     * @param x Columna
     * @param y Fila
     */
    public void cavar(int x, int y) {
        
        // Si el juego ha terminado, o si la casilla est  protegida por una
        // bandera, no ejecutaremos ninguna acci n. Si la casilla tiene bandera
        // y el usuario quiere cavar en ella, tendr  que retirar la bandera
        // previamente.
        
        if (gameOver || tieneBandera(x, y)) {
            return;
        }

        // Si hay mina
        if (hayMina(x, y)) {

            if (soportaBanderas) {
                minasSinBanderaRestantes--;
            }

            // Si quedan vidas
            if (vidasRestantes > 0) {
                vidasRestantes--;
            } else {
                // Acaba el juego
                gameOver = true;
                ganador = false;
                
            }
        }

        destapar(x, y);

        if (vidasRestantes == 0) {
            gameOver = true;
        }
    }
    
    public void cavar2(int x, int y) {
        // Si el juego ha terminado, o si la casilla est  protegida por una
        // bandera, no ejecutaremos ninguna acci n. Si la casilla tiene bandera
        // y el usuario quiere cavar en ella, tendr  que retirar la bandera
        // previamente.
        
        destapar(x, y);

    }

    /**
     * Este m todo es privado, porque ni el usuario ni la interfaz tienen por qu
     * conocerlo ni utilizarlo. Sirve de forma interna para situar las minas al
     * azar por el tablero una vez que se ha creado.
     *
     * @param minas
     */
    private void ponerMinas(int minas) {
        int x, y, totalMinas;
        totalMinas = minas;
        while (totalMinas > 0) {
            x = (int) (Math.random() * ancho);
            y = (int) (Math.random() * alto);
            if (!tablero_minas[y][x]) {
                tablero_minas[y][x] = true;
                totalMinas--;
            }
        }
    }

    /**
     * Este m todo es privado. Sirve para destapar una casilla y sus adyacentes
     * de modo recursivo. El usuario o jugador debe destapar las casillas
     * utilizando el m todo cavar()
     *
     * @param x Columna
     * @param y Fila
     */
    public void destapar(int x, int y) {

        // En este punto, a parte de destapar la casilla, decidimos si el juego
        // ha finalizado.
        // El juego finaliza si el jugador ha destapado todas las casillas en
        // las que NO hay minas sin haber consumido el n mero de intentos
        // fallidos.
        // En caso de haber habilitado la funci n de banderas, se tendr  en
        // cuenta que adem s hayan banderas en todas las casillas tapadas que
        // tengan mina para que finalice el juego.
        if (!destapadas[y][x] && !banderas[y][x]) {
            destapadas[y][x] = true;

            if (!hayMina(x, y)) {
                casillasTapadasRestantes--;
            }

            if (soportaBanderas) {
                if (casillasTapadasRestantes == 0 && minasSinBanderaRestantes == 0) {
                    gameOver = true;
                }
            } else {
                if (casillasTapadasRestantes == 0) {
                    gameOver = true;
                }
            }

            if (gameOver && vidasRestantes > 0) {
                ganador = true;
            }

            if (!hayMinasAlrededor(x, y)) {

                // Compruebo los lados
                // Compruebo arriba y abajo
                if (y > 0 && !estaDestapada(x, y - 1)) {
                    destapar(x, y - 1);
                }
                if (y < alto() && !estaDestapada(x, y + 1)) {
                    destapar(x, y + 1);
                }

                // Compruebo a la derecha e izquierda
                if (x > 0 && !estaDestapada(x - 1, y)) {
                    destapar(x - 1, y);
                }
                if (x < ancho() && !estaDestapada(x + 1, y)) {
                    destapar(x + 1, y);
                }

                // Compruebo en las diagonales
                // Diagonal superior izquierda
                if (x > 0 && y > 0 && !estaDestapada(x - 1, y - 1)) {
                    destapar(x - 1, y - 1);
                }

                // Diagonal superior derecha
                if (x < ancho() && y > 0 && !estaDestapada(x + 1, y - 1)) {
                    destapar(x + 1, y - 1);
                }

                // Diagonal inferior izquierda
                if (x > 0 && y < alto() && !estaDestapada(x - 1, y + 1)) {
                    destapar(x - 1, y + 1);
                }

                // Diagonal inferior derecha
                if (x < ancho() && y < alto() && !estaDestapada(x + 1, y + 1)) {
                    destapar(x + 1, y + 1);
                }
            }

        }

    }

    public void destaparTodas(int x, int y) {
        
        if (!destapadas[y][x] && !banderas[y][x]) {
            destapadas[y][x] = true;
        }
       for (int i = 0; i < alto(); i++) {
            for (int j = 0; j < ancho(); j++) {
                 if (hayMinasAlrededor(x, y)||hayMinasAlrededor(x, y)) {

            // Compruebo los lados
            // Compruebo arriba y abajo
            if (y > 0 && !estaDestapada(x, y - 1)) {
                destapar(x, y - 1);
                destaparTodas(x, y);
            }
            if (y < alto() && !estaDestapada(x, y + 1)) {
                destapar(x, y + 1);
                destaparTodas(x, y);
            }

            // Compruebo a la derecha e izquierda
            if (x > 0 && !estaDestapada(x - 1, y)) {
                destapar(x - 1, y);
                destaparTodas(x, y);
            }
            if (x < ancho() && !estaDestapada(x + 1, y)) {
                destapar(x + 1, y);
                destaparTodas(x, y);
            }

            // Compruebo en las diagonales
            // Diagonal superior izquierda
            if (x > 0 && y > 0 && !estaDestapada(x - 1, y - 1)) {
                destapar(x - 1, y - 1);
                destaparTodas(x, y);
            }

            // Diagonal superior derecha
            if (x < ancho() && y > 0 && !estaDestapada(x + 1, y - 1)) {
                destapar(x + 1, y - 1);
                destaparTodas(x, y);
            }

            // Diagonal inferior izquierda
            if (x > 0 && y < alto() && !estaDestapada(x - 1, y + 1)) {
                destapar(x - 1, y + 1);
               destaparTodas(x, y);
            }

            // Diagonal inferior derecha
            if (x < ancho() && y < alto() && !estaDestapada(x + 1, y + 1)) {
                destapar(x + 1, y + 1);
                destaparTodas(x, y);
            }
        }
            }

        }
       
        }
    

    /**
     * Este m todo es privado y para uso interno del n cleo del juego.
     *
     * B sicamente, este m todo crea una matriz que representa el mapa de minas
     * detectadas alrededor de cada casilla.
     *
     * Este m todo se ejecuta al inicializar una instancia del juego, y nos
     * ahorramos tener que volver a calcularlo cada vez que el jugador haga clic
     * en una casilla.
     */
    private void minasAlrededor() {
        int[] lasI = {-1, -1, 0, 1, 0, 1, 1, -1, 0};
        int[] lasJ = {-1, 0, -1, 1, 1, 0, -1, 1, 0};

        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                for (int k = 0; k < 9; k++) {
                    // Este try-catch evita que cuente las minas alrededor en
                    // aquellas casillas fuera del rango.
                    try {
                        if (tablero_minas[i + lasI[k]][j + lasJ[k]]) {
                            minas_alrededor[i][j]++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        // Si da error, no necesito hacer nada, simplemente que
                        // contin e el bucle.
                    }
                }
            }
        }
    }

    /**
     * Este m todo nos dice si una casilla determinada tiene alguna minas
     * alrededor en sus casillas adyacentes.
     *
     * @param x La casilla X (horizontal, columna).
     * @param y La casilla Y (vertical, fila).
     * @return true si hay al menos una mina, false si est despejado.
     */
    public boolean hayMinasAlrededor(int x, int y) {
        return minas_alrededor[y][x] > 0;
    }

    /**
     * Este m todo nos dice CU NTAS minas hay alrededor de una casilla (sin
     * importar si la misma casilla es una mina). Ten en cuenta que si la misma
     * casilla x,y tiene una mina, el resultado va a ser siempre al menos 1. Si
     * el resultado es 0, ser evidente que ni tiene minas alrededor, ni la
     * propia casilla es una mina.
     *
     * @param x La casilla X (horizontal, columna).
     * @param y La casilla Y (vertical, fila).
     * @return El n mero de minas alrededor.
     */
    public int contarMinasAlrededor(int x, int y) {
        return minas_alrededor[y][x];
    }

    /**
     * Nos dice si la casilla ya ha sido destapada. Si est destapada habr que
     * mostrar el n mero de minas alrededor.
     *
     * @param x La casilla X (horizontal, columna).
     * @param y La casilla Y (vertical, fila).
     * @return true si est destapada, false si a n no se ha destapado.
     */
    public boolean estaDestapada(int x, int y) {
        if (x < 0 || x >= destapadas[0].length) {
            return true;
        }
        if (y < 0 || y >= destapadas.length) {
            return true;
        }
        return destapadas[y][x];
    }

    /**
     * Nos dice si la casilla dada tiene o no una mina.
     *
     * @param x La casilla X (horizontal, columna).
     * @param y La casilla Y (vertical, fila).
     * @return true si hay una mina, false si la casilla est libre de mina.
     */
    public boolean hayMina(int x, int y) {
        if (x < 0 || x >= tablero_minas[0].length) {
            return true;
        }
        if (y < 0 || y >= tablero_minas.length) {
            return true;
        }
        return tablero_minas[y][x];
    }

    /**
     * Devuelve una matriz que representa el mapa de minas. Las celdas con valor
     * 1 tienen mina, y las que tienen valor 0 est n vac as.
     *
     * @return
     */
    public boolean[][] mapaDeMinas() {
        return tablero_minas;
    }

    public int[][] mapaMinasAlrededor() {
        return minas_alrededor;
    }

    /**
     * Resetea el juego actual sin cambiar la posici n de las minas ni el tama o
     * del tablero. Es decir, como volver a empezar la misma partida.
     */
    public void reset() {
        vidasRestantes = vidas;

        gameOver = false;
        ganador = false;

        destapadas = new boolean[alto][ancho];
        banderas = new boolean[alto][ancho];

        casillasTapadasRestantes = ancho * alto - totalMinas;
        minasSinBanderaRestantes = totalMinas;

    }

    /**
     * Devuelve el n mero de vidas con el cual se ha configurado la partida.
     *
     * @return
     */
    public int getTotalVidas() {
        return vidas;
    }

    /**
     * Devuelve el n mero de vidas restante seg n el estado actual del juego.
     *
     * @return
     */
    public int getVidasRestantes() {
        return vidasRestantes;
    }

    public boolean isGanador() {
        return ganador;
    }

    public boolean hayBanderas() {
        return soportaBanderas;
    }

    public void soportaBanderas(boolean hayBanderas) {
        this.soportaBanderas = hayBanderas;
    }

    public void soportaInterrogacion(boolean hayInterrogacion) {
        this.soportaInterrogacion = hayInterrogacion;
    }

    public boolean getSoportaInterrogacion() {
        return this.soportaInterrogacion;
    }

    public boolean[][] getBanderamarcada() {
        return banderamarcada;
    }

    public boolean isPreguntamarcada() {
        return preguntamarcada;
    }

    public void setPreguntamarcada(boolean preguntamarcada) {
        this.preguntamarcada = preguntamarcada;
    }

}
