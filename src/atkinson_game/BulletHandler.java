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
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class BulletHandler {

    ArrayList<RegBullet> regBullets = new ArrayList<>();
    ArrayList<CircleBullet> circleBullets = new ArrayList<>();
    ArrayList<SpiralBullet> spiralBullets = new ArrayList<>();
    ArrayList<WaveBullet> waveBullets = new ArrayList<>();
    int fireCounter = 1;
    boolean firstCircFire = false;
    boolean firstSpirFire = false;
    boolean firstWaveFire = false;

    public BulletHandler(EnemyShip enemy) {
        buildBullets(enemy);
    }

    public void fire(GraphicsContext gc, PlayerShip player, EnemyShip enemy, Group root) {
        if (fireCounter % 500 == 0) {
            firstCircFire = true;
        }
        if (fireCounter % 1250 == 0) {
            firstSpirFire = true;
        }
        if (fireCounter % 750 == 0) {
            firstWaveFire = true;
        }
        if(spiralsFiring()) 
            fireSpirals(gc, player, enemy, root);
        if(circlesFiring()) fireCircles(gc, player, enemy, root);
        if(wavesFiring()) fireWaves(gc, player, enemy, root);
        fireRegs(gc, player, enemy, root);
        gc.setStroke(Color.WHITE);
        gc.strokeText("" + fireCounter, 100, 100);
        fireCounter++;
        collision(player);
    }

    private void buildBullets(EnemyShip enemy) {
        RegBullet reg1 = new RegBullet(enemy.getX() + 40, enemy.getY() + 200);
        RegBullet reg2 = new RegBullet(enemy.getX() + 40, enemy.getY() + 200);
        RegBullet reg3 = new RegBullet(enemy.getX() + 40, enemy.getY() + 200);
        regBullets.add(reg1);
        regBullets.add(reg2);
        regBullets.add(reg3);
        CircleBullet circle1 = new CircleBullet(enemy.getX() + 40, enemy.getY() + 200);
        CircleBullet circle2 = new CircleBullet(enemy.getX() + 40, enemy.getY() + 200);
        CircleBullet circle3 = new CircleBullet(enemy.getX() + 40, enemy.getY() + 200);
        CircleBullet circle4 = new CircleBullet(enemy.getX() + 40, enemy.getY() + 200);
        CircleBullet circle5 = new CircleBullet(enemy.getX() + 40, enemy.getY() + 200);
        CircleBullet circle6 = new CircleBullet(enemy.getX() + 40, enemy.getY() + 200);
        CircleBullet circle7 = new CircleBullet(enemy.getX() + 40, enemy.getY() + 200);
        CircleBullet circle8 = new CircleBullet(enemy.getX() + 40, enemy.getY() + 200);
        CircleBullet circle9 = new CircleBullet(enemy.getX() + 40, enemy.getY() + 200);
        CircleBullet circle10 = new CircleBullet(enemy.getX() + 40, enemy.getY() + 200);
        CircleBullet circle11 = new CircleBullet(enemy.getX() + 40, enemy.getY() + 200);
        CircleBullet circle12 = new CircleBullet(enemy.getX() + 40, enemy.getY() + 200);
        CircleBullet circle13 = new CircleBullet(enemy.getX() + 40, enemy.getY() + 200);
        CircleBullet circle14 = new CircleBullet(enemy.getX() + 40, enemy.getY() + 200);
        CircleBullet circle15 = new CircleBullet(enemy.getX() + 40, enemy.getY() + 200);
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
        SpiralBullet spiral1 = new SpiralBullet(enemy.getX() + 40, enemy.getY() + 100);
        SpiralBullet spiral2 = new SpiralBullet(enemy.getX() + 40, enemy.getY() + 100);
        SpiralBullet spiral3 = new SpiralBullet(enemy.getX() + 40, enemy.getY() + 100);
        SpiralBullet spiral4 = new SpiralBullet(enemy.getX() + 40, enemy.getY() + 100);
        SpiralBullet spiral5 = new SpiralBullet(enemy.getX() + 40, enemy.getY() + 100);
        SpiralBullet spiral6 = new SpiralBullet(enemy.getX() + 40, enemy.getY() + 100);
        SpiralBullet spiral7 = new SpiralBullet(enemy.getX() + 40, enemy.getY() + 100);
        SpiralBullet spiral8 = new SpiralBullet(enemy.getX() + 40, enemy.getY() + 100);
        SpiralBullet spiral9 = new SpiralBullet(enemy.getX() + 40, enemy.getY() + 100);
        SpiralBullet spiral10 = new SpiralBullet(enemy.getX() + 40, enemy.getY() + 100);
        SpiralBullet spiral11 = new SpiralBullet(enemy.getX() + 40, enemy.getY() + 100);
        SpiralBullet spiral12 = new SpiralBullet(enemy.getX() + 40, enemy.getY() + 100);
        SpiralBullet spiral13 = new SpiralBullet(enemy.getX() + 40, enemy.getY() + 100);
        SpiralBullet spiral14 = new SpiralBullet(enemy.getX() + 40, enemy.getY() + 100);
        SpiralBullet spiral15 = new SpiralBullet(enemy.getX() + 40, enemy.getY() + 100);
        spiralBullets.add(spiral1);
        spiralBullets.add(spiral2);
        spiralBullets.add(spiral3);
        spiralBullets.add(spiral4);
        spiralBullets.add(spiral5);
        spiralBullets.add(spiral6);
        spiralBullets.add(spiral7);
        spiralBullets.add(spiral8);
        spiralBullets.add(spiral9);
        spiralBullets.add(spiral10);
        spiralBullets.add(spiral11);
        spiralBullets.add(spiral12);
        spiralBullets.add(spiral13);
        spiralBullets.add(spiral14);
        spiralBullets.add(spiral15);
        WaveBullet wave1 = new WaveBullet(enemy.getX() + 40, enemy.getY() + 100);
        WaveBullet wave2 = new WaveBullet(enemy.getX() + 40, enemy.getY() + 100);
        WaveBullet wave3 = new WaveBullet(enemy.getX() + 40, enemy.getY() + 100);
        WaveBullet wave4 = new WaveBullet(enemy.getX() + 40, enemy.getY() + 100);
        WaveBullet wave5 = new WaveBullet(enemy.getX() + 40, enemy.getY() + 100);
        WaveBullet wave6 = new WaveBullet(enemy.getX() + 40, enemy.getY() + 100);
        WaveBullet wave7 = new WaveBullet(enemy.getX() + 40, enemy.getY() + 100);
        WaveBullet wave8 = new WaveBullet(enemy.getX() + 40, enemy.getY() + 100);
        WaveBullet wave9 = new WaveBullet(enemy.getX() + 40, enemy.getY() + 100);
        WaveBullet wave10 = new WaveBullet(enemy.getX() + 40, enemy.getY() + 100);
        waveBullets.add(wave1);
        waveBullets.add(wave2);
        waveBullets.add(wave3);
        waveBullets.add(wave4);
        waveBullets.add(wave5);
        waveBullets.add(wave6);
        waveBullets.add(wave7);
        waveBullets.add(wave8);
        waveBullets.add(wave9);
        waveBullets.add(wave10);
        int frames = 0;
        double circAngle = 2 * Math.PI;
        double spirAngle = 2 * Math.PI;
        double waveAngle = 0;
        for (RegBullet reg : regBullets) {
            reg.setImage("regBullet.png");
            reg.setFrames(frames);
            frames += 20;
        }
        for (CircleBullet circ : circleBullets) {
            circ.setImage("circleBullet.png");
            circ.setAngle(circAngle);
            circAngle -= Math.PI / 15 * 2;
        }
        for (SpiralBullet spir : spiralBullets) {
            spir.setImage("spiralBullet.png");
            spir.setAngle(spirAngle);
            spirAngle -= Math.PI / 15 * 2;
        }
        for (WaveBullet wave : waveBullets) {
            wave.setImage("waveBullet.png");
            wave.setAngle(waveAngle);
            waveAngle += Math.PI / 10 * 2;
        }
    }

    private void fireRegs(GraphicsContext gc, PlayerShip player, EnemyShip enemy, Group root) {
        regBullets.forEach((reg) -> {
            if (reg.isShooting()) {
                reg.shoot(enemy.getX() + 40, enemy.getY() + 200);
                reg.render(gc);
            } else {
                if (reg.getFrames() < 0) {
                    reg.setShooting(true);
                    reg.setFrames(60);
                } else {
                    reg.setFrames(reg.getFrames() - 1);
                }
            }
        });
    }

    private void collision(PlayerShip player) {
        for (RegBullet reg : regBullets) {
            if (reg.isShooting()) {
                if (player.getHitBox().intersects(reg.getHitbox().getBoundsInLocal())) {
                    Platform.exit();
                    System.exit(0);
                }
            }
        }
        for (CircleBullet circ : circleBullets) {
            if (circ.isShooting()) {
                if (player.getHitBox().intersects(circ.getHitbox().getBoundsInLocal())) {
                    Platform.exit();
                    System.exit(0);
                }
            }
        }
        for (SpiralBullet spir : spiralBullets) {
            if (spir.isShooting()) {                
                if (player.getHitBox().intersects(spir.getHitbox().getBoundsInLocal())) {
                    Platform.exit();
                    System.exit(0);
                }
            }
        }
        for (WaveBullet wave : waveBullets) {
            if (wave.isShooting()) {                
                if (player.getHitBox().intersects(wave.getHitbox().getBoundsInLocal())) {
                    Platform.exit();
                    System.exit(0);
                }
            }
        }
    }

    private void fireCircles(GraphicsContext gc, PlayerShip player, EnemyShip enemy, Group root) {
        if (firstCircFire) {
            firstCircFire = false;
            circleBullets.forEach((circ) -> {
                circ.setX(enemy.getX() + 40);
                circ.setY(enemy.getY() + 200);
                circ.setShooting(true);
            });
        }
        circleBullets.forEach((circ) -> {
            circ.shoot();
            circ.render(gc);
        });
    }
    private void fireWaves(GraphicsContext gc, PlayerShip player, EnemyShip enemy, Group root) {
        if (firstWaveFire) {
            firstWaveFire = false;
            waveBullets.forEach((wave) -> {
                wave.setX(enemy.getX() + 40);
                wave.setY(enemy.getY() + 200);
                wave.setShooting(true);
            });
        }
        waveBullets.forEach((wave) -> {
            wave.shoot();
            wave.render(gc);
        });
    }
    private void fireSpirals(GraphicsContext gc, PlayerShip player, EnemyShip enemy, Group root) {
        if (firstSpirFire) {
            firstSpirFire = false;
            spiralBullets.forEach((spir) -> {
                spir.setX(enemy.getX() + 40);
                spir.setY(enemy.getY() + 100);
                spir.resetRadius();
                spir.setShooting(true);
            });
        }
        for (SpiralBullet spir : spiralBullets) {
            spir.shoot();
            spir.render(gc);
        }
        
    }
    private boolean circlesFiring() {
        boolean firing = false;
        for (CircleBullet circ : circleBullets) {
            if (circ.isShooting() || firstCircFire) {
                firing = true;
            }
        }
        return firing;
    }


    private boolean spiralsFiring() {
        boolean firing = false;
        for (SpiralBullet spir : spiralBullets) {
            if (spir.isShooting() || firstSpirFire) {
                firing = true;
            }
        }
        return firing;
    }
    private boolean wavesFiring() {
        boolean firing = false;
        for (WaveBullet wave : waveBullets) {
            if (wave.isShooting() || firstWaveFire) {
                firing = true;
            }
        }
        return firing;
    }
}
