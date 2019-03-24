import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlackHole here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackHole extends Actor
{
    private int size;
    private int time = 0;
    /**
     * Act - do whatever the BlackHole wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        spin();
        touchingAsteroid();
        touchingRocket();
        time++;
        // Add your action code here.
    }    

    public BlackHole(){
        this(80);
    }

    /**
     * Spin around.
     */
    private void spin(){
        turn(2);
    }

    public BlackHole(int size){
        setSize(size);
    }

    /**
     * Check if it is touching a Rocket, if yes, then delete that rocket and end the game.
     */
    private void touchingRocket(){
        if(isTouching(Rocket.class)){
            removeTouching(Rocket.class);
            Space s = (Space)getWorld();
            s.gameOver();
        }
    }

    /**
     * Check if it is touching a Rocket, if yes, then delete that asteroid.
     */
    private void touchingAsteroid(){
        if(isTouching(Asteroid.class)){
            removeTouching(Asteroid.class);
        }
    }

    /**
     * Give the Blackhole a set size.
     */
    public void setSize(int size) 
    {
        this.size = size;
        GreenfootImage image = getImage();
        image.scale(size,size);
    }
}
