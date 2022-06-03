package snake.classes;

import snake.misc.Constants;
import snake.misc.Direction;

import java.awt.Graphics;
import java.awt.Color;
import java.util.LinkedList;

public class Snake {
    private final LinkedList<Point> snake;
    private final Color color;
    private Direction direction;

    public Snake() {
        snake = new LinkedList<>();
        color = Color.GREEN;
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
        Point head = snake.getFirst();
        int headX = head.getX();
        int headY = head.getY();
        if (direction == Direction.UP) {
            snake.addFirst(new Point(headX, headY - 1, direction));
            snake.removeLast();
        } else if (direction == Direction.DOWN) {
            snake.addFirst(new Point(headX, headY + 1, direction));
            snake.removeLast();
        } else if (direction == Direction.LEFT) {
            snake.addFirst(new Point(headX - 1, headY, direction));
            snake.removeLast();
        } else if (direction == Direction.RIGHT) {
            snake.addFirst(new Point(headX + 1, headY, direction));
            snake.removeLast();
        }
    }

    public void up() {
        if (direction != Direction.DOWN) {
            direction = Direction.UP;
        }
    }

    public void down() {
        if (direction != Direction.UP) {
            direction = Direction.DOWN;
        }
    }

    public void left() {
        if (direction != Direction.RIGHT) {
            if (direction != Direction.NONE) {
                direction = Direction.LEFT;
            }
        }
    }

    public void right() {
        if (direction != Direction.LEFT) {
            direction = Direction.RIGHT;
        }
    }

    public boolean containsFood(Food food) {
        return snake.contains(food.getPosition());
    }

    public void grow() {
        Point tail = snake.getLast();
        int tailX = tail.getX();
        int tailY = tail.getY();
        Direction tailDirection = tail.getDirection();
        if (tailDirection == Direction.UP) {
            snake.addLast(new Point(tailX, tailY + 1, tailDirection));
        } else if (tailDirection == Direction.DOWN) {
            snake.addLast(new Point(tailX, tailY - 1, tailDirection));
        } else if (tailDirection == Direction.LEFT) {
            snake.addLast(new Point(tailX + 1, tailY, tailDirection));
        } else if (tailDirection == Direction.RIGHT) {
            snake.addLast(new Point(tailX - 1, tailY, tailDirection));
        }
    }

    public boolean selfCollision() {
        Point head = snake.getFirst();
        int i = 0;
        for (Point body : snake) {
            if (i != 0 && head.equals(body)) {
                return true;
            }
            i++;
        }
        return false;
    }

    public boolean borderCollision() {
        Point head = snake.getFirst();
        return head.getX() < 0 || head.getX() >= Constants.FIELD_SIZE ||
                head.getY() < 0 || head.getY() >= Constants.FIELD_SIZE;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        for (Point snakeSegment : snake) {
            g.fillRect(snakeSegment.getX() * Constants.CELL_SIZE,
                    snakeSegment.getY() * Constants.CELL_SIZE,
                    Constants.CELL_SIZE,
                    Constants.CELL_SIZE);
        }
    }
}
