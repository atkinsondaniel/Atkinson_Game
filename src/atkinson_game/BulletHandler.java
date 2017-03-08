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
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;


public class BulletHandler {
    ArrayList<RegBullet> regBullets = new ArrayList<>();
    ArrayList<CircleBullet> circleBullets = new ArrayList<>();
    int fireCounter = 0;
    boolean firstCircFire = false;
    public BulletHandler(EnemyShip enemy) {
        buildBullets(enemy);
    }
    public void fire(GraphicsContext gc, PlayerShip player, EnemyShip enemy, Group root) {
        if (fireCounter % 500 == 0) {
            firstCircFire = true;
        }    
        
        fireCircles(gc,player,enemy,root);
        fireRegs(gc, player, enemy, root);
            
        fireCounter++;
        collision(player);
    }
    private void buildBullets(EnemyShip enemy) {       
        RegBullet reg1 = new RegBullet(enemy.getX()+40, enemy.getY()+200);
        RegBullet reg2 = new RegBullet(enemy.getX()+40, enemy.getY()+200);
        RegBullet reg3 = new RegBullet(enemy.getX()+40, enemy.getY()+200);
        regBullets.add(reg1);
        regBullets.add(reg2);
        regBullets.add(reg3);
        CircleBullet circle1 = new CircleBullet(enemy.getX()+40, enemy.getY()+200);
        CircleBullet circle2 = new CircleBullet(enemy.getX()+40, enemy.getY()+200);
        CircleBullet circle3 = new CircleBullet(enemy.getX()+40, enemy.getY()+200);
        CircleBullet circle4 = new CircleBullet(enemy.getX()+40, enemy.getY()+200);
        CircleBullet circle5 = new CircleBullet(enemy.getX()+40, enemy.getY()+200);
        CircleBullet circle6 = new CircleBullet(enemy.getX()+40, enemy.getY()+200);
        CircleBullet circle7 = new CircleBullet(enemy.getX()+40, enemy.getY()+200);
        CircleBullet circle8 = new CircleBullet(enemy.getX()+40, enemy.getY()+200);
        CircleBullet circle9 = new CircleBullet(enemy.getX()+40, enemy.getY()+200);
        CircleBullet circle10 = new CircleBullet(enemy.getX()+40, enemy.getY()+200);
        CircleBullet circle11 = new CircleBullet(enemy.getX()+40, enemy.getY()+200);
        CircleBullet circle12 = new CircleBullet(enemy.getX()+40, enemy.getY()+200);
        CircleBullet circle13 = new CircleBullet(enemy.getX()+40, enemy.getY()+200);
        CircleBullet circle14 = new CircleBullet(enemy.getX()+40, enemy.getY()+200);
        CircleBullet circle15 = new CircleBullet(enemy.getX()+40, enemy.getY()+200);
        circleBullets.add(circle1);
        circleBullets.add(circle2);
        circleBullets.add(circle3);
        circleBullets.add(circle4);
        circleBullets.add(circle5);
        circleBullets.add(circle6);
        circleBullets.add(circle7);
        circleBullets.add(circle8);
        circleBullets.add(circle9);
        circleBullets.add(circle10);
        circleBullets.add(circle11);
        circleBullets.add(circle12);
        circleBullets.add(circle13);
        circleBullets.add(circle14);
        circleBullets.add(circle15);
        int frames = 0;
        double angle = 2*Math.PI;
        for(RegBullet reg: regBullets) {
            reg.setImage("regBullet.png");
            reg.setFrames(frames);
            frames += 20;
        }
        for(CircleBullet circ: circleBullets) {
            circ.setImage("circleBullet.png");
            circ.setAngle(angle);
            angle -= Math.PI/15 * 2;
        }
    }

    private void fireRegs(GraphicsContext gc, PlayerShip player, EnemyShip enemy, Group root) {
        regBullets.forEach((reg) -> {
            if(reg.isShooting()) {
                reg.shoot(enemy.getX()+40, enemy.getY()+200);
                reg.render(gc);            
            } else {
                if (reg.getFrames() < 0) {
                    reg.setShooting(true);
                    reg.setFrames(60);
                }
                else {
                    reg.setFrames(reg.getFrames()-1);
                }
            }
        });
    }
    private void collision(PlayerShip player) {
        for(RegBullet reg: regBullets) {
            if (player.getHitBox().intersects(reg.getHitbox().getBoundsInLocal())) {
                Platform.exit();
                System.exit(0);
            }
        }
        for(CircleBullet circ: circleBullets) {
            if (player.getHitBox().intersects(circ.getHitbox().getBoundsInLocal())) {
                Platform.exit();
                System.exit(0);
            }
        }
    }

    private void fireCircles(GraphicsContext gc, PlayerShip player, EnemyShip enemy, Group root) {
        if(firstCircFire) {
            firstCircFire = false;
            circleBullets.forEach((circ) -> {
            circ.setX(enemy.getX()+40);
            circ.setY(enemy.getY()+200);
        });
        }
        circleBullets.forEach((circ) -> {
            circ.shoot();
            circ.render(gc);            
        });
    }

    private boolean circlesFiring() {
       boolean firing = false;
       for(CircleBullet circ: circleBullets) {
            if (circ.isShooting()) {
                firing = true;
            }
        }
       return firing;
    }
    private boolean regsFiring() {
       boolean firing = false;
       for(RegBullet reg: regBullets) {
            if (reg.isShooting()) {
                firing = true;
            }
        }
       return firing;
    }

}
