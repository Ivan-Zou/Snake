package snake.classes;

import snake.misc.Constants;

import java.awt.Graphics;

public class Field {
    private final Snake snake;
    private int[][] field;
    private int points;

    public Field(Snake snake) {
        this.snake = snake;
        reset();
    }

    public void reset() {
        field = new int[Constants.FIELD_SIZE][Constants.FIELD_SIZE];
        points = 0;
    }

    public int getPoints() {
        return points;
    }

    public void update() {

    }

    public boolean gameOver() {
        return false;
    }

    public int getCell(int x, int y) {
        return field[y][x];
    }

    public void draw(Graphics g) {

    }
}
