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
        super(10);
    }
    public void act() 
    {
        super.act(speed);
    }  
}
