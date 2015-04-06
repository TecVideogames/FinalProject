/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finalproject;

import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author E15
 */
public class Boton extends Base {

    public Boton(int iX, int iY, int iAncho, int iAlto, Image imaImagen) {
        super(iX, iY, iAncho, iAlto, imaImagen);
    }
    
    /**
     * estaAdentro
     * 
     * Metodo que checa si una coordenada esta contenida
     * en el area abarcada por un AnimalCosa
     * 
     * @param x es un <code>int</code> que indica la coordenada en X
     * @param y es un <code>int</code> que indica la coordenada en Y
     * @return un valor <code>boolean</code> indicando si la coordenada esta
     * dentro del area del AnimalCosa
     *  
     */
    public boolean estaAdentro(int x, int y) {
        
        // se crea rectángulo del objeto
        Rectangle rctEste = new Rectangle(this.getX(), this.getY(), 
                this.getAncho(), this.getAlto());
        // Devuelve si la coordenada (x,y) esta contenida en el rectangulo
        // que representa la imagen del objeto AnimalCosa
        return rctEste.contains(x,y);
            
    }
    
}
