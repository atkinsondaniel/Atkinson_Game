/** *****************************************************************************
 * Program Filename:    .java
 * Author:              Atkinson, Daniel
 * Date:
 * Description:
 * Input:
 * Output:
 ***************************************************************************** */
package atkinson_game;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Daniel Atkinson
 */
public class Atkinson_Game extends Application {
    static boolean gameStart = false;
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("v 0.1");
        Group root = new Group();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        Canvas canvas = new Canvas(1024, 1024);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        
        EnemyShip enemy = new EnemyShip(canvas.getWidth() / 2, canvas.getHeight() / 8);
        enemy.setImage("enemy.png");
        PlayerShip player = new PlayerShip(100,700);
        Rectangle purp = new Rectangle(100,100,412,412);
        purp.setFill(Color.PURPLE);
        Rectangle red = new Rectangle(512,100,412,412);
        red.setFill(Color.RED);
        Rectangle green = new Rectangle(100,512,412,412);
        green.setFill(Color.GREEN);
        Rectangle blue = new Rectangle(512,512,412,412);
        blue.setFill(Color.BLUE);
                
        root.getChildren().add(purp);
        root.getChildren().add(red);
        root.getChildren().add(green);
        root.getChildren().add(blue);
        
        Font font = Font.font( "Helvetica", FontWeight.BOLD, 24 );
        gc.setFont( font );
        gc.setLineWidth(1);
        gc.setStroke(Color.ORANGE);
        gc.setFill(Color.ORANGE);
        gc.fillText("What Color Spaceship?", 380, 50);
        gc.strokeText("What Color Spaceship?", 380, 50);
        ArrayList<String> input = new ArrayList<>();
 
        scene.setOnKeyPressed((KeyEvent e) -> {
            String code = e.getCode().toString();
            
            if ( !input.contains(code) )
                input.add( code );
        });
 
        scene.setOnKeyReleased((KeyEvent e) -> {
            String code = e.getCode().toString();
            input.remove( code );
        });
        scene.setOnMouseClicked((MouseEvent e) -> {
            if (!player.hasImage()){
                if (purp.contains(e.getX(), e.getY())) {
                    player.setColor("purpleShip.png");
                } else if (red.contains(e.getX(), e.getY())) {
                    player.setColor("redShip.png");
                } else if (green.contains(e.getX(), e.getY())) {
                    player.setColor("greenShip.png");
                } else if (blue.contains(e.getX(), e.getY())) {
                    player.setColor("blueShip.png");
                } else {
                    Platform.exit();
                    System.exit(0);
                }
                root.getChildren().remove(purp);
                root.getChildren().remove(red);
                root.getChildren().remove(green);
                root.getChildren().remove(blue);
                gc.clearRect(0, 0, 1024, 1024);
                gameStart = true;
            }
        });
        
        RegBullet regBullet = new RegBullet(enemy.getX(),enemy.getY());
        regBullet.setImage("regBullet.jpg");
        final long startNanoTime = System.nanoTime();
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                if (gameStart) {
                    double t = (currentNanoTime - startNanoTime) / 1000000000.0;
                    player.move(input);
                    enemy.move(player.getX(), ((Math.random()-.5)*5));
                    gc.clearRect(0, 0, 1024,1024);
                    enemy.render(gc);
                    player.render(gc);
                    regBullet.render(gc);
                    regBullet.shoot(enemy.getX(), enemy.getY());
                    
                }
            }
        }.start();
        
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
