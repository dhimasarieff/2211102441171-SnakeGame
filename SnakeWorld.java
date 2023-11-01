import greenfoot.*;
import java.util.*;

public class SnakeWorld extends World {
    private LinkedList<SnakeBody> snake = new LinkedList<SnakeBody>();
    private int dx = 1;
    private int dy = 0;
    private int tailCounter = 5;
    private boolean dead = false;
    private ScoreCounter scoreCounter;

    public SnakeWorld() {
        super(25, 20, 32);
        SnakeBody body = new SnakeBody();
        snake.add(body);
        addObject(body, 2, 2);

        Apple apple = new Apple();
        addObject(apple, Greenfoot.getRandomNumber(getWidth() - 2) + 1, Greenfoot.getRandomNumber(getHeight() - 2) + 1);

        scoreCounter = new ScoreCounter();
        addObject(scoreCounter, 100, 30);
    }

    public void act() {
        if (dead) return;
        changeDirection();
        SnakeBody head = snake.getLast();
        head.setImage("button-green.png");
        SnakeBody newHead = new SnakeBody();
        int newHeadX = head.getX() + dx;
        int newHeadY = head.getY() + dy;

        List<Block> blocks = getObjectsAt(newHeadX, newHeadY, Block.class);
        for (Block block : blocks) {
            block.collision(this);
        }

        addObject(newHead, newHeadX, newHeadY);
        snake.add(newHead);
        if (tailCounter == 0) {
            SnakeBody tail = snake.removeFirst();
            removeObject(tail);
        } else {
            tailCounter--;
        }
        if (Greenfoot.getRandomNumber(200) < 1) {
            addObject(new Apple(), Greenfoot.getRandomNumber(getWidth() - 2) + 1, 0);
        }
    }

    private void changeDirection() {
        if (Greenfoot.isKeyDown("left") && dx == 0) {
            dx = -1;
            dy = 0;
        }
        if (Greenfoot.isKeyDown("right") && dx == 0) {
            dx = 1;
            dy = 0;
        }
        if (Greenfoot.isKeyDown("down") && dy == 0) {
            dx = 0;
            dy = 1;
        }
        if (Greenfoot.isKeyDown("up") && dy == 0) {
            dx = 0;
            dy = -1;
        }
    }

    public void setDead() { 
        dead = true;
    }

    public void grow(int size) {
        tailCounter += size;
    }

    public ScoreCounter getScoreCounter() {
        return scoreCounter;
    }
}
