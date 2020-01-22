import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public int guapo = 250;
    public boolean finito = false;
    private int health;
    private int roundsCompleted = 0;
    private int count = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 400, 1);
        prepare();
        setPaintOrder(Tower.class, Range.class);
    }

    public void act(){          
    }

    public void Round1 () {
        for (int i = 0; i<=15; i++) {
            addObject(new redBalloon(), 0, 0);
        }
        if (getObjects(Balloon.class).isEmpty()) {
            finito = true;
        } 
        if (finito = true) {
            guapo += 100;
            showText("Round finished! Press Spacebar to continue to the text round", 270, 200);
            if (Greenfoot.isKeyDown("SPACEBAR")){
                Round2();
            }
        }
    }

    public void Round2() {
        for (int i = 0; i<=25; i++) {
            addObject(new redBalloon(), 0, 0);
        }
        finito = true; 
        if (finito = true) {
            showText("Round finished! Press Spacebar to continue to the text round", 270, 200);
            if (Greenfoot.isKeyDown("SPACEBAR")){
                Round3();
            }
        }
    }

    public void Round3() {
        for (int i = 0; i<=10; i++) {
            addObject(new blueBalloon(), 0, 0);
            for (int g = 0; g<1; g++) {
                addObject(new redBalloon(), 0, 0);
            }
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare(){        
        BuyCannon buyCannon = new BuyCannon();
        addObject(buyCannon,650,185);
        showText("$450", 645, 235);
        BuySuperMonkey buySuperMonkey = new BuySuperMonkey();
        addObject(buySuperMonkey,651,317);
        showText("$1000", 645, 357);
        BuyDartMonkey buyDartMonkey = new BuyDartMonkey();
        addObject(buyDartMonkey,650, 60);
        showText("$150", 648, 100);
        
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

