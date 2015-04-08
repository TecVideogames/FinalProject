/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finalproject;

/**
 *
 * @author Marco Antonio Peyrot
 */
public class Sat_Structure extends Sat_VisualObject{
    
    Sat_Structure() {
        iPosX = 179;
        iPosY = 95;
        bPaint = true;
        iLastIPosX = 179;
        iLastIPosY = 95;
    }

    @Override
    public boolean pointerInside(int iPosX, int iPosY) {
        return false;
    }

    @Override
    public boolean intersectsRight(Object objParameter) {
        return false;
    }

    @Override
    public boolean intersectsLeft(Object objParameter) {
        return false;
    }

    @Override
    public boolean intersectsTop(Object objParameter) {
        return false;
    }

    @Override
    public boolean intersectsBottom(Object objParameter) {
        return false;
    }

    @Override
    public boolean intersects(Object objParameter) {
        return false;
    }
    
}
