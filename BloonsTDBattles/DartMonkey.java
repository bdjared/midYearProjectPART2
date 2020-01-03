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
    public int range = 15;
    public double attackDelay = 0.75;
    private List<Balloon> bloonsInRange;
    public Projectile projectileType;
    private Dart dart;
    
    public DartMonkey(){
        getImage().scale(150, 150);
    }
    public void act() {
        bloonsInRange = super.findBalloons(range);
        Collections.sort(bloonsInRange);
        if (!bloonsInRange.isEmpty()){
            aim();
            attack();
        }
    } 
    
    private void aim() {
        Balloon target = bloonsInRange.get(0);
        turnTowards(target.getX(), target.getY());
        turn(90);        
    }
    
    public void attack() {
        if (dart == null){
            dart = new Dart(getRotation() + 90, this);
        }
        dart.act();
    }
}
