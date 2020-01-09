import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Cannonball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cannonball extends Projectile
{
    public boolean hits;
    public int life = 40;
    public Cannonball() {
        getImage().scale(30,30);
    }
    
    
    public void act(){
        move(-7);        
        if (getWorld() != null && isTouching(Balloon.class)){
            getImage().scale(80, 80);
            if (isTouching(Balloon.class)){
                List<Balloon> targets = getIntersectingObjects(Balloon.class);
                for (Balloon target : targets){
                    target.pop();
                }
                getWorld().removeObject(this);
            }
        }
        if (getWorld() != null && (isAtEdge() || life == 0)){
           getWorld().removeObject(this);
        }
        life--;        
    }    
}
