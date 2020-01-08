import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class greenBalloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class greenBalloon extends Balloon
{
    public int speed = 5;
    /**
     * Act - do whatever the blueBalloon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public greenBalloon() {
        super(5);
    }
    public void act() 
    {
      super.act();
      lizzo(speed);
    }
    
    public void pop(){
        Balloon newBloon = new blueBalloon();
        newBloon.distance = this.getDistance();
        getWorld().addObject(newBloon, getX(), getY());
        getWorld().removeObject(this);
    }
}
