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

    private void spin(){
        turn(2);
    }


    public BlackHole(int size){
        setSize(size);
    }

    private void touchingRocket(){
        if(isTouching(Rocket.class)){
            removeTouching(Rocket.class);
        }
    }

    private void touchingAsteroid(){
        if(isTouching(Asteroid.class)){
            removeTouching(Asteroid.class);
        }
    }

    public void setSize(int size) 
    {
        this.size = size;
        GreenfootImage image = getImage();
        image.scale(size,size);
    }
}
