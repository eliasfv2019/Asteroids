import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vortex here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vortex2 extends Actor
{
    private int size;
    private int time = 0;
    /**
     * Act - do whatever the Vortex wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        spin();
        time++;
        // Add your action code here.
    }    

    public Vortex2(){
        this(80);
    }

    private void spin(){
        turn(2);
    }

    public Vortex2(int size){
        setSize(size);
    }

    public void setSize(int size) 
    {
        this.size = size;
        GreenfootImage image = getImage();
        image.scale(size,size);
    }

    public void spawn(){
        if(isTouching(Rocket.class)){
            getWorld().addObject(new Vortex(),Greenfoot.getRandomNumber(500),Greenfoot.getRandomNumber(300));
        }

    }
}
