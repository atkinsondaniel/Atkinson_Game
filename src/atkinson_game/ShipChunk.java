/*******************************************************************************
 * Program Filename:    .java
 * Author:              Atkinson, Daniel
 * Date:                
 * Description:         
 * Input:               
 * Output:              
 ******************************************************************************/

package atkinson_game;


public class ShipChunk extends Ship{
    double angle;
    public ShipChunk(double xC, double yC) {
        super(xC, yC);
    }
     public void split(){
        super.move(.75*Math.cos(getAngle()),.75*Math.sin(getAngle()));
    }
    public double getAngle() {
        return this.angle;
    }
    public void setAngle(double nA) {
        this.angle = nA;
    }
}
