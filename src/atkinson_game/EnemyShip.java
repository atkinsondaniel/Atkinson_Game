/*******************************************************************************
 * Program Filename:    .java
 * Author:              Atkinson, Daniel
 * Date:                
 * Description:         
 * Input:               
 * Output:              
 ******************************************************************************/

package atkinson_game;

import javafx.scene.image.Image;


public class EnemyShip extends Ship{
    private double maxY;
    private int lastYMove = 1;
    public EnemyShip(double x, double y) {
        super(x,y);
    }
    @Override
    public void move(double dX, double dY) {        
        if (dY < 0 && lastYMove == 1 && Math.random() > .05) {
            dY *= -1;
        }
        else if (dY > 0 && lastYMove == -1 && Math.random() > .05) {
            dY *= -1;
        }
        else if ((!(dY > 0 && lastYMove == 1) && !(dY < 0 && lastYMove == -1))) {
            lastYMove *= -1;
        }
        double diffX = dX - getX();
        super.move(diffX * .005,dY);
        if (getY() > maxY){
            setY(maxY);
            lastYMove = -1;
        }
        if (getY() < 0){
            setY(0);
            lastYMove = 1;
        }
    }
    @Override
    public void setImage(String fileName) {
        super.setImage(fileName);
        maxY = 300 - getHeight();
    }
}
