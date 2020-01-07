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
    int life = 10;
    /**
     * Act - do whatever the Dart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Dart(){
        getImage().scale(25,25);
    }
    
    public void act() 
    {
        move(-15);
        if (getWorld() != null && isTouching(Balloon.class)){      
            removeTouching(Balloon.class);
            getWorld().removeObject(this);
        }
        if (getWorld() != null && (isAtEdge() || life == 0)){
           getWorld().removeObject(this);
        }
        life--;
        
    }    
}
