;import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    private Range range;
    private int cost;
    private MyWorld world = (MyWorld)getWorld();
    
    public Options(String type, int cost){
        this.type = type;
        this.cost = cost;
    }
    
    /**
     * Act - do whatever the Options wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        if (Greenfoot.mouseClicked(this) && world.guapo >= cost){
            try{
                tower = (Tower)(Class.forName(type).newInstance());
                range = new Range(tower);        
                getWorld().addObject(tower, 0, 0);
                getWorld().addObject(range, 0, 0);
            } catch (Exception e){
                System.err.println("error");
            }
        }
        if (tower != null && !tower.placed){
            buy(tower, range);
        }
    } 
    
    public void buy(Tower tower, Range range){
        MouseInfo mouse = Greenfoot.getMouseInfo();  
        range.reset();
        if (mouse != null){
            tower.setLocation(mouse.getX(), mouse.getY());
            if (!tower.touching(Tower.class) && !tower.touching(Track.class) && mouse.getX() < 600){
                range.placeable();
                if (Greenfoot.mouseClicked(tower)){
                    tower.placed = true;
                    world.guapo -= cost;
                    getWorld().removeObject(range);
                }
            } 
        }        
    }
}
