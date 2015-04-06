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
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.LinkedList;

/**
 *
 * @author Mario Sergio Fuentes Juarez
 */
public class FinalProject extends Applet implements Runnable, KeyListener, MouseListener,
        MouseMotionListener {
    int iX;
    int iY;
    boolean boolPresionado;
    boolean boolHombreMujer;
    private String strPantalla;
    private Image    imaImagenApplet;   // Imagen a proyectar en Applet	
    private Graphics graGraficaApplet;  // Objeto grafico de la Imagen
    
    // arreglos de botones menu principal
    private Boton arrBtnMenuPrincipal [] = new Boton [4]; 
    private URL arrUrlMenuPrincipal [][] = new URL [4][2];
    
    // arreglos de botones menu opciones
    private Boton arrBtnMenuOpciones [] = new Boton [3]; 
    private URL arrUrlMenuOpciones [][] = new URL [3][2];
    
    // arreglos de botones menu audio
    private Boton arrBtnMenuAudio [] = new Boton [3]; 
    private URL arrUrlMenuAudio [][] = new URL [3][2];
    
    // arreglos de botones menu dificultad
    private Boton arrBtnMenuDificultad [] = new Boton [4]; 
    private URL arrUrlMenuDificultad [][] = new URL [4][2];
    
    // boton de regresarInstrucciones
    private Boton btnRegresarInstrucciones;
    private URL urlBtnRegresarInstrucciones;
    
    // boton de regresarPuntuaciones
    private Boton btnRegresarPuntuaciones;
    private URL urlBtnRegresarPuntuaciones;
    
    // boton de regresarCreditos
    private Boton btnRegresarCreditos;
    private URL urlBtnRegresarCreditos;
    
    // arreglos de botones seleccionarJugador
    private Boton arrBtnSeleccionarJugador [] = new Boton [4]; 
    private URL arrUrlSeleccionarJugador [][] = new URL [4][2];
    
    // arreglos de botones mapa
    private Boton arrBtnMapa [] = new Boton [2]; 
    private URL arrUrlMapa [][] = new URL [2][2];
    
    // arreglos de botones juego
    private Boton arrBtnJuego [] = new Boton [4]; 
    private URL arrUrlJuego [][] = new URL [4][2];
    
    // boton de regresarFinMenu
    private Boton btnFinMenu;
    private URL urlBtnFinMenu;
    
    // boton de regresarFinMapa
    private Boton btnFinMapa;
    private URL urlBtnFinMapa;
    
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
        setSize(640,480);
        
        // nombre de pantalla
        strPantalla = "menuPrincipal";
        
        // menu principal
        for(int iI=0; iI<4; iI++){
            arrUrlMenuPrincipal[iI][0] = this.getClass().getResource("btnMenuPrincipal_0.gif");
            arrUrlMenuPrincipal[iI][1] = this.getClass().getResource("btnMenuPrincipal_1.gif");
            arrBtnMenuPrincipal[iI] = new Boton(405,150+iI*65,
                    190,50,Toolkit.getDefaultToolkit().getImage(arrUrlMenuPrincipal[iI][1]));
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
                for(int iI=0; iI<4; iI++){
                    if(arrBtnMenuPrincipal[iI].estaAdentro(iX,iY)){
                        arrBtnMenuPrincipal[iI].setImagen(Toolkit.getDefaultToolkit().getImage(arrUrlMenuPrincipal[iI][1]));
                        if(boolPresionado){
                            switch(iI){
                                case 0:
                                    strPantalla = "seleccionarJugador";
                                    break;
                            }
                            arrBtnMenuPrincipal[iI].setImagen(Toolkit.getDefaultToolkit().getImage(arrUrlMenuPrincipal[iI][0]));
                        }
                    } else {
                        arrBtnMenuPrincipal[iI].setImagen(Toolkit.getDefaultToolkit().getImage(arrUrlMenuPrincipal[iI][0]));
                    }
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
     * @param graDibujo es el objeto de <code>Graphics</code> usado para dibujar.
     * 
     */
    public void paint(Graphics graDibujo) {
        switch(strPantalla){
            case "menuPrincipal":
                for(int i=0; i<4; i++){
                    arrBtnMenuPrincipal[i].paint(graDibujo, this);
                }
                break;
            case "seleccionarJugador":
                arrBtnMenuPrincipal[0].paint(graDibujo, this);
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
 //       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        iX = e.getX();
        iY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        iX = e.getX();
        iY = e.getY();
    }
}