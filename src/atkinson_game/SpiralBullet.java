/*******************************************************************************
 * Program Filename:    .java
 * Author:              Atkinson, Daniel
 * Date:                
 * Description:         
 * Input:               
 * Output:              
 ******************************************************************************/

package atkinson_game;


public class SpiralBullet extends CircleBullet{
    private double radius = 1;
    public SpiralBullet(double nX, double nY) {
        super(nX, nY);
    }
    @Override
    public void shoot() {
        super.shoot(radius*Math.cos(getAngle()),radius*Math.sin(getAngle()));
        radius -= .015;
        if(radius == 0) {
            radius -= .015;
        }
        setAngle(this.getAngle()-Math.PI/300);
        if(getY() > 1024 || getY() < 0 || getX() > 1024 || getX() < 0) {
            this.setShooting(false);
        }
    }
    public void resetRadius() {
        this.radius = 1;
    }
}
