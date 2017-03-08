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
public class CircleBullet extends Bullet{
    private boolean shooting;
    private double angle;
    @Override
    public int getFrames() {
        return 999;
    }
    public CircleBullet(double nX, double nY) {
        this.setX(nX);
        this.setY(nY);
    }
    public void shoot() {
        super.shoot(2*Math.cos(getAngle()),2*Math.sin(getAngle()));
        if(getY() > 1024 || getY() < 0 || getX() > 1024 || getX() < 0) {
            this.setShooting(false);
        }       
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

    public void setAngle(double nAngle) {
        this.angle = nAngle;
    }
    private double getAngle() {
        return this.angle;
    }
    
}
