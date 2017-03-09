/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atkinson_game;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author danielatkinson
 */
public abstract class Bullet {
    private Image image;
    private double x;
    private double y;
    private double height;
    private double width;
    private Circle hitbox;
    public void Bullet(double nX, double nY) {
        this.x = nX;
        this.y = nY;
   }
    public void render (GraphicsContext gc) {
        gc.drawImage(image, x, y);       
        
    }
    public void setImage(Image i) {
        this.image = i;
        this.height = i.getHeight();
        this.width = i.getWidth();
        this.hitbox = new Circle();
        this.hitbox.setCenterX(x+width/2);
        this.hitbox.setCenterY(y+height/2);
        this.hitbox.setRadius((width/2+height/2)/2 - 15);
    }
    public void setImage(String fileName) {
        Image i = new Image(fileName);
        setImage(i);
    }
    public void shoot(double dX, double dY) {
        this.x += dX;
        this.y += dY;
        this.hitbox.setCenterX(x+width/2 + dX);
        this.hitbox.setCenterY(y+height/2 + dY);
    }
    public void setX(double newX) {
        this.x = newX;
    }
    public void setY(double newY) {
        this.y = newY;
    }
    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    public double getHeight() {
        return this.height;
    }
    public double getWidth() {
        return this.width;
    }
    public String type() {
        return "wrong";
    }
    public Circle getHitbox() {
        return this.hitbox;
    }
    public void drawHitbox(Group root, GraphicsContext gc) {
        hitbox.setFill(Color.BLUE);
        if(root.getChildren().contains(hitbox) ) {
             root.getChildren().remove(hitbox);
        }
        root.getChildren().add(hitbox);       
    }
    
    public abstract int getFrames();
    public abstract void setFrames(int frames);
    public abstract boolean isShooting();
    public abstract void setShooting(boolean shoot);
    
}
