import greenfoot.*;

/**
 * A rocket that can be controlled by the arrowkeys: up, left, right.
 * The gun is fired by hitting the 'space' key. 'z' releases a proton wave.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling
 * 
 * @version 1.1
 */
public class Rocket extends SmoothMover
{
    private static final int gunReloadTime = 5;         // The minimum delay between firing the gun.

    private int reloadDelayCount;               // How long ago we fired the gun the last time.

    private GreenfootImage rocket = new GreenfootImage("rocket.png");
    private GreenfootImage rocketWithThrust = new GreenfootImage("rocketWithThrust.png");

    /**
     * Initialise this rocket.
     */
    public Rocket()
    {
        reloadDelayCount = 5;
        addToVelocity(new Vector(Greenfoot.getRandomNumber(360), 0.7));
    }

    /**
     * Do what a rocket's gotta do. (Which is: mostly flying about, and turning,
     * accelerating and shooting when the right keys are pressed.)
     */
    public void act()
    {
        checkKeys();
        reloadDelayCount++;
        protonWave();
        move();
        blowUp();
    }

    /**
     * Check whether there are any key pressed and react to them.
     */
    private void checkKeys() 
    {
        if (Greenfoot.isKeyDown("space")) 
        {
            fire();
        }
        if(Greenfoot.isKeyDown("left")){
            turn(-2);   
        }
        if(Greenfoot.isKeyDown("right")){
            turn(2);   
        }
        if(Greenfoot.isKeyDown("up")){
            setImage("rocketWithThrust.png");
            addToVelocity(new Vector(getRotation(), 0.2));
        }else{
            setImage("rocket.png");
        }

    }

    /**
     * Fire a bullet if the gun is ready.
     */
    private void fire() 
    {
        if (reloadDelayCount >= gunReloadTime) 
        {
            Bullet bullet = new Bullet (getVelocity(), getRotation());
            getWorld().addObject (bullet, getX(), getY());
            bullet.move ();
            reloadDelayCount = 0;
        }
    }

    private void blowUp(){
        if(isTouching(Asteroid.class)){
            Space s = (Space)getWorld();
            s.addObject(new Explosion(),getX(),getY());
            s.gameOver();
            s.removeObject(this);
        }
    }

    private void protonWave(){
        if(Greenfoot.isKeyDown("z")){
            getWorld().addObject(new ProtonWave(),getX(),getY());
        }
    }
}