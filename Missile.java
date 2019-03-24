import greenfoot.*;
import java.util.List;

/**
 * A Missile that can hit asteroids.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling
 */
public class Missile extends SmoothMover
{
    /** The damage this Missile will deal */
    private static final int damage = 30;

    private int size;

    /** A Missile looses one life each act, and will disappear when life = 0 */
    private int life = 30;

    /**
     * Default constructor for testing.
     */
    public Missile()
    {
    }

    public Missile(int size){
        setSize(size);
    }

    /**
     * Create a Missile with given speed and direction of movement.
     */
    public Missile(Vector speed, int rotation)
    {
        super(speed);
        setRotation(rotation);


    }

    /**
     * The Missile will damage asteroids if it hits them.
     */
    public void act()
    {
        followAsteroid();
        if(life <= 0) {
            getWorld().removeObject(this);
        } 
        else {
            life--;
            move();
        }

    }
    /**
     * The missile will follow the asteroids in range.
     */
    public void followAsteroid(){
        List <Asteroid> a = getObjectsInRange(400,Asteroid.class);
        for (Asteroid asteroid : a){
            turnTowards(asteroid.getX(),asteroid.getY());
            move(5);
        }
    }

    /**
     * Check whether we have hit an asteroid.
     */
    private void checkAsteroidHit()
    {
        Asteroid asteroid = (Asteroid) getOneIntersectingObject(Asteroid.class);
        if (asteroid != null)
        {
            getWorld().removeObject(this);
            asteroid.hit(damage);
        }
    }

    public void setSize(int size) 
    {
        this.size = size;
        GreenfootImage image = getImage();
        image.scale(size,size);
    }
}