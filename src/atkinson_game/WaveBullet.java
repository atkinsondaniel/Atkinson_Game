/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atkinson_game;

/**
 *
 * @author danielatkinson
 */
public class WaveBullet extends CircleBullet{
    private boolean shooting;
    public WaveBullet(double nX, double nY) {
        super(nX, nY);
    }
    
    public void shoot() {
        super.shoot(3*Math.cos(getAngle()),3*Math.abs(Math.sin(getAngle()))+Math.sin(Math.PI/4));
        setAngle(this.getAngle()-Math.PI/512);
    }
    @Override
    public int getFrames() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void setFrames(int frames) {
        
    }

    @Override
    public boolean isShooting() {
        return shooting;
    }

    @Override
    public void setShooting(boolean shoot) {
        this.shooting = shoot;
    }
    
}
