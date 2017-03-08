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
    public BulletHandler(EnemyShip enemy) {
        buildBullets(enemy);
    }
    public void fire(GraphicsContext gc, PlayerShip player, EnemyShip enemy, Group root) {
        
//        bullets.forEach((bullet) -> {
//            if(bullet.type().equals("regBullet")) {
//                if(bullet.isShooting()) {
//                    bullet.shoot(enemy.getX()+40, enemy.getY()+200);
//                } else {
//                    if(bullet.getFrames() > 30) {
//                        bullet.setShooting(true);
//                        bullet.setFrames(0);
//                    } else {
//                        bullet.setFrames(bullet.getFrames()+1);
//                    }
//                } 
//                
//            }
//            bullet.render(gc); 
//        });
        fireRegs(gc, player, enemy, root);
        collision(player);
    }
    private void buildBullets(EnemyShip enemy) {       
        RegBullet reg1 = new RegBullet(enemy.getX()+40, enemy.getY()+200);
        RegBullet reg2 = new RegBullet(enemy.getX()+40, enemy.getY()+200);
        RegBullet reg3 = new RegBullet(enemy.getX()+40, enemy.getY()+200);
        regBullets.add(reg1);
        regBullets.add(reg2);
        regBullets.add(reg3);

        int frames = 0;
        for(RegBullet reg: regBullets) {
            reg.setImage("regBullet.png");
            reg.setFrames(frames);
            frames += 20;
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
    }

}
