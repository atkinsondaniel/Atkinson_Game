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
public class RegBullet extends Bullet {
    private static int framesSinceLastReg = 60;
    private boolean shooting;
    public RegBullet(double nX, double nY) {
        this.setX(nX);
        this.setY(nY);
    }
    public void shoot(double x, double y) {
        super.shoot(0,5);
        if(getY() > 1024 - getHeight()) {
            shooting = false;
            setX(x);
            setY(y);
        }       
    }
    @Override
    public String type(){
        return "regBullet";
    }
    @Override
    public int getFrames(){
        return framesSinceLastReg;
    }
    @Override
    public void setFrames(int frames){
        framesSinceLastReg = frames;
    }
    @Override
    public boolean isShooting(){
        return shooting;
    }
    @Override 
    public void setShooting(boolean shoot) {
        shooting = shoot;
    }
}
