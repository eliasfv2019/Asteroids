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
    public void stars(){
        for(int f = 0; f<100;f++){
            int x,y,p;
            p = Greenfoot.getRandomNumber(3);
            x = Greenfoot.getRandomNumber(700);
            y = Greenfoot.getRandomNumber(500);
            GreenfootImage background = getBackground();
            background.setColor(Color.WHITE);
            background.drawOval(x,y,p,p);
            background.fillOval(x,y,p,p);
        }
    }
    private int startRockets = 1;
    /**
     * Create the space and all objects within it.
     */
    public Space() 
    {
        super(600, 500, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();

        addRockets(startRockets);
        addAsteroids(startAsteroids);

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

    private void addRockets(int count){
        for (int i = 0; i< count;i++){
            int x = Greenfoot.getRandomNumber(getWidth()/2);
            int y = Greenfoot.getRandomNumber(getWidth()/2);
            addObject(new Rocket(), getWidth()/2,getHeight()/2);
        }
    }

    /**
     * This method is called when the game is over to display the final score.
     */
    public void gameOver() 
    {
        addObject(new ScoreBoard(),getWidth()/2,getHeight()/2); // TODO: show the score board here. Currently missing.
    }

}