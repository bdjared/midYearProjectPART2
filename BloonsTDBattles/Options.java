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
    
    public Options(String type){
        this.type = type;
    }
    
    /**
     * Act - do whatever the Options wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        if (Greenfoot.mouseClicked(this)){
            try{
                tower = (Tower)(Class.forName(type).newInstance());
                getWorld().addObject(tower, 0, 0);
            } catch (Exception e){
                System.err.println("error");
            }
        }
        if (tower != null && !tower.placed){
            buy(tower);
        }
    } 
    
    public void buy(Tower tower){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null){
            tower.setLocation(mouse.getX(), mouse.getY());
            if (Greenfoot.mouseClicked(tower) && !tower.touching(Tower.class)){
                tower.placed = true;
            }
        }
    }
}
