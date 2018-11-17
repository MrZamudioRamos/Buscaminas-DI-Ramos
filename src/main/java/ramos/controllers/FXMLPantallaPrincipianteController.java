/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramos.controllers;

import static java.lang.Double.MAX_VALUE;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import ramos.clases.Juego;
import ramos.clases.Temporizador;
import ramos.core.Buscaminas;
import ramos.core.Casilla;
import ramos.core.DemasiadasMinasException;
import ramos.core.NumeroDeVidasFueraDeRangoException;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class FXMLPantallaPrincipianteController implements Initializable {

    Juego game = new Juego();

    @FXML
    public Label fxLabelNumeroMinasPrincipiante;

    @FXML
    protected GridPane fxGridPaneMinasPrincipiante;

    private FXMLPantallaPrincipalController principal;
    private FXMLPantallaElegirController elegir;

    @FXML
    protected Text fxText;

    Temporizador temp = new Temporizador();

    public Label getFxLabelNumeroMinasPrincipiante() {
        return fxLabelNumeroMinasPrincipiante;
    }

    public void setFxLabelNumeroMinasPrincipiante(Label fxLabelNumeroMinasPrincipiante) {
        this.fxLabelNumeroMinasPrincipiante = fxLabelNumeroMinasPrincipiante;
    }

    public FXMLPantallaPrincipalController getPrincipal() {
        return principal;
    }

    public void setPrincipal(FXMLPantallaPrincipalController principal) {
        this.principal = principal;
    }

    public void clickSalirPrincipiante() {
        principal.cargarPantallaElegir();
    }

    private Node[][] casillas;

    private Buscaminas juego;

    private int ancho = 8;
    private int alto = 8;
    private int vidas = 1;
    private int minas;

    public Node[][] getCasillas() {
        return casillas;
    }

    public void setCasillas(Node[][] casillas) {
        this.casillas = casillas;
    }

    public Buscaminas getJuego() {
        return juego;
    }

    public void setJuego(Buscaminas juego) {
        this.juego = juego;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getMinas() {
        return minas;
    }

    public void setMinas(int dificultad) {
        switch (dificultad) {
            case 12:
                minas = 12;
                break;
            case 16:
                minas = 16;
                break;
            case 21:
                minas = 21;
                break;
            default:
                minas = 17;
                break;
        }
    }

    public void start() {
        temp.setSeconds(0);
        temp.time(fxText);
        temp.start();
    }

    public void clickReiniciarPrincipiante() {
        juego.reset();
        Tablero();
        temp.setSeconds(0);
        start();
    }

    /**
     * Initializes the controller class.
     *
     * @return
     */
    public void Tablero() {
        switch (minas) {
            case 12:
                try {
                    juegoNuevoFacil(ancho, alto, minas, vidas);
                } catch (NumeroDeVidasFueraDeRangoException ex) {
                    Logger.getLogger(FXMLPantallaIntermedioController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 16:
                try {
                    juegoNuevoMedio(ancho, alto, minas, vidas);
                } catch (NumeroDeVidasFueraDeRangoException ex) {
                    Logger.getLogger(FXMLPantallaIntermedioController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 21:
                try {
                    juegoNuevoDificil(ancho, alto, minas, vidas);
                } catch (NumeroDeVidasFueraDeRangoException ex) {
                    Logger.getLogger(FXMLPantallaIntermedioController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                try {
                    juegoNuevo(ancho, alto, minas, vidas);
                } catch (NumeroDeVidasFueraDeRangoException ex) {
                    Logger.getLogger(FXMLPantallaIntermedioController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
        }
    }

    public void juegoNuevo(int ancho, int alto, int minas, int vidas) throws NumeroDeVidasFueraDeRangoException {
        try {
            juego = new Buscaminas(ancho, alto, minas, vidas);
            juego.soportaBanderas(true);
            juego.soportaInterrogacion(true);
        } catch (DemasiadasMinasException e) {
            System.out.println("Has puesto demasiadas minas");
        }

        construirTablero();
    }

    public void juegoNuevoFacil(int ancho, int alto, int minas, int vidas) throws NumeroDeVidasFueraDeRangoException {
        try {
            juego = new Buscaminas(ancho, alto, minas, vidas);
            juego.soportaBanderas(true);
            juego.soportaInterrogacion(true);
        } catch (DemasiadasMinasException e) {
            System.out.println("Has puesto demasiadas minas");
        }

        construirTablero();
    }

    public void juegoNuevoMedio(int ancho, int alto, int minas, int vidas) throws NumeroDeVidasFueraDeRangoException {
        try {
            juego = new Buscaminas(ancho, alto, minas, vidas);
            juego.soportaBanderas(true);
            juego.soportaInterrogacion(true);
        } catch (DemasiadasMinasException e) {
            System.out.println("Has puesto demasiadas minas");
        }

        construirTablero();
    }

    public void juegoNuevoDificil(int ancho, int alto, int minas, int vidas) throws NumeroDeVidasFueraDeRangoException {
        try {
            juego = new Buscaminas(ancho, alto, minas, vidas);
            juego.soportaBanderas(true);
            juego.soportaInterrogacion(true);
        } catch (DemasiadasMinasException e) {
            System.out.println("Has puesto demasiadas minas");
        }

        construirTablero();
    }

    public void construirTablero() {
        /*
		 * Primero limpiamos todo lo que hay dentro del GridPane y del array
		 * casillas
         */
        casillas = new Node[juego.alto()][juego.ancho()];
        fxGridPaneMinasPrincipiante.getChildren().clear();

        /*
		 * Generamos las casillas en función de la configuración que haya en el
		 * objeto "juego" (de tipo Buscaminas).
         */
        for (int y = 0; y < juego.alto(); y++) {
            fxGridPaneMinasPrincipiante.getColumnConstraints().add(new ColumnConstraints());
            fxGridPaneMinasPrincipiante.getRowConstraints().add(new RowConstraints());

            for (int x = 0; x < juego.ancho(); x++) {
                // Creo una casilla personalizada con las coordenadas
                Casilla casilla = new Casilla(x, y, " ");
                casilla.setMaxSize(MAX_VALUE, MAX_VALUE);
                // Le doy una acción, de tipo ratón.
                casilla.setOnMouseClicked(p -> {
                    // Si el jugador pulsa el botón izquierdo del ratón,
                    // cavo
                    // la casilla, pero si pulsa el derecho, pongo una
                    // bandera.
                    // CAVO
                    if (p.getButton() == MouseButton.PRIMARY) {
                        juego.cavar(casilla.getX(), casilla.getY());
                    } // BANDERA
                    else if (p.getButton() == MouseButton.SECONDARY) {
                        juego.marcarBandera(casilla.getX(), casilla.getY());
                        juego.setPreguntamarcada(true);
                    } else if (p.getButton() == MouseButton.SECONDARY && juego.isPreguntamarcada()) {
                        juego.marcarInterrogacion(casilla.getX(), casilla.getY());
                    }
                    actualizarTablero();
                });

                fxGridPaneMinasPrincipiante.add(casilla, x, y);

                /*
				 * Cada casilla que creo, la meto en un array de tipo Nodo que
				 * contiene los elementos a los que deseo no perder referencia.
				 * De esta forma, tengo en una matriz del tamaño del tablero las
				 * referencias a los objetos Casilla cuando necesite recorrerlas
				 * en base a su posición (coordenadas x y).
                 */
                //casilla.setMinSize(15, 15);
                casillas[y][x] = casilla;
            }
        }

//        if (juego.getTotalVidas() > 1) {
//            vidasRestantes.setText("Vidas restantes: " + Integer.toString(juego.getVidasRestantes()));
//        }
    }
    Image imgBandera = new Image("/images/bandera.png");
    Image imagenMina = new Image("/images/mina.png");
    Image imagenPregunta = new Image("/images/pregunta.png");

    public void actualizarTablero() {
        /*
		 * Este método debe actualizar el estado de cada casilla en el tablero.
		 * Se le debe llamar cada vez que se realice alguna opción.
         */
//        if (juego.getTotalVidas() > 1) {
//            vidasRestantes.setText("Vidas restantes: " + Integer.toString(juego.getVidasRestantes()));
//        }

        for (int y = 0; y < juego.alto(); y++) {
            for (int x = 0; x < juego.ancho(); x++) {
                Button cuadro = (Button) casillas[y][x];

                // Si está destapada
                if (juego.estaDestapada(x, y)) {
                    cuadro.setDisable(true);
                    // Si hay mina
                    if (juego.hayMina(x, y)) {
                        cuadro.getStyleClass().add("casillaMina");
                        ImageView imagenMina = new ImageView(this.imagenMina);
                        imagenMina.setFitWidth(25);
                        imagenMina.setFitHeight(25);

                        cuadro.setGraphic(imagenMina);
                    } else {
                        // Si tiene minas alrededor, le ponemos el número.
                        if (juego.hayMinasAlrededor(x, y)) {
                            if (juego.contarMinasAlrededor(x, y) > 0) {
                                cuadro.setText(Integer.toString(juego.contarMinasAlrededor(x, y)));
                            }
                        }
                    }
                } else {
                    if (juego.tieneBandera(x, y)) {
                        // cuadro.getStyleClass().add("casillaBandera");
                        ImageView imgBandera2 = new ImageView(imgBandera);
                        imgBandera2.setFitWidth(15);
                        imgBandera2.setFitHeight(15);

                        cuadro.setGraphic(imgBandera2);

                        juego.marcarBanderaPorInterrogacion(x, y);
                    } else if (juego.isPreguntamarcada() && juego.getMarcarBanderaPorInterrogacion(x, y)) {
                        ImageView imgBandera2 = new ImageView(imagenPregunta);
                        imgBandera2.setFitWidth(15);
                        imgBandera2.setFitHeight(15);

                        cuadro.setGraphic(imgBandera2);
                        juego.setPreguntamarcada(true);
                    }else{
                        cuadro.setGraphic(null);
                    }
                }

            }
        }
        if (juego.isGameOver()) {
            if (juego.isGanador()) {
                alerta("¡Has ganado!");
            } else {
                alerta(Alert.AlertType.WARNING, "Has perdido");
            }
        }

    }

    public void alerta(Alert.AlertType tipo, String mensaje) {
        Alert temp = new Alert(tipo);
        temp.setTitle("Nota informativa");
        temp.setHeaderText("Buscaminas");
        temp.setContentText(mensaje);
        temp.showAndWait();
    }

    public void alerta(String mensaje) {
        alerta(Alert.AlertType.INFORMATION, mensaje);
    }

    /*
	 * Si la partida termina porque el jugador ha perdido, este método mostrará
	 * dónde estaban las minas y las banderas erróneas.
     */
    public void gameOverMostrarSolucion() {
        for (int i = 0; i < juego.alto(); i++) {
            for (int j = 0; j < juego.ancho(); j++) {
                if (juego.tieneBandera(j, i)) {

                    if (!juego.hayMina(j, i)) {
                        // Mal
                    }
                } else if (juego.hayMina(j, i)) {
                    // Mal
                }
            }
        }
    }

    public void Game() {
//        game.DetectarMinas(rows, col);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Tablero();
        //Game();
    }

}
