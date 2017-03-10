/*******************************************************************************
 * Program Filename:    .java
 * Author:              Atkinson, Daniel
 * Date:                
 * Description:         
 * Input:               
 * Output:              
 ******************************************************************************/

package atkinson_game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class Progress {
    Image bar = new Image("bar.png");
    Image ship = new Image("ship.png");
    double shipProg = 12;
    public Progress() {
        
    }
    public boolean winner() {
        return shipProg > 1012;
    }
    public void advance() {
        shipProg += .25;
        if(shipProg > 1013) shipProg = 1013;
    }
    public void render(GraphicsContext gc){
        gc.drawImage(bar, 0, 0);
        gc.drawImage(ship, shipProg, -5);
    }
}
