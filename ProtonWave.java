import greenfoot.*;
import java.util.List;

/**
 * A proton wave that expands and destroys asteroids in its path.
 * 
 * @author Michael Kölling
 * @version 0.1
 */
public class ProtonWave extends Actor
{
    /**
     * Size of wave
     */
    private int imageNo = 0;

    /** The damage this wave will deal */
    private static final int DAMAGE = 30;

    /** How many images should be used in the animation of the wave */
    private static final int NUMBER_IMAGES= 12;

    /** 
     * The images of the wave. This is static so the images are not
     * recreated for every object (improves performance significantly).
     */
    private static GreenfootImage[] images;
    private int increment = 1;
    /**
     * Create a new proton wave.
     */

    public ProtonWave() 
    {

        initializeImages();
        setImage(images[0]);
    }

    /** 
     * Create the images for expanding the wave.
     */
    public static void initializeImages() 
    {
        if(images == null) 
        {
            GreenfootImage baseImage = new GreenfootImage("wave.png");
            images = new GreenfootImage[NUMBER_IMAGES];
            for (int i = 0; i < NUMBER_IMAGES; i++) 
            {
                int size = (i+1) * ( baseImage.getWidth() / NUMBER_IMAGES );
                images[i] = new GreenfootImage(baseImage);
                images[i].scale(size, size);
            }
        }
    }

    /**
     * Act for the proton wave is: grow and check whether we hit anything.
     */
    public void act()
    { 
        if(isTouching(Asteroid.class)){
            removeTouching(Asteroid.class);
        }
        setImage(images[imageNo]);

        imageNo += increment;
        if(imageNo >= NUMBER_IMAGES) 
        {
            increment = -increment;
            imageNo += increment;
        }

        if(imageNo < 0)  
        {
            getWorld().removeObject(this);
        }

    }

}
