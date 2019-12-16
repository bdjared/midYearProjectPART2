import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Tower extends Actor {
    public float attackSpeed;  
    public float range;
    
    private void createRange(){
        new RangeCircle(range);
}
