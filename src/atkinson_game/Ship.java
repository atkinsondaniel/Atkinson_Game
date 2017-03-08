/*******************************************************************************
 * Program Filename:    .java
 * Author:              Atkinson, Daniel
 * Date:                
 * Description:         
 * Input:               
 * Output:              
 ******************************************************************************/

package atkinson_game;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;


public class Ship {
    private Image image = null;
    private double height;
    private double width;
    private double x;
    private double y;
    private Ellipse hitBox;
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
        hitBox = new Ellipse();
        this.hitBox.setCenterX(x+width/2);
        this.hitBox.setCenterY(y+height/2);
        this.hitBox.setRadiusX(width/2);
        this.hitBox.setRadiusY(height/2);       
    }
    public void setImage(String fileName) {
        Image i = new Image(fileName);
        setImage(i);
    }
    public void move(double dX, double dY){
        this.x += dX;
        this.y += dY;
        this.hitBox.setCenterX(x+width/2 + dX);
        this.hitBox.setCenterY(y+height/2 + dY);
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
    public void drawHitbox(Group root, GraphicsContext gc) {
        hitBox.setFill(Color.BLUE);
        if(root.getChildren().contains(hitBox) ) {
             root.getChildren().remove(hitBox);
        }
        root.getChildren().add(hitBox);       
    }
    public Ellipse getHitBox() {
        return hitBox;
    }
}
