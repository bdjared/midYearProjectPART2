import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Balloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Balloon extends Actor implements Comparable<Balloon>{
    public double totalTime;
    public double remainingTime;
    public int distance = 0;
    public final int SPEED;
    int count;
    private MyWorld world;
    /**
     * Act - do whatever the Balloon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Balloon(int speed){
         getImage().scale(30, 45);
         this.SPEED = speed;
    }
    public void act()  {
        if (world == null){
            world = (MyWorld)getWorld();
        }
        if (distance == 0 && getX() != 1){
            setLocation(1, 75);
        }        
        lizzo(world.getRoundsCompleted() / 15.0 + 1);
    }    
    
    @Override
    public int compareTo(Balloon other){
        return new Double(other.distance).compareTo(new Double(this.getDistance()));
    }
    
    public int getDistance(){
        return distance;
    }
    
    public void lizzo(double spdFactor){        
        if(!isAtEdge()){
            if(this.getX() < 250 && this.getY()<200){
                setLocation(getX() + (int)(SPEED * spdFactor), getY()); 
            }
            else if(this.getY() < 230 && this.getX() < 300){
                setLocation(getX(), getY() + (int)(SPEED * spdFactor));
            }
            else if(this.getX() <415 && this.getY()>230){
                setLocation(getX() + (int)(SPEED * spdFactor), getY());
            }
            else if(this.getX() > 400 && this.getY()>180 && this.getX() < 525){
                setLocation(getX(), getY() - (int)(SPEED * spdFactor));
            }
            else if(this.getX()<545 ){
                setLocation(getX() + (int)(SPEED * spdFactor), getY());
            }
            else{
                setLocation(getX(), getY() + (int)(SPEED * spdFactor));
            }
                        
            distance += (int)(SPEED * spdFactor);
        }
        
        else{
           getWorld().removeObject(this);
        }
    }
    
    public void pop(){
        getWorld().removeObject(this);
        count++;
    }
    
}
