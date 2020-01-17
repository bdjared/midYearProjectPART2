import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Options here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Options extends Actor
{
    private String type = "DartMonkey";
    /**
     * Act - do whatever the Options wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        if (Greenfoot.mouseClicked(this)){
            try{
                Tower tower = (Tower)(Class.forName(type).newInstance());
                tower.buy();    
            } catch (Exception e){
                System.err.println("error");
            }
        }
    }    
}
