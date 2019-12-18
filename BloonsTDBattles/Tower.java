import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Tower extends Actor {
    public float attackSpeed; 
    
    
    public List findBalloons(int range){
        return getObjectsInRange(range * 100, Balloon.class);        
    }
}
