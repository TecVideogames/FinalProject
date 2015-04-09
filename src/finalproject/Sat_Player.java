/**
 * Sat_Player
 
 Class that extends Saturn086_Character and implements all necessary functions
 for a human user to interact in a game
 * 
 * @author Marco Antonio Peyrot A0815262
 * @version 1.0
 */

package finalproject;

import java.awt.geom.Ellipse2D;

public class Sat_Player extends Sat_Character{

    // Object attributes
    private int iScore; // Player's score which are gained or lost as game runs
    
    /**
     * Saturn086_Player
     * 
     * Constructor
     */
    Sat_Player() {
        setStrName("Saturn086_Player");
        setIPosX(0);
        setIPosY(0);
        setILives(3);
        setISpeed(0);
        setImageIcon("ImageNotFound.jpg", 100, 100);
        setBehavior(eBehavior.STOP_RIGHT);
        setIScore(0);
    }
    
    /**
     * setIScore
     * 
     * Method for changing the player's score
     * 
     * @param iScore is an <code> int </code> with the new score
     */
    public void setIScore(int iScore) {
        this.iScore = iScore;
    }
    
    /**
     * getIScore
     * 
     * Method used to get the player's current score
     * 
     * @return an <code> int </code> with the score
     */
    public int getIScore() {
        return iScore;
    }
    
    /**
     * move
     * 
     * Method used for AI and keyboard movement
     */
    @Override
    public void move() {
        switch (behavior) {
            case MOVE_UP: { // Move up iSpeed pixels
                setIPosY(getIPosY() - iSpeed);
                break;    
            }
            case MOVE_DOWN: { // Move down iSpeed pixels
                setIPosY(getIPosY() + iSpeed);
                break;    
            }
            case MOVE_LEFT: { // Move left iSpeed pixels
                setIPosX(getIPosX() - iSpeed);
                break;    
            }
            case MOVE_RIGHT: { // Move right iSpeed pixels
                setIPosX(getIPosX() + iSpeed);
                break;    	
            }
        }
    }

    /**
     * moveMouse
     * 
     * Method used for mouse movement
     * 
     * @param iPosX is an <code> int </code> with the pointer's x-coordinate
     * @param iPosY is an <code> int </code> with the pointer's y-coordinate
     */
    @Override
    public void moveMouse(int iPosX, int iPosY) {
        // Check for x-coordinate
        if (iPosX - getIPosX() > iPointerDistX) {
            setIPosX(iPosX - iPointerDistX);
        }
        else if (iPosX - getIPosX() < iPointerDistX) {
            setIPosX(iPosX - iPointerDistX);
        }
        // Check for y-coordinate
        if (iPosY - getIPosY() > iPointerDistY) {
            setIPosY(iPosY - iPointerDistY);
        }
        else if (iPosY - getIPosY() < iPointerDistY) {
            setIPosY(iPosY - iPointerDistY);
        }
    }

    /**
     * pointerInside
     * 
     * Method that checks if mouse pointer is inside this object
     * 
     * @param iPosX is an <code> int </code> with the pointer's x-coordinate
     * @param iPosY is an <code> int </code> with the pointer's y-coordinate
     * @return a <code> boolean </code> if pointer is inside this object
     */
    @Override
    public boolean pointerInside(int iPosX, int iPosY) {
        // Create container figure
        Ellipse2D.Float ellThis = new Ellipse2D.Float(this.getIPosX(),
                this.getIPosY(), this.getWidth(), this.getHeight());
        
        return ellThis.contains(iPosX, iPosY);
    }

    /**
     * startPos
     * 
     * Method that determines where the object instance 
     * must appear in the applet
     * 
     * @param iWidth is an <code> int </code> with the applet's width
     * @param iHeight is an <code> int </code> with the applet's height
     */
    @Override
    public void startPos(int iWidth, int iHeight) {
        // Not implemented in this application
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
