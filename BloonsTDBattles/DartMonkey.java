import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class DartMonkey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DartMonkey extends Tower
{
    public int range = 150;
    public double attackDelay = 0;
    private List<Balloon> bloonsInRange;
    public Projectile projectileType;
    
    public DartMonkey(){
        getImage().scale(150, 150);
    }
    public void act() {
        attackDelay--;
        bloonsInRange = super.findBalloons(range);
        Collections.sort(bloonsInRange);
        if (!bloonsInRange.isEmpty()){
            aim();
            if (attackDelay <= 0){
                attack();
            }
        }
    } 
    
    private void aim() {
        Balloon target = bloonsInRange.get(0);
        turnTowards(target.getX(), target.getY());
        turn(90);        
    }
    
    public void attack() {
        Dart dart = new Dart();
        getWorld().addObject(dart, getX(), getY());
        dart.setRotation(getRotation() + 90);
        attackDelay = 50;
    }
}