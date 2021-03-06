package ramos.controllers;

import static java.lang.Double.MAX_VALUE;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import ramos.clases.Temporizador;
import ramos.core.Buscaminas;
import ramos.core.Casilla;
import ramos.core.DemasiadasMinasException;
import ramos.core.NumeroDeVidasFueraDeRangoException;
import ramos.core.Usuario;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class FXMLPantallaIntermedioController implements Initializable {

    Temporizador temp = new Temporizador();
    
    Usuario user = new Usuario();
            
    private FXMLPantallaPrincipalController principal;

    private FXMLPantallaElegirController elegir;

    private FXMLPantallaPersonalizarController personalizar;
    private int rows = 16, col = 16;

    @FXML
    protected GridPane fxGridPaneMinasIntermedio;

    @FXML
    protected Label fxLabelNumeroMinasIntermedio;

    @FXML
    protected Text fxText;
    
    @FXML
    protected Button fxReset;

    public Label getFxLabelNumeroMinasIntermedio() {
        return fxLabelNumeroMinasIntermedio;
    }

    public FXMLPantallaElegirController getElegir() {
        return elegir;
    }

    public void setElegir(FXMLPantallaElegirController elegir) {
        this.elegir = elegir;
    }

    public FXMLPantallaPersonalizarController getPersonalizar() {
        return personalizar;
    }

    public void setPersonalizar(FXMLPantallaPersonalizarController personalizar) {
        this.personalizar = personalizar;
    }

    public FXMLPantallaPrincipalController getPrincipal() {
        return principal;
    }

    public void setPrincipal(FXMLPantallaPrincipalController principal) {
        this.principal = principal;
    }

    public void setFxLabelNumeroMinasIntermedio(Label fxLabelNumeroMinasIntermedio) {
        this.fxLabelNumeroMinasIntermedio = fxLabelNumeroMinasIntermedio;
    }

    public void start() {
        temp.setSeconds(0);
        temp.time(fxText);
        temp.start();

    }

    public void clickReiniciarIntermedio() {
         juego.reset();
        Tablero();
        start();
        fxReset.setDisable(true);
        fxGridPaneMinasIntermedio.setDisable(false);
    }
    

    public void clickSalirIntermedio() {
        principal.cargarPantallaMenu();
    }

    private Node[][] casillas;

    private Buscaminas juego;

    private int ancho = 16;
    private int alto = 16;
    private int vidas = 1;
    private int minas;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Node[][] getCasillas() {
        return casillas;
    }

    public void setCasillas(Node[][] casillas) {
        this.casillas = casillas;
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

//    public int getMinas() {
//        return minas;
//    }
//
//    public void setMinas(int minas) {
//        this.minas = minas;
//    }
    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public void setMinas(int dificultad) {

        switch (dificultad) {
            case 51:
                minas = 51;
                break;
            case 64:
                minas = 64;
                break;
            case 85:
                minas = 85;
                break;
            default:
                minas = 33;
                break;
        }

    }

    public void Tablero() {
        fxGridPaneMinasIntermedio.setDisable(true);
        switch (minas) {
            case 51:
                try {
                    juegoNuevoFacil(ancho, alto, minas, vidas);
                } catch (NumeroDeVidasFueraDeRangoException ex) {
                    Logger.getLogger(FXMLPantallaIntermedioController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 64:
                try {
                    juegoNuevoMedio(ancho, alto, minas, vidas);
                } catch (NumeroDeVidasFueraDeRangoException ex) {
                    Logger.getLogger(FXMLPantallaIntermedioController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 85:
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

    Image imgBandera = new Image("/images/bandera.png");
    Image imagenMina = new Image("/images/mina.png");
    Image imagenPregunta = new Image("/images/pregunta.png");

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
        fxGridPaneMinasIntermedio.getChildren().clear();

        /*
		 * Generamos las casillas en función de la configuración que haya en el
		 * objeto "juego" (de tipo Buscaminas).
         */
        for (int y = 0; y < juego.alto(); y++) {
            fxGridPaneMinasIntermedio.getColumnConstraints().add(new ColumnConstraints());
            fxGridPaneMinasIntermedio.getRowConstraints().add(new RowConstraints());

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

                fxGridPaneMinasIntermedio.add(casilla, x, y);

                /*
				 * Cada casilla que creo, la meto en un array de tipo Nodo que
				 * contiene los elementos a los que deseo no perder referencia.
				 * De esta forma, tengo en una matriz del tamaño del tablero las
				 * referencias a los objetos Casilla cuando necesite recorrerlas
				 * en base a su posición (coordenadas x y).
                 */
                //casilla.setMinSize(20, 20);
                casillas[y][x] = casilla;
            }
        }

//        if (juego.getTotalVidas() > 1) {
//            vidasRestantes.setText("Vidas restantes: " + Integer.toString(juego.getVidasRestantes()));
//        }
    }

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
                        imagenMina.setFitWidth(15);
                        imagenMina.setFitHeight(15);

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
                    } else {
                        cuadro.setGraphic(null);
                    }
                }

            }
        }
         if (juego.isGameOver()) {
             temp.stop();
            gameOverMostrarSolucion();
            fxReset.setDisable(false);
            if (juego.isGanador()) {
                alerta("¡Has ganado!");
                user.setNombre(texto());
                user.setTiempo(temp.getSeconds());
                System.out.println(user.toString());
            } else {
                alerta(Alert.AlertType.WARNING, "Has perdido");
                gameOverMostrarSolucion();
            }
         }
    }
    
    public String texto() {
        String nombre = "";
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Text Input Dialog");
        dialog.setHeaderText("Text Input Dialog");
        dialog.setContentText("Please enter your name:");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            nombre= result.get();
        }
        return nombre;
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
                juego.cavar2(i, j);
            }

        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
