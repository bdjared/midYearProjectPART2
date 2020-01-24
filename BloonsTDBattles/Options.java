import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Options here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Options extends Actor
{
    private String type;
    private Tower tower;
    private int cost;
    
    public Options(String type, int cost){
        this.type = type;
        this.cost = cost;           
    }
    
    /**
     * Act - do whatever the Options wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        if (Greenfoot.mouseClicked(this)){
            try{
                Class cls = Class.forName(type);
                tower = (Tower)cls.newInstance(); 
                getWorld().addObject(tower, getX(), getY()); 
                tower.rangeCircle.showing = true;
                getWorld().addObject(tower.rangeCircle, getX(), getY());            
            } catch (Exception e){
                System.err.println(e);
            }
        }
        if (tower != null && !tower.placed && tower.getWorld() != null){
            buy(tower);
        }
    } 
    
    public void buy(Tower tower){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null){
            tower.setLocation(mouse.getX(), mouse.getY());
            if (!tower.touching(Tower.class) && !tower.touching(Track.class) && mouse.getX() < 600){
                tower.placeable = true;
                if (Greenfoot.mouseClicked(tower)){
                    tower.placeable = false;                    
                    tower.placed = true;
                }
            } 
            else{            
                tower.placeable = false;
            }
        }
    }
}
