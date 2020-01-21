import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tower extends Actor {
    public int range;
    public double attackDelay;
    public double wait = 0;
    public String projectile;
    private List<Balloon> bloonsInRange;  
    public boolean placed = false;
    
    public Tower(int range, double attackDelay, String projectile){
        this.range = range;
        this.attackDelay = attackDelay;
        this.projectile = projectile;
    }
       
    public void act() {
        wait--;
        bloonsInRange = findBalloons(range);
        Collections.sort(bloonsInRange);
        if (!bloonsInRange.isEmpty()){
            aim();
            if (wait <= 0){
                attack();
            }
        }
    } 
    
    public List findBalloons(int range){
        return getObjectsInRange(range, Balloon.class);        
    }  
    
    private void aim() {
        Balloon target = bloonsInRange.get(0);
        turnTowards(target.getX(), target.getY()); 
        setRotation(getRotation() + 90);
    }
    
    public void attack(){
        try{
            Projectile shot = (Projectile)(Class.forName(projectile).newInstance());
            getWorld().addObject(shot, getX(), getY());
            shot.setRotation(getRotation() + 90);     
        } catch (Exception e){
            System.err.println("error");
        }
        wait = attackDelay;
    }
    
    public List touching(Class cls){
        return getIntersectingObjects(cls);
    }
}
