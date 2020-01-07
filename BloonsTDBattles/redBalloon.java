import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class red_balloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class redBalloon extends Balloon
{
    public int speed = 3;
    /**
     * Act - do whatever the red_balloon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public redBalloon() {
        super(5);
    }
    public void act() 
    {
      lizzo(speed);
    }
    public void lizzo(int speed){
        
        if(!isAtEdge()){
            if(this.getX() < 250 && this.getY()<200){
                setRotation(0);
//                
            }
            else if(this.getY() < 250 && this.getX() < 300){
                setRotation(90);
            }
            else if(this.getX() <400 && this.getY()>200){
                setRotation(0);
            }
            else if(this.getX() > 400 && this.getY()>175 && this.getX() < 525){
                setRotation(270);
            }
            else if(this.getX()<550 ){
                setRotation(0);
            }
            else{
                setRotation(90);
            }
            move(speed);
        }
        
        else{
           getWorld().removeObject(this);
        }
    }    
}
