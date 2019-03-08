import greenfoot.*;

/**
 * Space. Something for rockets to fly in.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class Space extends World
{
    private Counter scoreCounter;
    private int startAsteroids = 3;
    private int startVortex = 2;
    public void stars(){
        for(int i = 0; i<100;i++){  
            int f,z,p;
            f = Greenfoot.getRandomNumber(600)+1;
            z = Greenfoot.getRandomNumber(6)+1;
            p = Greenfoot.getRandomNumber(600)+1;
            GreenfootImage background = getBackground();
            background.setColor(Color.WHITE);
            background.setColor(Color.WHITE.brighter());
            background.fillOval(f,p,z,z);
            background.setColor(Color.WHITE.darker());
            background.drawOval(f,p,z,z);

        }
    }

    /**
     * Create the space and all objects within it.
     */
    public Space() 
    {
        super(600, 500, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();

        Rocket rocket = new Rocket();
        addObject(rocket, getWidth()/2 + 100, getHeight()/2);

        addAsteroids(startAsteroids);
        addVortex(startVortex);

        scoreCounter = new Counter("Score: ");
        addObject(scoreCounter, 60, 480);

        Explosion.initializeImages();
        ProtonWave.initializeImages();
        stars();
    }

    /**
     * Add a given number of asteroids to our world. Asteroids are only added into
     * the left half of the world.
     */
    private void addAsteroids(int count) 
    {
        for(int i = 0; i < count; i++) 
        {
            int x = Greenfoot.getRandomNumber(getWidth()/2);
            int y = Greenfoot.getRandomNumber(getHeight()/2);
            addObject(new Asteroid(), x, y);
        }
    }

    private void addVortex(int count){
        for(int i = 0; i < count; i++){
            int g = 0;
            if(g < getWidth()/2){
                addObject(new Vortex(),getWidth()/4,Greenfoot.getRandomNumber(getHeight()/2));
                g= g + 10;
            } else {
                addObject(new Vortex(),600,Greenfoot.getRandomNumber(getHeight()/2));

            }

        }
    }

    /**
     * This method is called when the game is over to display the final score.
     */
    public void gameOver() 
    {
        // TODO: show the score board here. Currently missing.
    }

}