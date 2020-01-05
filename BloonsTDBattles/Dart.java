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
    public Dart(int angle, Tower start){
        setLocation(start.getX(), start.getY());
        setRotation(angle + 45);
        getImage().scale(500,500);
        act();
    }
    
    public void act() 
    {
        int lifetime = 0;
        while (lifetime < 20000){
            move(1);
            if (getWorld() != null && isTouching(Balloon.class)){          
               pop();                
            }
            lifetime++;
        }
        if (getWorld() != null)
        getWorld().removeObject(this);
    }  
    
    private void pop(){
        hits = true;        
        getWorld().removeObject(this);
    }
}
