package snake.classes;

import snake.misc.Constants;
import snake.misc.Direction;

import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;

public class Snake {
    private final LinkedList<Point> snake;
    private Direction direction;

    public Snake() {
        snake = new LinkedList<>();
        reset();
    }

    public void reset() {
        direction = Direction.NONE;
        snake.clear();
        snake.add(new Point(Constants.SNAKE_STARTING_HEAD_X,
                Constants.SNAKE_STARTING_HEAD_Y, Direction.RIGHT));
        snake.add(new Point(Constants.SNAKE_STARTING_BODY_X,
                Constants.SNAKE_STARTING_BODY_Y, Direction.RIGHT));
        snake.add(new Point(Constants.SNAKE_STARTING_TAIL_X,
                Constants.SNAKE_STARTING_TAIL_Y, Direction.RIGHT));
    }

    public void move() {

    }

    public void up() {
        direction = Direction.UP;
    }

    public void down() {
        direction = Direction.DOWN;
    }

    public void left() {
        direction = Direction.LEFT;
    }

    public void right() {
        direction = Direction.RIGHT;
    }

    public Iterator<Point> iterator() {
        return snake.iterator();
    }

    public void draw(Graphics g) {

    }
}

class Point {
    int x, y;
    Direction direction;

    Point(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
}
