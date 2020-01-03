import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Path here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Path extends Actor
{
    int sx;
    int sy;
    int ex;
    int ey;
    /**
     * Constructor for objects of class Path.
     * 
     */
    
    public Path(int sx,int sy,int ex,int ey){
    this.sx = sx;
    this.sy = sy;
    this.ex = ex;
    this.ey = ey;
    }
    public void act()
    {
        GreenfootImage art = new GreenfootImage(10,10);
        getWorld().getBackground().setColor(Color.MAGENTA);
        getWorld().getBackground().drawLine(sx,sy,ex,ey);
    }
}
