import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Superdart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Superdart extends Projectile{ 
    /**
     * Act - do whatever the Superdart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Superdart(){        
        super(10, 25, 3);
        getImage().scale(25,25);
    }
}
