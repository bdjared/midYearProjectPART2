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
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 400, 1);
        prepare();
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
        addObject(buySuperMonkey,654,317);
        showText("$1000", 645, 357);
        BuyDartMonkey buyDartMonkey = new BuyDartMonkey();
        addObject(buyDartMonkey,654, 53);
        showText("$150", 645, 93);
    }
}

