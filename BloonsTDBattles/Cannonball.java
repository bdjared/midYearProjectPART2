import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Cannonball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cannonball extends Projectile{
    public Cannonball() {
        super(7, 40, 1);
        getImage().scale(30,30);
    }    
    
    public void act(){
        move(-7);        
        if (getWorld() != null && isTouching(Balloon.class)){
            getImage().scale(80, 80);
            if(isTouching(Balloon.class)){
                List<Balloon> bloons = getIntersectingObjects(Balloon.class);
                for (Balloon bloon : bloons){
                    bloon.pop();
                }
            }
            hits--;
            if (hits == 0){
                getWorld().removeObject(this);
            }
        }
        if (getWorld() != null && (isAtEdge() || life == 0)){
           getWorld().removeObject(this);
        }
        life--;        
    }    
}
