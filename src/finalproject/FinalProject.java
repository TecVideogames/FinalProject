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
    boolean boolPresionado;
    boolean boolHombreMujer;
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
    private msf_Button arrBtnMapa [] = new msf_Button [2]; 
    private String arrStrMapa [][] = new String [2][2];
    
    // arreglos de botones juego
    private msf_Button arrBtnJuego [] = new msf_Button [4]; 
    private String arrStrJuego [][] = new String [4][2];
    
    // boton de regresarFinMenu
    private msf_Button btnFinMenu;
    private String strBtnFinMenu;
    
    // boton de regresarFinMapa
    private msf_Button btnFinMapa;
    private String strBtnFinMapa;
    
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
        
        // menu principal
        for(int iI=0; iI<3; iI++){
            arrStrMenuPrincipal[iI][0] = "btnMenuPrincipal_"+iI+"_0.png";
            arrStrMenuPrincipal[iI][1] = "btnMenuPrincipal_"+iI+"_1.png";
            arrBtnMenuPrincipal[iI] = new msf_Button(405,150+iI*65,
                    190,50,arrStrMenuPrincipal[iI][0]);
        }
        
        // Initialize instruccions return button
<<<<<<< HEAD
        strBtnRegresarInstrucciones[0] = "btnInstrucciones_0.png";
        strBtnRegresarInstrucciones[1] = "btnInstrucciones_1.png";
        btnRegresarInstrucciones = new msf_Button(229, 55, 182, 49, 
=======
        strBtnRegresarInstrucciones[0] = "ImageNotFound.jpg";
        strBtnRegresarInstrucciones[1] = "btnMenuPrincipal_0_1.gif";
        btnRegresarInstrucciones = new msf_Button(229, 425, 182, 49, 
>>>>>>> origin/master
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
            arrBtnSeleccionarJugador[iI] = new msf_Button(133+(iI-2)*192,380,
                    182,49,arrStrSeleccionarJugador[iI][0]);
        }
              
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
                                    break;
                                case 1:
                                    strPantalla = "instruccions";
                                    break;
                                case 2:
                                    strPantalla = "credits";
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
                    // mark man selection
                    arrBtnSeleccionarJugador[1].setImageIcon(arrStrSeleccionarJugador[1][1],
                            arrBtnSeleccionarJugador[1].getWidth(),arrBtnSeleccionarJugador[1].getHeight());
                    // unmark woman selection
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
                                    break;
                            }
                            arrBtnSeleccionarJugador[iI].setImageIcon(arrStrSeleccionarJugador[iI][0],
                                arrBtnSeleccionarJugador[iI].getWidth(),arrBtnSeleccionarJugador[iI].getHeight());
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
                        }
                    } else {
                        btnRegresarCreditos.setImageIcon(
                                strBtnRegresarCreditos[0],
                                btnRegresarCreditos.getWidth(),
                                btnRegresarCreditos.getHeight());
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
        // Inicializan el DoubleBuffer
        if (imaImagenApplet == null) {
                imaImagenApplet = createImage (this.getSize().width, 
                        this.getSize().height);
                graGraficaApplet = imaImagenApplet.getGraphics ();
        }

        // Actualiza la imagen de fondo.
        URL urlImagenFondo = this.getClass().getResource("btnJuego.gif");
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
            case "credits":
                btnRegresarCreditos.paint(graDibujo, this);
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