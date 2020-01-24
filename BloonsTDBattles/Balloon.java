import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Balloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Balloon extends Actor implements Comparable<Balloon>{
    public int distance = 0;
    public final int SPEED;
    int count;    
    private MyWorld world;
    private int size;
    
    /**
     * Act - do whatever the Balloon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Balloon(int speed, int size){
         getImage().scale(30, 45);
         this.SPEED = speed;
         this.size = size;
    }
    public void act()  {
        if (world == null){
            world = (MyWorld)getWorld();
        }
        if (distance == 0 && getX() != 1){
            setLocation(1, 75);
        }        
        lizzo(world.getRoundsCompleted() / 20);
    }    
    
    @Override
    public int compareTo(Balloon other){
        return new Double(other.distance).compareTo(new Double(this.getDistance()));
    }
    
    public int getDistance(){
        return distance;
    }
    
    public void lizzo(int spdFactor){        
        if(!isAtEdge()){
            if(this.getX() < 250 && this.getY()<200){
                setLocation(getX() + (SPEED + spdFactor), getY()); 
            }
            else if(this.getY() < 230 && this.getX() < 300){
                setLocation(getX(), getY() + (SPEED + spdFactor));
            }
            else if(this.getX() <415 && this.getY()>230){
                setLocation(getX() + (SPEED + spdFactor), getY());
            }
            else if(this.getX() > 400 && this.getY()>180 && this.getX() < 525){
                setLocation(getX(), getY() - (SPEED + spdFactor));
            }
            else if(this.getX()<545 ){
                setLocation(getX() + (SPEED + spdFactor), getY());
            }
            else{
                setLocation(getX(), getY() + (SPEED + spdFactor));
            }
                        
            distance += SPEED + spdFactor;
        }
        
        else{
           world.loseLives(this.size);
           world.removeObject(this);
        }
    }
    
    public void pop(){
        getWorld().removeObject(this);
        count++;
    }
    
}
