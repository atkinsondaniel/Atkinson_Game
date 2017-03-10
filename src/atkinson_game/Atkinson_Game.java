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
    static boolean colorSelected = false;
    static boolean winner = false;
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
        ShipChunk chunk1 = new ShipChunk(0,0);
        ShipChunk chunk2 = new ShipChunk(0,0);
        ShipChunk chunk3 = new ShipChunk(0,0);
        ShipChunk chunk4 = new ShipChunk(0,0);
        Progress progress = new Progress();
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
        ArrayList<String> input = new ArrayList<>();
        Image i = new Image("bg.jpg");
        gc.drawImage(i, 0, 0);
        Font font = Font.font( "Helvetica", FontWeight.BOLD, 24 );
        gc.setFont( font );
        gc.setLineWidth(1);
        gc.setStroke(Color.ORANGE);
        gc.setFill(Color.ORANGE);
        
        gc.fillText("Dodge the Enemy Ship's Onslaught", 320, 40);
        gc.strokeText("Dodge the Enemy Ship's Onslaught", 320, 40);
        gc.fillText("Until Your Reinforcements Arive", 340, 70);
        gc.strokeText("Until Your Reinforcements Arive", 340, 70);
        gc.fillText("Select Your Spaceship Color", 350, 960);
        gc.strokeText("Select Your Spaceship Color", 350, 960);
        gc.fillText("Click Here to Exit", 400, 1000);
        gc.strokeText("Click Here to Exit", 400, 1000);
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
                    chunk1.setImage("pSC1.png");
                    chunk2.setImage("pSC2.png");
                    chunk3.setImage("pSC3.png");
                    chunk4.setImage("pSC4.png");
                } else if (red.contains(e.getX(), e.getY())) {
                    player.setColor("redShip.png");
                    chunk1.setImage("rSC1.png");
                    chunk2.setImage("rSC2.png");
                    chunk3.setImage("rSC3.png");
                    chunk4.setImage("rSC4.png");
                } else if (green.contains(e.getX(), e.getY())) {
                    player.setColor("greenShip.png");
                    chunk1.setImage("gSC1.png");
                    chunk2.setImage("gSC2.png");
                    chunk3.setImage("gSC3.png");
                    chunk4.setImage("gSC4.png");
                } else if (blue.contains(e.getX(), e.getY())) {
                    player.setColor("blueShip.png");
                    chunk1.setImage("bSC1.png");
                    chunk2.setImage("bSC2.png");
                    chunk3.setImage("bSC3.png");
                    chunk4.setImage("bSC4.png");
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
        
        BulletHandler handler = new BulletHandler(enemy);
        final long startNanoTime = System.nanoTime();
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                if (winner) {
                    gc.clearRect(0,0,1024,1024);
                    enemy.move(player.getX(), ((Math.random()-.5)*5));
                    gc.drawImage(i, 0, 0);
                    enemy.render(gc);
                    player.render(gc);
                    gc.strokeText("Reinforcements Have Arrived!", 350, 450);
                    gc.fillText("Reinforcements Have Arrived!", 350, 450);
                } else if (gameStart) {
                    double t = (currentNanoTime - startNanoTime) / 1000000000.0;
                    
                    player.move(input);
                    enemy.move(player.getX(), ((Math.random()-.5)*5));
                    gc.clearRect(0, 0, 1024,1024);
                    gc.drawImage(i, 0, 0);
                    enemy.render(gc);
                    player.render(gc);
                    progress.advance();
                    progress.render(gc);
                    winner = progress.winner();
                    if (!handler.fire(gc, player, enemy, root)) {
                        gameStart = false;
                        chunk1.setAngle(Math.random()*2*Math.PI);
                        chunk2.setAngle(Math.random()*2*Math.PI);
                        chunk3.setAngle(Math.random()*2*Math.PI);
                        chunk4.setAngle(Math.random()*2*Math.PI);
                        chunk1.setX(player.getX());
                        chunk2.setX(player.getX());
                        chunk3.setX(player.getX());
                        chunk4.setX(player.getX());
                        chunk1.setY(player.getY());
                        chunk2.setY(player.getY());
                        chunk3.setY(player.getY());
                        chunk4.setY(player.getY());
                    }                   
                }else if(colorSelected){
                    gc.clearRect(0,0,1024,1024);
                    enemy.move(player.getX(), ((Math.random()-.5)*5));
                    chunk1.split();
                    chunk2.split();
                    chunk3.split();
                    chunk4.split();                   
                    gc.drawImage(i, 0, 0);
                    chunk1.render(gc);
                    chunk2.render(gc);
                    chunk3.render(gc);
                    chunk4.render(gc);
                    enemy.render(gc);
                    progress.render(gc);
                    handler.fire(gc, player, enemy, root);
                    gc.strokeText("You Have Failed", 420, 500);
                    gc.fillText("You Have Failed", 420, 500);
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
