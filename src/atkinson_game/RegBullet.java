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

    public RegBullet(double nX, double nY) {
        this.setX(nX);
        this.setY(nY);
    }
    public void shoot(double x, double y) {
        super.shoot(0,10);
        if(getY() > 1024 - getHeight()) {
            setX(x);
            setY(y);
        }
    }
}
