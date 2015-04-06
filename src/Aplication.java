/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Aplication extends Applet implements Runnable, MouseListener {
    
    //Declaracion de variables globales y objetos
    private Graphics graGraficaApplet; //gráfico que se mostrará
    
    /**
     * init.
     * 
     * Método sobreescrito de la clase Applet. Se utiliza para definir aspectos
     * iniciales del juego. Se ejecuta solo una vez al inicio de la aplicación
     * 
     */
    @Override
    public void init() {
        //Se ajusta tamaño del Applet
        setSize(800,431);
                
        //Se generan URL's de imagenes y sonidos
        
        //Se asignan URL's a las variables correspondientes
        
        //Se ajusta el tamaño de las imagenes necesarias
        
        //Se instancian objetos
        
        //Se inicializan variables globales
        
        //Se habilita uso de mouse para el Applet
        addMouseListener(this);
        
    }
    
    /**
     * paint.
     * 
     * Método sobreescrito de la clase Applet, heredado de la clase Container.
     * Se utiliza para dibujar la imagen con su posición actualizada.
     * 
     * @param graDibujo Objeto usado para dibujar
     */
    public void paint(Graphics graDibujo) {
        graDibujo.setColor(Color.red);
        graDibujo.drawString("Funciona", 50, 50);
        
    }
    
    /**
     * update.
     * 
     * Método sobrescrito de la clase Applet, heredado de la clase Container.
     * Actualiza el contenedor y se encarga de hacer el llamado a la función
     * paint.
     * 
     * @param graDibujo Objeto usado para dibujar
     */
    public void update(Graphics graDibujo) {
        
        //Se actualiza el Foreground
        paint(graGraficaApplet);
        
    }
    
    public void start() {
        //Se declara el Thread del juego
        Thread th = new Thread(this);
        
        //Se inicia el Thread del juego
        th.start();
    }

    public void actualiza() {
        
    }
    
    public void checaColision() {
        
    }
    
    @Override
    public void run() {
        while(true) {
            checaColision();
            actualiza();
            repaint();
            try {
		Thread.sleep (10);	
            }
            catch (InterruptedException ex)	{
		System.out.println("Error en " + ex.toString());
            }            
        }
    }

    /**
     * mouseDragged.
     * 
     * Método sobrescrito de la clase MouseMotionListener. Se ejecuta al
     * arrastrar el puntero dentro de la Applet
     * 
     * @param mseEvent Evento de arrastre del mouse.
     */
    public void mouseDragged(MouseEvent mseEvent) {

    }

    /**
     * mouseMoved
     * 
     * Método sobreescrito de la clase MouseMotionListener. Sin uso en ésta
     * aplicacion. Se invoca cuando el mouse se mueve.
     * 
     * @param mseEvent Evento de movimiento del mouse
     */
    public void mouseMoved(MouseEvent mseEvent) {
        //Sin soporte
    }

    /**
     * 
     * mouseClicked
     * 
     * Método sobreescrito de la clase MouseListener. Sin uso en ésta aplicación
     * Se invoca cuando el mouse es clickeado (presionado y libreado).
     * 
     * @param mseEvent Evento de clickear el mouse. 
     */
    public void mouseClicked(MouseEvent mseEvent) {
        //sin soporte
    }

    /**
     * mousePressed
     * 
     * Método sobrescrito de la interface MouseListener. Se invoca al clickear
     * con el mouse o interface usada.
     * 
     * @param mseEvent Evento de presionar con el mouse.
     */
    public void mousePressed(MouseEvent mseEvent) {
        
    }

    /**
     * mouseReleased
     * 
     * Método sobreescrito de la interfaz MouseListener. Se invoca cuando se
     * deja de presionar algún boton del mouse.
     * 
     * @param mseEvent Evento de haber dejado de presionar un boton del mouse
     */
    @Override
    public void mouseReleased(MouseEvent mseEvent) {
        //Desactivo la bandera de Click, pues ya terminó de mover al objeto
        bClick = false;

    }

    /**
     * mouseEntered
     * 
     * Método heredado de la interfaz MouseListener. Se invoca cuando el mouse
     * entra a la aplicación
     * 
     * @param mseEvento Evento de que el mouse entra a la aplicación 
     */
    @Override
    public void mouseEntered(MouseEvent mseEvento) {
        //sin soporte
    }
    
    /**
     * mouseExited
     * 
     * Método heredado de la interfaz mouseExited. Se invoca cuando el mouse
     * sale de la aplicación
     * 
     * @param mseEvent Evento de que el mouse sale de la aplicación 
     */
    @Override
    public void mouseExited(MouseEvent mseEvent) {
        //Sin soporte
    }

 
    
}
