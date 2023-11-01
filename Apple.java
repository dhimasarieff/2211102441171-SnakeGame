import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Apple extends Block
{
    public void act() 
    {
        // Add your action code here.
    }    
    public void collision(SnakeWorld world) {
        Greenfoot.playSound("slurp.mp3");
        setLocation(Greenfoot.getRandomNumber(getWorld().getWidth()-2) +1, 
            Greenfoot.getRandomNumber(getWorld().getHeight()-2)+1);
        world.grow(2);
        ScoreCounter scoreCounter = world.getScoreCounter();
        scoreCounter.addToScore(10); 
        world.grow(2);
        world.removeObject(this);
    }
}

