package snake.classes;

import java.awt.Graphics;

public class Field {
    private final Snake snake;
    private final Food food;
    private int points;

    public Field(Snake snake) {
        this.snake = snake;
        food = new Food();
        reset();
    }

    public void reset() {
        points = 0;
        snake.reset();
        generateFood();
    }

    private void generateFood() {
        do {
            food.generate();
        } while (snake.containsFood(food));
    }

    public int getPoints() {
        return points;
    }

    public void update() {
        snake.move();
        if (snake.containsFood(food)) {
            points++;
            snake.grow();
            generateFood();
        }
    }

    public boolean gameOver() {
        return snake.selfCollision() || snake.borderCollision();
    }

    public void draw(Graphics g) {
        food.draw(g);
        snake.draw(g);
    }
}
