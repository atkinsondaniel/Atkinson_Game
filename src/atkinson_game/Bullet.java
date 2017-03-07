/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atkinson_game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

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
//    public void Bullet(double nX, double nY) {
//        this.x = nX;
//        this.y = nY;
//    }
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
    public void shoot(double dX, double dY) {
        this.x += dX;
        this.y += dY;
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
}
