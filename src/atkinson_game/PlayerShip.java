/*******************************************************************************
 * Program Filename:    .java
 * Author:              Atkinson, Daniel
 * Date:                
 * Description:         
 * Input:               
 * Output:              
 ******************************************************************************/

package atkinson_game;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;


public class PlayerShip extends Ship {
    public PlayerShip(float x, float y) {     
        super(x,y);
    }

    public void setColor(String fileName) {

        super.setImage(fileName);
    }
    public void move(ArrayList<String> input) {
        int dX = 0;
        int dY = 0;
        if (input.contains("W")) {
            dY -= 6;
        }
        if (input.contains("A")) {
            dX -= 6;
        }
        if (input.contains("S")) {
            dY += 6;
        }
        if (input.contains("D")) {
            dX += 6;
        }
        super.move(dX,dY);
        if (getX() < 0){
            setX(0);
        }
        if (getX() > 1024 - getWidth()){
            setX(1024 - getWidth());
        }
        if (getY() < 256){
            setY(256);
        }
        if (getY() > 1024 - getHeight()){
            setY(1024 - getHeight());
        }
    }
}
