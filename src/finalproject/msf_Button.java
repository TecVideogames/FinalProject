/**
 * msf_Button
 * 
 * @Sergio Fuentes
 */

package finalproject;

import java.awt.Rectangle;

public class msf_Button extends Sat_VisualObject {

    /**
     * msf_Button
     * 
     * Only constructor for an button object used throughout the game
     * 
     * @param iX an <code> int </code> with the buttons x position
     * @param iY an <code> int </code> with the buttons y position
     * @param iWidth an <code> int </code> with the buttons width
     * @param iHeight an <code> int </code> with the buttons height
     * @param strImage an <code> string </code> with the buttons image URL
     */
    public msf_Button(int iX, int iY, int iWidth, int iHeight, String strImage) {
        startPos(iX, iY);
        this.setImageIcon(strImage, iWidth, iHeight);
    }

    /**
     * pointerInside
     * 
     * Abstract method that checks if mouse pointer is inside this object
     * 
     * @param iPosX is an <code> int </code> with the pointer's x-coordinate
     * @param iPosY is an <code> int </code> with the pointer's y-coordinate
     * @return a <code> boolean </code> if pointer is inside this object
     */
    @Override
    public boolean pointerInside(int iPosX, int iPosY) {
        // Create container figure
        Rectangle.Float recThis = new Rectangle.Float(this.getIPosX(),
                this.getIPosY(), this.getWidth(), this.getHeight());
        
        return recThis.contains(iPosX, iPosY);
    }

    /**
     * intersectsRight
     * 
     * Checks if this instance's right side intersects with another instace
     * 
     * @param objParameter is the <code> Object </code> to which we want to know
     * if an intersection occurs
     * @return a <code> boolean </code> if an intersection exists
     */
    @Override
    public boolean intersectsRight(Object objParameter) {
        return false;
    }

    /**
     * intersectsLeft
     * 
     * Checks if this instance's left side intersects with another instace
     * 
     * @param objParameter is the <code> Object </code> to which we want to know
     * if an intersection occurs
     * @return a <code> boolean </code> if an intersection exists
     */
    @Override
    public boolean intersectsLeft(Object objParameter) {
        return false;
    }

    /**
     * intersectsTop
     * 
     * Checks if this instance's top side intersects with another instace
     * 
     * @param objParameter is the <code> Object </code> to which we want to know
     * if an intersection occurs
     * @return a <code> boolean </code> if an intersection exists
     */
    @Override
    public boolean intersectsTop(Object objParameter) {
        return false;
    }

    /**
     * intersectsBottom
     * 
     * Checks if this instance's bottom side intersects with another instace
     * 
     * @param objParameter is the <code> Object </code> to which we want to know
     * if an intersection occurs
     * @return a <code> boolean </code> if an intersection exists
     */
    @Override
    public boolean intersectsBottom(Object objParameter) {
        return false;
    }

    /**
     * intersects
     * 
     * Checks if this instance intersects with another instance
     * 
     * @param objParameter is an <code> Object </code> to which the intersection
     * is checked
     * @return a <code> boolean </code> if the intersection occurs
     */
    @Override
    public boolean intersects(Object objParameter) {
        return false;
    }
}
