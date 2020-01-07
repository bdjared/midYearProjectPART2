import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cannonball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cannonball extends Projectile
{
    public boolean hits;
    
    public Cannonball() {
        getImage().scale(30,30);
    }
    
    
    public void act() 
    {
        for (int i = 0; i<10; i++) {
            move(15); 
            if (getWorld() != null && isTouching(Balloon.class)) {
                getImage().scale(90,90);
                getWorld().removeObject(this);
            }
        }
        if (getWorld() != null) {
            getWorld().removeObject(this);
        }
    }    
}
