import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Cannon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cannon extends Tower
{
    public int range = 13;
    public double attackDelay = 100;
    private List<Balloon> bloonsInRange;
    public Projectile projectileType;
    private Cannonball cannonball;

    
    public Cannon() {
        getImage().scale(1500,1500);
    }
       
    /**
     * Act - do whatever the Cannon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        bloonsInRange = super.findBalloons(range);
        Collections.sort(bloonsInRange); 
        if (!bloonsInRange.isEmpty()) {
            aim();
            if (attackDelay <= 0) {
                attack();
            }
        }
    }    
    public void aim() {
        Balloon target = bloonsInRange.get(0);
        turnTowards(target.getX(), target.getY());
        turn(90);
    }
    public void attack() {
        Balloon target = bloonsInRange.get(0);
        Cannonball cannonball = new Cannonball(getX(), getY());
        cannonball.turnTowards(target.getX(), target.getY());
        
}
}

