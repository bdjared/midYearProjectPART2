import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class range here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Range extends Actor
{
    private Tower parent;
    public boolean showing;
    
    public Range (Tower parent){        
        this.parent = parent;
        showing = true;
    }
    
    public void act(){
        setLocation(parent.getX(), parent.getY());
    }    
    
    public void placeable(){
        setImage("blackCircle.png");
        getImage().setTransparency(100);
        getImage().scale(parent.range * 6/5, parent.range * 6/5);
    }
    
    public void hide(){
        getImage().setTransparency(0);
        showing = false;
    }
    
    public void show(){
        getImage().setTransparency(100);
        showing = true;
    }
    
    public void reset(){
        setImage("redCircle.png");
        getImage().setTransparency(100);
        getImage().scale(parent.range * 2000/1980, parent.range * 2000/1980);
    }
}
