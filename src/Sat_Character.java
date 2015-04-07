/**
 * Saturn086_Character
 * 
 * Abstract class that extends Saturn086_VisualObject and adds character 
 * interaction, behavior, and AI
 * 
 * @author Marco Antonio Peyrot A0815262
 * @version 1.0
 */

import java.applet.AudioClip;
import java.net.URL;

public abstract class Sat_Character extends Sat_VisualObject {
    protected int iLives; // Object's lives
    protected String strName; // Object's name
    protected int iSpeed; // Objects speed
    protected AudioClip aucSound; // Object's Audioclip
    protected URL urlSound; // Object's AudioClip's URL
    
    /**
     * setILives
     * 
     * Set object's life number
     * 
     * @param iLives is an <code> int </code> with the new life quantity
     */
    public void setILives(int iLives) {
        this.iLives = iLives;
    }
    
    /**
     * getILives
     * 
     * Get object's current life number
     * 
     * @return an <code> int </code> with the current life number
     */
    public int getILives() {
        return iLives;
    }
    
    /**
     * setStrName
     * 
     * Set object's name
     * 
     * @param strName is a <code> String </code> with the object's new name
     */
     public void setStrName(String strName) {
        this.strName = strName;
    }
    
     /**
      * getStrName
      * 
      * Get the object's name
      * 
      * @return a <code> String </code> with the object's name 
      */
    public String getStrName() {
        return strName;
    }
    
    /**
     * setSoundURL
     * 
     * Set object's sound URL
     * 
     * @param strURL is a <code> String </code> with the sound's URL
     */
    private void setSoundURL(String strURL) {
        this.urlSound = this.getClass().getResource(strURL);
    }
    
    /**
     * getSoundURL
     * 
     * Get object's sound URL
     * 
     * @return an <code> URL </code> which refrence's the object's sound URL
     */
    public URL getSoundURL() {
        return urlSound;
    }
    
    /**
     * setAudioClip
     * 
     * Set object's AudioClip
     * 
     * @param aucSound is an <code> AudioClip </code> which is used to assign
     * the object's AudioClip
     * @param strURL is a <code> String </code> which references the sound's URL 
     */
    public void setAudioClip(AudioClip aucSound, String strURL) {
        setSoundURL(strURL);
        this.aucSound = aucSound; 
    }
    
    /**
     * getSound
     * 
     * Get the object's AudioClip
     * 
     * @return an <code> AudioClip </code> with the object's AudioClip
     */
    public AudioClip getSound() {
        return aucSound;
    }

    /**
     * setBehavior
     * 
     * Set the object's new behavior
     * 
     * @param behavior  is an <code> ebehavior </code> which determines
     * the object's new behavior
     */
    public void setBehavior(eBehavior behavior) {
        this.behavior = behavior;
    }
    
    /**
     * getBehavior
     * 
     * Get the object's current behavior
     * 
     * @return an <code> eBehavior </code> with the object's current behavior
     */
    public eBehavior getBehavior() {
        return behavior;
    }
    
    /**
     * setISpeed
     * 
     * Set object's new speed
     * 
     * @param iSpeed is an <code> int </code> which specifies object's new speed
     */
    public void setISpeed(int iSpeed) {
        if(iSpeed >= 0) {
            this.iSpeed = iSpeed;
        }
        else {
            this.iSpeed = 0;
        }
    }
    
    /**
     * getISpeed
     * 
     * Get object's current speed
     * 
     * @return an <code> int </code> with the object's current speed
     */
    public int getISpeed() {
        return iSpeed;
    }
    
    /**
     * move
     * 
     * Abstract method used for AI and keyboard movement
     */
    public abstract void move();
    
    /**
     * moveMouse
     * 
     * Abstract method used for mouse movement
     * 
     * @param iPosX is an <code> int </code> with the pointer's x-coordinate
     * @param iPosY is an <code> int </code> with the pointer's y-coordinate
     */
    public abstract void moveMouse(int iPosX, int iPosY);
}
