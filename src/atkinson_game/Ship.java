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


public class Ship {
    private Image image = null;
    private double height;
    private double width;
    private double x;
    private double y;
    public Ship(double xC, double yC){
        this.x = xC;
        this.y = yC;
    }
    public void render (GraphicsContext gc) {
        gc.drawImage(image, x, y);
    }
    public void setImage(Image i) {
        this.image = i;
        this.height = i.getHeight();
        this.width = i.getWidth();
    }
    public void setImage(String fileName) {
        Image i = new Image(fileName);
        setImage(i);
    }
    public void move(double dX, double dY){
        this.x += dX;
        this.y += dY;
    }
    public double getX() {
        return this.x;
    }
    public void setX(double newX) {
        this.x = newX;
    }
    public double getY() {
        return this.y;
    }
    public void setY(double newY) {
        this.y = newY;
    }
    public double getHeight() {
        return this.height;
    }
    public double getWidth() {
        return this.width;
    }
    public boolean hasImage() {
        return image != null;
    }
}
