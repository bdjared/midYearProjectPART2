import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dart extends Projectile
{
    public boolean hits;
    /**
     * Act - do whatever the Dart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Dart(){
        getImage().scale(35,35);
    }
    
    public void act() 
    {
        for (int i = 0; i < 200; i++){
            move(-1);
        }
        
        getWorld().removeObject(this);
        
    }    
}
