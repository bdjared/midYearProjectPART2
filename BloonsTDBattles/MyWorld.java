import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World{
    public int guapo =  275;
    public boolean finito = false;
    private int health = 50;
    private int roundsCompleted = 0;
    private int count = 0;
    private int index = 0;
    private Object[] currentRound = new Object[1];
    private String[] bloons = new String[] {"redBalloon", "blueBalloon", "greenBalloon"};
    private Object[] round1 = new Object[] {new Integer(35), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon()};
    private Object[] round2 = new Object[] {new Integer(20), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon()};
    private Object[] round3 = new Object[] {new Integer(20), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new blueBalloon(), new blueBalloon(), new blueBalloon(), new blueBalloon(), new blueBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon(), new redBalloon()};
    private Object[] round4 = new Object[] {new Integer(25), new blueBalloon(), new blueBalloon(), new blueBalloon(), new blueBalloon(), new blueBalloon(), new blueBalloon(), new blueBalloon(), new blueBalloon(), new blueBalloon(), new blueBalloon(), new blueBalloon(), new blueBalloon(), new blueBalloon(), new blueBalloon(), new blueBalloon(), new blueBalloon(), new blueBalloon(), new blueBalloon(), new blueBalloon(), new blueBalloon()};
    private Object[] round5 = new Object[] {new Integer(30), new blueBalloon(), new blueBalloon(), new greenBalloon(), new greenBalloon(), new greenBalloon(), new greenBalloon(), new greenBalloon(), new greenBalloon(), new greenBalloon(), new greenBalloon()};
    private ArrayList<Object[]> rounds = new ArrayList<>();
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 400, 1);
        prepare();
        rounds.add(round1);
        rounds.add(round2);
        rounds.add(round3);   
        rounds.add(round4);
        rounds.add(round5);
        setPaintOrder(Tower.class, Options.class, Projectile.class, Balloon.class, Range.class);
        showText(roundsCompleted + 1 + " - $" + guapo + "              Lives:" + health, 150, 375);
    }

    public void act(){ 
        if (roundsCompleted >= rounds.size() - 1){
            rounds.add(randomize());
        }
        if (Greenfoot.isKeyDown("SPACE")){
            currentRound = rounds.get(roundsCompleted);
        }
        if (currentRound == rounds.get(roundsCompleted)){
            showText("", 150, 25);
            int delay = (int)currentRound[0];        
            if (count++ % delay == 0 && count / delay < currentRound.length - 1){
                index = count / delay + 1;
                addObject((Balloon)currentRound[index], 0, 0);           
            }
            if (index == currentRound.length - 1 && getObjects(Balloon.class).isEmpty()) {
                count = 0;
                index = 0;
                guapo += 100;                
                roundsCompleted++;
            }
        }
        else {            
            showText("Press spacebar to start round", 150, 25);
        }
        showText(roundsCompleted + 1 + " - $" + guapo + "              Lives:" + health, 150, 375);
    }
    
    public Object[] randomize(){
        Object[] list = new Object[(int)(Math.random() * 10)  + 20 + rounds.size()];
        int size = (int)(Math.random() * 10) + 15 - (roundsCompleted - 5);
        while (size < 5){
            size = (int)(Math.random() * 5) + 2;
        }
        list[0] = new Integer(size);
        for (int i = 1; i < list.length; i++){
            try{
                String bloon = bloons[(int)(Math.random() * 3)]; 
                Class cls = Class.forName(bloon);
                list[i] = (Balloon)cls.newInstance();
            } catch (Exception e){
                System.err.println(e);
            }            
        }        
        return list;
    }
    
    public int getRoundsCompleted(){
        return roundsCompleted;
    }
    
    public void loseLives(int amt){
        health -= amt;
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare(){        
        BuyCannon buyCannon = new BuyCannon();
        addObject(buyCannon,650,185);
        showText("$" + buyCannon.cost, 645, 235);
        BuySuperMonkey buySuperMonkey = new BuySuperMonkey();
        addObject(buySuperMonkey,651,317);
        showText("$" + buySuperMonkey.cost, 645, 357);
        BuyDartMonkey buyDartMonkey = new BuyDartMonkey();
        addObject(buyDartMonkey,650, 60);
        showText("$" + buyDartMonkey.cost, 648, 100);
        
        Track track = new Track();
        track.getImage().scale(280, 60);
        addObject(track,140, 70);
        Track track1 = new Track();
        track1.getImage().scale(60, 100);
        addObject(track1,250, 150);
        Track track2 = new Track();
        track2.getImage().scale(230, 60);
        addObject(track2,335, 230);
        Track track3 = new Track();
        track3.getImage().scale(180, 65);
        addObject(track3,470, 182);
        Track track4 = new Track();
        track4.getImage().scale(65, 250);
        addObject(track4,547, 275);
        Track track5 = new Track();
        track5.getImage().scale(1, 400);
        addObject(track5,600, 200);
    }
}

