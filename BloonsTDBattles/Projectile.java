import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    public int speed;
    public int life;
    public int hits;
    private MyWorld world;
    
    public Projectile(int speed, int life, int hits){
        this.speed = speed;
        this.life = life;
        this.hits = hits;
    }
    
    public void act() 
    {
        move(-speed);
        if (getWorld() != null && isTouching(Balloon.class)){  
            world = (MyWorld)getWorld();
            if (this instanceof Cannonball){
                explode();
            }
            else{
                Balloon target = (Balloon)getOneIntersectingObject(Balloon.class);
                world.guapo++;
                target.pop();
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
    
    private void explode(){
        getImage().scale(120, 120);
        List<Balloon> bloons = getIntersectingObjects(Balloon.class);
        for (Balloon bloon : bloons){
            bloon.pop();
            world.guapo++;
        }       
    }
}
