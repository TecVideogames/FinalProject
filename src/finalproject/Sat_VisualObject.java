package finalproject;

/**
 * Sat_VisualObject
 * 
 * Abstract class that extends Saturn086_Object and adds visual functionality 
 * 
 * @author Marco Antonio Peyrot A0815262
 * @version 1.0
 */

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.net.URL;
import javax.swing.ImageIcon;

public abstract class Sat_VisualObject extends Sat_Object {
    // Object's visual attributes
    protected ImageIcon imiIcon; // Object's image icon which contains the image
    protected Image imaImage; // Object's image
    protected URL urlImage; // Object's image URL
    protected int iPointerDistX; // Mouse Pointer's distance from x position
    protected int iPointerDistY; // Mouse Pointer's distance from y position
    protected int iLastIPosX; // Player's X position in a defined time in the past
    protected int iLastIPosY; // Player's Y position in a defined time in the past
    protected boolean bPaint;
    
    /**
     * setImageURL
     * 
     * Set object's image URL (Only for internal use)
     * 
     * @param strURL is a <code> String </code> which specifies the images' URL
     */
    private void setImageURL(String strURL) {
        urlImage = this.getClass().getResource(strURL);
    }
    
    public boolean getBPaint() {
        return bPaint;
    }
    
    public void setBPaint(boolean bPaint) {
        this.bPaint = bPaint;
    }
    
    /**
     * setImage
     * 
     * Set object's image (Only for internal use)
     */
    private void setImage() {
        imaImage = Toolkit.getDefaultToolkit().getImage(urlImage);        
    }
    
    /**
     * setILastIPosX
     * 
     * Method to determine which X position in the past is referenced
     * 
     */
    public void setILastIPosX() {
        this.iLastIPosX = getIPosX();
    }
    
    /**
     * getILastIPosX
     * 
     * Method which returns the last iPosX registered
     * 
     * @return an <code> int </code> with the last player's iPosX 
     */
    public int getILastIPosX() {
        return iLastIPosX;
    }
    
    /**
     * setILastIPosY
     * 
     * Method to determine which Y position in the past is referenced
     * 
     */
    public void setILastIPosY() {
        this.iLastIPosY = getIPosY();
    }
    
    /**
     * getILastIPosY
     * 
     * Method which returns the last iPosY registered
     * 
     * @return an <code> int </code> with the last player's iPosY
     */
    public int getILastIPosY() {
        return iLastIPosY;
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
    public abstract boolean pointerInside(int iPosX, int iPosY);
    
    /**
     * pointerDist
     * 
     * Calculate distance from mouse pointer's coordinates
     * 
     * @param iPosX is an <code> int </code> with the pointer's x-coordinate
     * @param iPosY is an <code> int </code> with the pointer's y-coordinate
     */
    public void pointerDist(int iPosX, int iPosY) {
        iPointerDistX = iPosX - getIPosX();
        iPointerDistY = iPosY - getIPosY();
    }
    
    /**
     * startPos
     * 
     * Method that determines where the object instance 
     * must appear in the applet
     * 
     * @param iPosX is an <code> int </code> with the start x position
     * @param iPosY is an <code> int </code> with the start y position
     */
    public void startPos(int iPosX, int iPosY)
    {
        this.iPosX = iPosX;
        this.iPosY = iPosY;
    }
    
    /**
     * resizeImage
     * 
     * Resize object's image to a desired size
     * 
     * @param iSizeX is an <code> int </code> for the image's
     * new horizontal size
     * @param iSizeY is an <code> int </code> for the image's new vertical size
     */
    private void resizeImage(int iSizeX, int iSizeY) {
        imaImage = imaImage.getScaledInstance(iSizeX, iSizeY,
                java.awt.Image.SCALE_DEFAULT);
    }
    
    /**
     * setImageIcon
     * 
     * Set object's image icon
     * 
     * @param strURL is a <code> String </code> which specifies the image's URL
     * @param iSizeX is an <code> int </code> for the image's
     * new horizontal size
     * @param iSizeY is an <code> int </code> for the image's new vertical size
     */
    public void setImageIcon(String strURL, int iSizeX, int iSizeY) {
        // Use internal methods
        setImageURL(strURL);
        setImage();
        resizeImage(iSizeX, iSizeY);
        // Create object's image icon
        imiIcon = new ImageIcon(imaImage);
    }
    
    /**
     * getImageIcon
     * 
     * Get object's image icon
     * 
     * @return an <code> ImageIcon </code> which represents
     * the object's ImageIcon.
     */
    public ImageIcon getImageIcon() {
        return imiIcon;
    }
    
    /**
     * getImage
     * 
     * Get object's image
     * 
     * @return an <code> Image </code> with the object's image 
     */
    public Image getImage() {
        return imaImage;
    }
    
    /**
     * getImageURL
     * 
     * Get image's URL
     * 
     * @return an <code> URL </code> which refers to the image's URL
     */
    public URL getImageURL() {
        return urlImage;
    }
    
    /**
     * getWidth
     * 
     * Get the object's width according to its current ImageIcon
     * 
     * @return an <code> int </code> with the image icon's width
     */
    public int getWidth() {
        return imiIcon.getIconWidth();
    }
    
    /**
     * getHeight
     * 
     * Get the object's height according to its current ImageIcon
     * 
     * @return an <code> int </code> with the image icon's height
     */
    public int getHeight() {
        return imiIcon.getIconHeight();
    }
    
    /**
     * marginContainer
     * 
     * Makes this object remain inside the applet
     * 
     * @param iTopX is an <code> int </code> with the upper point's x coordinate
     * @param iTopY is an <code> int </code> with the upper point's y coordinate
     * @param iBottomX an <code> int </code> with the lower point's x coordinate
     * @param iBottomY an <code> int </code> with the lower point's y coordinate
     */
    public void marginContainer(int iTopX, int iTopY, int iBottomX, 
            int iBottomY) {
        // Check for object's x-coordinate
        if (leftMarginCheck(iTopX)) {
            setIPosX(iTopX + 1);
        }
        else if (rightMarginCheck(iBottomX)) {
            setIPosX(iBottomX - getWidth() - 1);
        }
        // Check for object's y-coordinate
        if (topMarginCheck(iTopY)) {
            setIPosY(iTopY + 1);
        }
        else if (bottomMarginCheck(iBottomY)) {
            setIPosY(iBottomY - getHeight() - 1);
        }
    }
    
    /**
     * leftMarginCheck
     * 
     * Return true if object collides with the left applet margin
     * 
     * @param iLeft is an <code> int </code> with the reference point
     * @return a <code> boolean </code> if collision occurs
     */
    public boolean leftMarginCheck(int iLeft) {
        return iPosX < iLeft;
    }
    
    /**
     * rightMarginCheck
     * 
     * Return true if object collides with the right applet margin
     * 
     * @param iRight is an <code> int </code> with the reference point
     * 
     * @return a <code> boolean </code> if collision occurs
     */
    public boolean rightMarginCheck(int iRight) {
        return (iPosX + getWidth()) > iRight;
    }
    
    /**
     * topMarginCheck
     * 
     * Return true if object collides with the top applet margin
     * 
     * @param iTop is an <code> int </code> with the reference point
     * 
     * @return a <code> boolean </code> if collision occurs
     */
    public boolean topMarginCheck(int iTop) {
        return iPosY < iTop;
    }
    
    /**
     * bottomMarginCheck
     * 
     * Return true if object collides with the bottom applet margin
     * 
     * @param iBottom is an <code> int </code> with the reference point
     * @return a <code> boolean </code> if collision occurs
     */
    public boolean bottomMarginCheck(int iBottom) {
        return (iPosY + getHeight()) > iBottom;
    }
    
    /**
     * paint
     * 
     * Paints the object
     * 
     * @param graGraphic is an object from <code> Graphics </code> 
     * used for painting
     * @param imoObserver is an object from <code> ImageObserver </code>
     * used for painting the object in an applet
     */
    public void paint(Graphics graGraphic, ImageObserver imoObserver) {
        graGraphic.drawImage(getImage(), getIPosX(), getIPosY(), imoObserver);
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
    public abstract boolean intersectsRight(Object objParameter);
    
    /**
     * intersectsLeft
     * 
     * Checks if this instance's left side intersects with another instace
     * 
     * @param objParameter is the <code> Object </code> to which we want to know
     * if an intersection occurs
     * @return a <code> boolean </code> if an intersection exists
     */
    public abstract boolean intersectsLeft(Object objParameter);
    
    /**
     * intersectsTop
     * 
     * Checks if this instance's top side intersects with another instace
     * 
     * @param objParameter is the <code> Object </code> to which we want to know
     * if an intersection occurs
     * @return a <code> boolean </code> if an intersection exists
     */
    public abstract boolean intersectsTop(Object objParameter);
    
    /**
     * intersectsBottom
     * 
     * Checks if this instance's bottom side intersects with another instace
     * 
     * @param objParameter is the <code> Object </code> to which we want to know
     * if an intersection occurs
     * @return a <code> boolean </code> if an intersection exists
     */
    public abstract boolean intersectsBottom(Object objParameter);
}
