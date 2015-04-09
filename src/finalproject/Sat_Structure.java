/**
 * Sat_Structure
 * 
 * Class used to represent each structure of a dungeon
 * 
 * @author Marco Antonio Peyrot
 */
package finalproject;

public class Sat_Structure extends Sat_VisualObject {

    /**
     * Sat_Structure
     * 
     * Only constructor used to create a dungeon structure
     */
    Sat_Structure() {
        // Initial position
        iPosX = 179;
        iPosY = 20;
        // Structure must be painted
        bPaint = true;
        iLastIPosX = 179;
        iLastIPosY = 95;
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
        return false;
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
