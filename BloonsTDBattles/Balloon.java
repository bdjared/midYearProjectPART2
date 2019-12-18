import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Balloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Balloon extends Actor implements Comparable<Balloon>{
    public double speed = Math.random() * 10;
    public double totalTime;
    public double remainingTime;
    /**
     * Act - do whatever the Balloon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Balloon(){
         totalTime = 600 / speed;
         remainingTime = totalTime;
         getImage().scale(50, 75);
    }
    public void act()  {
        
    }    
    
    @Override
    public int compareTo(Balloon other){
        return new Double(remainingTime).compareTo(new Double(other.remainingTime));
    }
}
