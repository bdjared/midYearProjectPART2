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
    public int speed;
    int count;
    /**
     * Act - do whatever the Balloon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Balloon(int speed){
         getImage().scale(40, 60);
         this.speed = speed;
    }
    public void act()  {
        if (distance == 0 && getX() != 1){
            setLocation(1, 75);
        }
    }    
    
    @Override
    public int compareTo(Balloon other){
        return new Double(other.distance).compareTo(new Double(this.getDistance()));
    }
    
    public int getDistance(){
        return distance;
    }
    
    public void lizzo(int speed){
        
        if(!isAtEdge()){
            if(this.getX() < 250 && this.getY()<200){
                setLocation(getX()+speed, getY());        
            }
            else if(this.getY() < 250 && this.getX() < 300){
                setLocation(getX(), getY()+speed);
            }
            else if(this.getX() <400 && this.getY()>200){
                setLocation(getX()+speed, getY());
            }
            else if(this.getX() > 400 && this.getY()>175 && this.getX() < 525){
                setLocation(getX(), getY()-speed);
            }
            else if(this.getX()<550 ){
                setLocation(getX()+speed, getY());
            }
            else{
                setLocation(getX(), getY()+speed);
            }
                        
            distance += speed;
        }
        
        else{
           getWorld().removeObject(this);
        }
    }
    
    public void pop(){
        MyWorld world = (MyWorld)getWorld();
        world.guapo++;
        getWorld().removeObject(this);
        count++;
    }
    
}
