import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class blueBalloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class blueBalloon extends Balloon
{
    public int speed = 4;
    /**
     * Act - do whatever the blueBalloon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public blueBalloon() {
        super(4);
    }
    public void act() 
    {
      super.act();
      lizzo(speed);
    }
    
    public void pop(){
        Balloon newBloon = new redBalloon();
        newBloon.distance = this.getDistance();
        getWorld().addObject(newBloon, getX(), getY());
        getWorld().removeObject(this);
    }
}
