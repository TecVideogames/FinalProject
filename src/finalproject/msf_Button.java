package finalproject;

import java.awt.Rectangle;

public class msf_Button extends Sat_VisualObject {

    public msf_Button(int iX, int iY, int iWidth, int iHeight, String strImage) {
        startPos(iX, iY);
        this.setImageIcon(strImage, iWidth, iHeight);
    }

    @Override
    public boolean pointerInside(int iPosX, int iPosY) {
        // Create container figure
        Rectangle.Float recThis = new Rectangle.Float(this.getIPosX(),
                this.getIPosY(), this.getWidth(), this.getHeight());
        
        return recThis.contains(iPosX, iPosY);
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
