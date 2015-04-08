/**
 * Juego
 *
 * Tarea basada en examen primer parcial.
 * Applet en el que se implementa un juego en el cual el jugador se mueve en
 * una cuadricula y debe recoger changuitas para obtener puntos y evitar chocar
 * con changuitos para no perder vidas.
 * El movimiento del jugador se da con las flechas del teclado
 * El juego acaba cuando se presiona la tecla ESC o bien se pierden todas las
 * vidas. Es posible pausarlo presionando la tecla P
 * 
 * Se puede importar un juego salvado al momento de inicializar el juego
 * 
 * @authors Marco Peyrot
 *          Mario Sergio Fuentes Juarez  A01036141
 * @version 1.0
 * @date 17/FEB/2015
 */

package finalproject;
 
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Mario Sergio Fuentes Juarez
 */

public class FinalProject extends Applet implements Runnable, KeyListener, 
        MouseListener, MouseMotionListener {
    int iMouseX;
    int iMouseY;
    int iAppletWidth = 640;
    int iAppletHeight = 480;
    int iDificultad;
    boolean boolPresionado;
    boolean boolHombreMujer;
    boolean boolSonidoMusica;
    boolean boolSonidoEfectos;
    private String strPantalla;
    private Image    imaImagenApplet;   // Imagen a proyectar en Applet	
    private Graphics graGraficaApplet;  // Objeto grafico de la Imagen
    
    // arreglos de botones menu principal
    private msf_Button arrBtnMenuPrincipal [] = new msf_Button [3]; 
    private String arrStrMenuPrincipal [][] = new String [3][2];
    
    // arreglos de botones menu opciones
    private msf_Button arrBtnMenuOpciones [] = new msf_Button [3]; 
    private String arrStrMenuOpciones [][] = new String [3][2];
    
    // arreglos de botones menu audio
    private msf_Button arrBtnMenuAudio [] = new msf_Button [3]; 
    private String arrStrMenuAudio [][] = new String [3][2];
    
    // arreglos de botones menu dificultad
    private msf_Button arrBtnMenuDificultad [] = new msf_Button [4]; 
    private String arrStrMenuDificultad [][] = new String [4][2];
    
    // boton de regresarInstrucciones
    private msf_Button btnRegresarInstrucciones;
    private String strBtnRegresarInstrucciones [] = new String [2];
    
    // boton de regresarCreditos
    private msf_Button btnRegresarCreditos;
    private String strBtnRegresarCreditos [] = new String [2];
    
    // arreglos de botones seleccionarJugador
    private msf_Button arrBtnSeleccionarJugador [] = new msf_Button [4]; 
    private String arrStrSeleccionarJugador [][] = new String [4][2];
    
    // arreglos de botones mapa
    private msf_Button arrBtnMapa [] = new msf_Button [5]; 
    private String arrStrMapa [][] = new String [5][2];
    
    // arreglos de botones juego
    private msf_Button arrBtnJuego [] = new msf_Button [4]; 
    private String arrStrJuego [][] = new String [4][2];
    
    // boton de regresarFinMenu
    private msf_Button btnFinMenu;
    private String strBtnFinMenu;
    
    // boton de regresarFinMapa
    private msf_Button btnFinMapa;
    private String strBtnFinMapa;
    
    // arreglos de botones de opciones
    private msf_Button arrBtnOpciones [] = new msf_Button [3];
    private String arrStrOpciones [][] = new String[3][2];
    
//    private URL urlImagenChimpy; // url de imagen de chimpy
//    private URL urlImagenDiddy; // url de imagen de diddy
	
    /** 
     * init
     * 
     * Metodo sobrescrito de la clase <code>Applet</code>.<P>
     * En este metodo se inizializan las variables o se crean los objetos
     * a usarse en el <code>Applet</code> y se definen funcionalidades.
     * 
     */
    public void init() {
        // hago el applet de un tamaño 640,480        
        setSize(iAppletWidth, iAppletHeight);
        
        // nombre de pantalla
        strPantalla = "menuPrincipal";
        
        // initialization of difficulty
        iDificultad = 0;
        
        // initialize sound booleans
        boolSonidoMusica = true;
        boolSonidoEfectos = true;
        
        // Initialize menu principal
        for(int iI=0; iI<3; iI++){
            arrStrMenuPrincipal[iI][0] = "btnMenuPrincipal_"+iI+"_0.png";
            arrStrMenuPrincipal[iI][1] = "btnMenuPrincipal_"+iI+"_1.png";
            arrBtnMenuPrincipal[iI] = new msf_Button(405,150+iI*65,
                    190,50,arrStrMenuPrincipal[iI][0]);
        }
        
        // Initialize instruccions return button
        strBtnRegresarInstrucciones[0] = "btnInstrucciones_0.png";
        strBtnRegresarInstrucciones[1] = "btnInstrucciones_1.png";
        btnRegresarInstrucciones = new msf_Button(229, 425, 182, 49, 
                strBtnRegresarInstrucciones[0]);
        
        // Initialize credits return button
        strBtnRegresarCreditos[0] = "btnCreditos_0.png";
        strBtnRegresarCreditos[1] = "btnCreditos_1.png";
        btnRegresarCreditos = new msf_Button(229, 425, 182, 49, 
                strBtnRegresarCreditos[0]);
        
        // seleccionar jugador
        
        // zero indicates man selection, one indicates woman selection
        boolHombreMujer = false;
        // boton de jugador

        // man button (originally chosen)
        arrStrSeleccionarJugador[0][0] = "btnSeleccionarJugador_0_0.gif";
        arrStrSeleccionarJugador[0][1] = "btnSeleccionarJugador_0_1.gif";
        arrBtnSeleccionarJugador[0] = new msf_Button(85,120,
                200,180,arrStrSeleccionarJugador[0][1]);
        // woman button (originally not chosen)
        arrStrSeleccionarJugador[1][0] = "btnSeleccionarJugador_1_0.gif";
        arrStrSeleccionarJugador[1][1] = "btnSeleccionarJugador_1_1.gif";
        arrBtnSeleccionarJugador[1] = new msf_Button(360,120,
                200,180,arrStrSeleccionarJugador[1][0]);
        
        // boton de navegacion
        for(int iI=2; iI<4; iI++){
            arrStrSeleccionarJugador[iI][0] = 
                    "btnSeleccionarJugador_"+iI+"_0.png";
            arrStrSeleccionarJugador[iI][1] = 
                    "btnSeleccionarJugador_"+iI+"_1.png";
            arrBtnSeleccionarJugador[iI] = new msf_Button(133+(iI-2)*192,425,
                    182,49,arrStrSeleccionarJugador[iI][0]);
        }
        
        // Initialize mapa
        // navigation buttons
        for(int iI=0; iI<2; iI++){
            arrStrMapa[iI][0] = "btnMapa_"+iI+"_0.png";
            arrStrMapa[iI][1] = "btnMapa_"+iI+"_1.png";
            arrBtnMapa[iI] = new msf_Button(133+iI*192,425,
                    182,49,arrStrMapa[iI][0]);
        }
        // Dungeon buttons
        for(int iI = 2; iI < 5; iI ++){
            arrStrMapa[iI][0] = "btnMapa_"+iI+"_0.png";
            arrStrMapa[iI][1] = "btnMapa_"+iI+"_1.png";
        }
        
        // All dungeon buttons have a specific location
        arrBtnMapa[2] = new msf_Button(25,20,
                    212,100,arrStrMapa[2][0]);
        arrBtnMapa[3] = new msf_Button(iAppletWidth - 235, 130,
                    212,100,arrStrMapa[3][0]);
        arrBtnMapa[4] = new msf_Button(iAppletWidth - 580, 250,
                    212,100,arrStrMapa[4][0]);
        
        // Initialize option menu
        // option buttons
        for(int iI = 0 ; iI < 2 ; iI ++) {
            arrStrOpciones[iI][0] = "btnMenuOpciones_"+iI+"_0.png";
            arrStrOpciones[iI][1] = "btnMenuOpciones_"+iI+"_1.png";
            arrBtnOpciones[iI] = new msf_Button(229,150+iI*65, 182, 49, 
                    arrStrOpciones[iI][0]);
        }
        // navigation button (return, 3)
        arrStrOpciones[2][0] = "btnMenuOpciones_"+2+"_0.png";
        arrStrOpciones[2][1] = "btnMenuOpciones_"+2+"_1.png";
        arrBtnOpciones[2] = new msf_Button(133,425,
                182,49,arrStrOpciones[2][0]);
        
        // Initialize difficulty menu
        // difficulty buttons
        arrStrMenuDificultad[0][0] = "btnMenuDificultad_"+0+"_0.png";
        arrStrMenuDificultad[0][1] = "btnMenuDificultad_"+0+"_1.png";
        arrBtnMenuDificultad[0] = new msf_Button(229,150, 182, 49, 
                arrStrMenuDificultad[0][1]);
        for(int iI = 1 ; iI < 3 ; iI ++) {
            arrStrMenuDificultad[iI][0] = "btnMenuDificultad_"+iI+"_0.png";
            arrStrMenuDificultad[iI][1] = "btnMenuDificultad_"+iI+"_1.png";
            arrBtnMenuDificultad[iI] = new msf_Button(229,150+iI*65, 182, 49, 
                    arrStrMenuDificultad[iI][0]);
        }
        // return button
        arrStrMenuDificultad[3][0] = "btnMenuDificultad_"+3+"_0.png";
        arrStrMenuDificultad[3][1] = "btnMenuDificultad_"+3+"_1.png";
        arrBtnMenuDificultad[3] = new msf_Button(133,425,
                182,49,arrStrMenuDificultad[3][0]);
        
        // Initialize audio menu
        // audio buttons
        for(int iI = 0 ; iI < 2 ; iI ++) {
            arrStrMenuAudio[iI][0] = "btnMenuAudio_"+iI+"_0.png";
            arrStrMenuAudio[iI][1] = "btnMenuAudio_"+iI+"_1.png";
            arrBtnMenuAudio[iI] = new msf_Button(130+260*iI,200, 100, 100, 
                    arrStrMenuAudio[iI][0]);
        }
        // return button
        arrStrMenuAudio[2][0] = "btnMenuAudio_"+2+"_0.png";
        arrStrMenuAudio[2][1] = "btnMenuAudio_"+2+"_1.png";
        arrBtnMenuAudio[2] = new msf_Button(133,425,
                182,49,arrStrMenuAudio[2][0]);
              
        /* se le añade la opcion al applet de ser escuchado por los eventos
           del mouse  */
	addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);     
    }
	
    /** 
     * start
     * 
     * Metodo sobrescrito de la clase <code>Applet</code>.<P>
     * En este metodo se crea e inicializa el hilo
     * para la animacion este metodo es llamado despues del init o 
     * cuando el usuario visita otra pagina y luego regresa a la pagina
     * en donde esta este <code>Applet</code>
     * 
     */
    public void start () {
        // Declaras un hilo
        Thread th = new Thread (this);
        // Empieza el hilo
        th.start ();
    }
	
    /** 
     * run
     * 
     * Metodo sobrescrito de la clase <code>Thread</code>.<P>
     * En este metodo se ejecuta el hilo, que contendrá las instrucciones
     * de nuestro juego.
     * 
     */
    public void run () {
        /* mientras dure el juego, se actualizan posiciones de jugadores
           se checa si hubo colisiones para desaparecer jugadores o corregir
           movimientos y se vuelve a pintar todo
        */ 
        
        // mientras no este prendida bandera de fin de juego
        while (true) { 
            actualiza();
            checaColision();
            repaint();
            try	{
                // El thread se duerme.
                Thread.sleep (20);
            }
            catch (InterruptedException iexError) {
                System.out.println("Hubo un error en el juego " + 
                        iexError.toString());
            }
	}
        
    }
	
    /** 
     * actualiza
     * 
     * Metodo que actualiza la posicion de los objetos 
     * 
     */
    public void actualiza() {
        
        // actualiza botones menu principal
        switch(strPantalla){
            case "menuPrincipal":
                for(int iI=0; iI<3; iI++){
                    if(arrBtnMenuPrincipal[iI].pointerInside(iMouseX,iMouseY)){

                        arrBtnMenuPrincipal[iI].setImageIcon(
                                arrStrMenuPrincipal[iI][1],
                                arrBtnMenuPrincipal[iI].getWidth(),
                                arrBtnMenuPrincipal[iI].getHeight());

                        if(boolPresionado){
                            switch(iI){
                                case 0:
                                    strPantalla = "seleccionarJugador";
                                    boolPresionado = false;
                                    break;
                                case 1:
                                    strPantalla = "instruccions";
                                    boolPresionado = false;
                                    break;
                                case 2:
                                    strPantalla = "credits";
                                    boolPresionado = false;
                                    break;
                            }
                            arrBtnMenuPrincipal[iI].setImageIcon(
                                    arrStrMenuPrincipal[iI][0],
                                arrBtnMenuPrincipal[iI].getWidth(),
                                arrBtnMenuPrincipal[iI].getHeight());
                        }
                    } else {
                        arrBtnMenuPrincipal[iI].setImageIcon(
                                arrStrMenuPrincipal[iI][0],
                                arrBtnMenuPrincipal[iI].getWidth(),
                                arrBtnMenuPrincipal[iI].getHeight());
                    }
                }
                break;
            case "seleccionarJugador":

                // Check player selection
                // Man button
                if(arrBtnSeleccionarJugador[0].pointerInside(iMouseX,iMouseY)
                        && boolPresionado && boolHombreMujer){
                    // update boolean
                    boolHombreMujer = !boolHombreMujer;
                    // mark man selection
                    arrBtnSeleccionarJugador[0].setImageIcon(arrStrSeleccionarJugador[0][1],
                            arrBtnSeleccionarJugador[0].getWidth(),arrBtnSeleccionarJugador[0].getHeight());
                    // unmark woman selection
                    arrBtnSeleccionarJugador[1].setImageIcon(arrStrSeleccionarJugador[1][0],
                            arrBtnSeleccionarJugador[1].getWidth(),arrBtnSeleccionarJugador[1].getHeight());
                }
                // Woman button
                if(arrBtnSeleccionarJugador[1].pointerInside(iMouseX,iMouseY)
                        && boolPresionado && !boolHombreMujer){
                    // update boolean
                    boolHombreMujer = !boolHombreMujer;
                    // mark woman selection
                    arrBtnSeleccionarJugador[1].setImageIcon(arrStrSeleccionarJugador[1][1],
                            arrBtnSeleccionarJugador[1].getWidth(),arrBtnSeleccionarJugador[1].getHeight());
                    // unmark man selection
                    arrBtnSeleccionarJugador[0].setImageIcon(arrStrSeleccionarJugador[0][0],
                            arrBtnSeleccionarJugador[0].getWidth(),arrBtnSeleccionarJugador[0].getHeight());
                }
                // Check navigation buttons
                for(int iI=2; iI<4; iI++){
                    if(arrBtnSeleccionarJugador[iI].pointerInside(iMouseX,iMouseY)){
                        arrBtnSeleccionarJugador[iI].setImageIcon(arrStrSeleccionarJugador[iI][1],
                                arrBtnSeleccionarJugador[iI].getWidth(),arrBtnSeleccionarJugador[iI].getHeight());

                        if(boolPresionado){
                            switch(iI){
                                case 2:
                                    strPantalla = "menuPrincipal";
                                    boolPresionado = false;
                                    break;
                                case 3:
                                    strPantalla = "mapa";
                                    boolPresionado = false;
                                    break;
                            }
                            boolHombreMujer = false;
                            arrBtnSeleccionarJugador[0].setImageIcon(arrStrSeleccionarJugador[0][1],
                                arrBtnSeleccionarJugador[0].getWidth(),arrBtnSeleccionarJugador[0].getHeight());
                            arrBtnSeleccionarJugador[1].setImageIcon(arrStrSeleccionarJugador[1][0],
                                arrBtnSeleccionarJugador[1].getWidth(),arrBtnSeleccionarJugador[1].getHeight());
                        }
                    } else {
                        arrBtnSeleccionarJugador[iI].setImageIcon(
                                arrStrSeleccionarJugador[iI][0],
                                arrBtnSeleccionarJugador[iI].getWidth(),
                                arrBtnSeleccionarJugador[iI].getHeight());
                    }
                }
                break;
            case "instruccions":
                if(btnRegresarInstrucciones.pointerInside(iMouseX,iMouseY)){
                        btnRegresarInstrucciones.setImageIcon(
                                strBtnRegresarInstrucciones[1],
                                btnRegresarInstrucciones.getWidth(),
                                btnRegresarInstrucciones.getHeight());
                        if(boolPresionado){
                            strPantalla = "menuPrincipal";
                            boolPresionado = false;
                        }
                    } else {
                        btnRegresarInstrucciones.setImageIcon(
                                strBtnRegresarInstrucciones[0],
                                btnRegresarInstrucciones.getWidth(),
                                btnRegresarInstrucciones.getHeight());
                    }
                break;
            case "credits":
                if(btnRegresarCreditos.pointerInside(iMouseX,iMouseY)){
                        btnRegresarCreditos.setImageIcon(
                                strBtnRegresarCreditos[1],
                                btnRegresarCreditos.getWidth(),
                                btnRegresarCreditos.getHeight());
                        if(boolPresionado){
                            strPantalla = "menuPrincipal";
                            boolPresionado = false;
                        }
                    } else {
                        btnRegresarCreditos.setImageIcon(
                                strBtnRegresarCreditos[0],
                                btnRegresarCreditos.getWidth(),
                                btnRegresarCreditos.getHeight());
                    }
                break;
            case "mapa":
                for(int iI=0; iI<5; iI++){
                    if(arrBtnMapa[iI].pointerInside(iMouseX,iMouseY)){

                        arrBtnMapa[iI].setImageIcon(
                                arrStrMapa[iI][1],
                                arrBtnMapa[iI].getWidth(),
                                arrBtnMapa[iI].getHeight());

                        if(boolPresionado){
                            switch(iI){
                                case 0:
                                    strPantalla = "seleccionarJugador";
                                    boolPresionado = false;
                                    break;
                                case 1:
                                    strPantalla = "opciones";
                                    boolPresionado = false;
                                    break;
                                case 2:
                                case 3:
                                case 4:
                                    //strPantalla = "juego";
                                    break;
                            }
                        }
                    } 
                    else {
                        arrBtnMapa[iI].setImageIcon(
                                arrStrMapa[iI][0],
                                arrBtnMapa[iI].getWidth(),
                                arrBtnMapa[iI].getHeight());
                    }
                }
                break;
            case "opciones":
                for(int iI = 0; iI < 3; iI ++) {
                    if(arrBtnOpciones[iI].pointerInside(iMouseX, iMouseY)) {
                        arrBtnOpciones[iI].setImageIcon(arrStrOpciones[iI][1],
                                arrBtnOpciones[iI].getWidth(), 
                                arrBtnOpciones[iI].getHeight());
                        
                        if(boolPresionado) {
                            switch(iI) {
                                case 0:
                                    strPantalla = "dificultad";
                                    boolPresionado = false;
                                    break;
                                case 1:
                                    strPantalla = "audio";
                                    boolPresionado = false;
                                    break;
                                case 2:
                                    strPantalla = "mapa";
                                    boolPresionado = false;
                                    break;
                            }
                        }
                    }
                    else {
                        arrBtnOpciones[iI].setImageIcon(arrStrOpciones[iI][0],
                                arrBtnOpciones[iI].getWidth(), 
                                arrBtnOpciones[iI].getHeight());                        
                    }
                }
                break;
            case "dificultad":

                // Check difficulty selection
                // easy button
                if(arrBtnMenuDificultad[0].pointerInside(iMouseX,iMouseY)
                        && boolPresionado && iDificultad != 0){
                    // update difficulty
                    iDificultad = 0;
                    // mark easy selection
                    arrBtnMenuDificultad[0].setImageIcon(arrStrMenuDificultad[0][1],
                            arrBtnMenuDificultad[0].getWidth(),arrBtnMenuDificultad[0].getHeight());
                    // unmark the rest of the buttons
                    arrBtnMenuDificultad[1].setImageIcon(arrStrMenuDificultad[1][0],
                            arrBtnMenuDificultad[1].getWidth(),arrBtnMenuDificultad[1].getHeight());
                    arrBtnMenuDificultad[2].setImageIcon(arrStrMenuDificultad[2][0],
                            arrBtnMenuDificultad[2].getWidth(),arrBtnMenuDificultad[2].getHeight());
                }
                // medium button
                else if(arrBtnMenuDificultad[1].pointerInside(iMouseX,iMouseY)
                        && boolPresionado && iDificultad != 1){
                    // update difficulty
                    iDificultad = 1;
                    // mark medium selection
                    arrBtnMenuDificultad[1].setImageIcon(arrStrMenuDificultad[1][1],
                            arrBtnMenuDificultad[1].getWidth(),arrBtnMenuDificultad[1].getHeight());
                    // unmark the rest of the buttons
                    arrBtnMenuDificultad[0].setImageIcon(arrStrMenuDificultad[0][0],
                            arrBtnMenuDificultad[0].getWidth(),arrBtnMenuDificultad[0].getHeight());
                    arrBtnMenuDificultad[2].setImageIcon(arrStrMenuDificultad[2][0],
                            arrBtnMenuDificultad[2].getWidth(),arrBtnMenuDificultad[2].getHeight());
                }
                // hard button
                else if(arrBtnMenuDificultad[2].pointerInside(iMouseX,iMouseY)
                        && boolPresionado && iDificultad != 2){
                    // update difficulty
                    iDificultad = 2;
                    // mark hard selection
                    arrBtnMenuDificultad[2].setImageIcon(arrStrMenuDificultad[2][1],
                            arrBtnMenuDificultad[2].getWidth(),arrBtnMenuDificultad[2].getHeight());
                    // unmark the rest of the buttons
                    arrBtnMenuDificultad[0].setImageIcon(arrStrMenuDificultad[0][0],
                            arrBtnMenuDificultad[0].getWidth(),arrBtnMenuDificultad[0].getHeight());
                    arrBtnMenuDificultad[1].setImageIcon(arrStrMenuDificultad[1][0],
                            arrBtnMenuDificultad[1].getWidth(),arrBtnMenuDificultad[1].getHeight());
                }
                // Check navigation buttons
                if(arrBtnMenuDificultad[3].pointerInside(iMouseX,iMouseY)){
                        arrBtnMenuDificultad[3].setImageIcon(arrStrMenuDificultad[3][1],
                                arrBtnMenuDificultad[3].getWidth(),arrBtnMenuDificultad[3].getHeight());

                    if(boolPresionado){
                        strPantalla = "opciones";
                        boolPresionado = false;
                        // reset difficulty selection                        
                        iDificultad = 0;
                        arrBtnMenuDificultad[0].setImageIcon(arrStrMenuDificultad[0][1],
                            arrBtnMenuDificultad[0].getWidth(),arrBtnMenuDificultad[0].getHeight());
                        arrBtnMenuDificultad[1].setImageIcon(arrStrMenuDificultad[1][0],
                            arrBtnMenuDificultad[1].getWidth(),arrBtnMenuDificultad[1].getHeight());
                        arrBtnMenuDificultad[2].setImageIcon(arrStrMenuDificultad[2][0],
                            arrBtnMenuDificultad[2].getWidth(),arrBtnMenuDificultad[2].getHeight());
                    }
                } else {
                    arrBtnMenuDificultad[3].setImageIcon(
                            arrStrMenuDificultad[3][0],
                            arrBtnMenuDificultad[3].getWidth(),
                            arrBtnMenuDificultad[3].getHeight());
                }
                break;
            case "audio":
                // check music button
                if(arrBtnMenuAudio[0].pointerInside(iMouseX,iMouseY)
                        && boolPresionado){
                    if(boolSonidoMusica){
                        arrBtnMenuAudio[0].setImageIcon(arrStrMenuAudio[0][0],
                                arrBtnMenuAudio[0].getWidth(),arrBtnMenuAudio[0].getHeight());
                        boolSonidoMusica = !boolSonidoMusica;
                    } else if(!boolSonidoMusica) {
                        arrBtnMenuAudio[0].setImageIcon(arrStrMenuAudio[0][1],
                                arrBtnMenuAudio[0].getWidth(),arrBtnMenuAudio[0].getHeight());
                        
                    }
                    boolPresionado = false;
                }
                // check music button
                if(arrBtnMenuAudio[1].pointerInside(iMouseX,iMouseY)
                        && boolPresionado){
                    if(boolSonidoEfectos){
                        arrBtnMenuAudio[1].setImageIcon(arrStrMenuAudio[1][0],
                                arrBtnMenuAudio[1].getWidth(),arrBtnMenuAudio[0].getHeight());
                        boolSonidoEfectos = !boolSonidoEfectos;
                    } else {
                        arrBtnMenuAudio[1].setImageIcon(arrStrMenuAudio[1][1],
                                arrBtnMenuAudio[1].getWidth(),arrBtnMenuAudio[1].getHeight());
                    }
                    boolPresionado = false;
                }
                
                break;
        }
    }
	
    /**
     * checaColision
     * 
     * Metodo usado para checar la colision entre objetos
     * 
     */
    public void checaColision(){
        
    }
	
    /**
     * update
     * 
     * Metodo sobrescrito de la clase <code>Applet</code>,
     * heredado de la clase Container.<P>
     * En este metodo lo que hace es actualizar el contenedor y 
     * define cuando usar ahora el paint
     * 
     * @param graGrafico es el <code>objeto grafico</code> usado para dibujar.
     * 
     */
    public void update (Graphics graGrafico) {
        URL urlImagenFondo = this.getClass().getResource("btnJuego.gif");
        
        // Inicializan el DoubleBuffer
        if (imaImagenApplet == null) {
                imaImagenApplet = createImage (this.getSize().width, 
                        this.getSize().height);
                graGraficaApplet = imaImagenApplet.getGraphics ();
        }

        // Actualiza la imagen de fondo.
        if(strPantalla.equals("mapa")) {
            urlImagenFondo = this.getClass().getResource("mapEgypt.jpg");
        }
        
        if(strPantalla != "mapa") {
            urlImagenFondo = this.getClass().getResource("btnJuego.gif");
        }
        
        Image imaImagenFondo = 
                Toolkit.getDefaultToolkit().getImage(urlImagenFondo);
         graGraficaApplet.drawImage(imaImagenFondo, 0, 
                 0, getWidth(), getHeight(), this);

        // Actualiza el Foreground.
        graGraficaApplet.setColor (getForeground());
        paint(graGraficaApplet);

        // Dibuja la imagen actualizada
        graGrafico.drawImage (imaImagenApplet, 0, 0, this);
    }
    
    /**
     * paint
     * 
     * Metodo sobrescrito de la clase <code>Applet</code>,
     * heredado de la clase Container.<P>
     * En este metodo se dibuja la imagen con la posicion actualizada,
     * ademas que cuando la imagen es cargada te despliega una advertencia.
     * 
     * @param graDibujo es el objeto <code>Graphics</code> usado para dibujar.
     * 
     */
    public void paint(Graphics graDibujo) {
        //ImageIcon imiAppletIcon;
        
        switch(strPantalla){
            case "menuPrincipal":
                for(int i=0; i<3; i++){
                    arrBtnMenuPrincipal[i].paint(graDibujo, this);
                }
                break;
            case "seleccionarJugador":
                for(int i=0; i<4; i++){
                    arrBtnSeleccionarJugador[i].paint(graDibujo, this);
                }
                break;
            case "instruccions":
                btnRegresarInstrucciones.paint(graDibujo, this);
                break;
            case "credits":
                btnRegresarCreditos.paint(graDibujo, this);
                break;
            case "mapa":                
                for(int i=0; i<5; i++){
                    arrBtnMapa[i].paint(graDibujo, this);
                }
                break;
            case "opciones":
                for(int i=0; i < 3 ; i++) {
                    arrBtnOpciones[i].paint(graDibujo, this);
                }
                break;
            case "dificultad":
                for(int i=0; i < 4 ; i++) {
                    arrBtnMenuDificultad[i].paint(graDibujo, this);
                }
                break;
            case "audio":
                for(int i=0; i < 3 ; i++) {
                    arrBtnMenuAudio[i].paint(graDibujo, this);
                }
                break;
        }
    }
    
    /**
     * keyTyped
     * 
     * Metodo sobrescrito de la interface <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al presionar una 
     * tecla que no es de accion.
     * 
     * @param keyEvent es el <code>KeyEvent</code> que se genera en al presionar
     * 
     */
    public void keyTyped(KeyEvent e) {
        // no hay codigo pero se debe escribir el metodo
    }

    /**
     * keyPressed
     * 
     * Metodo sobrescrito de la interface <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al dejar presionada
     * alguna tecla.
     * 
     * @param keyEvent es el <code>KeyEvent</code> que se genera en al presionar
     * 
     */
    public void keyPressed(KeyEvent e) {
        // no hay codigo pero se debe escribir el metodo
    }

    /**
     * keyReleased
     * Metodo sobrescrito de la interface <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al soltar la tecla.
     * 
     * @param keyEvent es el <code>KeyEvent</code> que se genera en al soltar.
     * 
     */
    public void keyReleased(KeyEvent keyEvent) {  
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Not supported
    }

    @Override
    public void mousePressed(MouseEvent e) {
        boolPresionado = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        boolPresionado = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
  //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        iMouseX = e.getX();
        iMouseY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        iMouseX = e.getX();
        iMouseY = e.getY();
    }
}