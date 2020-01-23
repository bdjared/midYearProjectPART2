import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Path here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Path extends Actor
{
   
    /**
     * Constructor for objects of class Path.
     * 
     */
    
    
    public void act()
    {
        GreenfootImage art = new GreenfootImage(100,100);
        getWorld().getBackground().setColor(Color.BLACK);
        getWorld().getBackground().drawRect(0,44,280,60);
    }
}
