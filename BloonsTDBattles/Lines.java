import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class lines here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lines extends Path
{

    /**
     * Constructor for objects of class lines.
     * 
     */
    public Lines(int sx,int sy,int ex,int ey)
    {
        GreenfootImage art = new GreenfootImage(10,10);
        art.setColor(Color.BLACK);
        art.drawLine(0,0,100,100);
    }
}
