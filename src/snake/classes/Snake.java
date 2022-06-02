package snake.classes;

import snake.misc.Direction;

import java.util.LinkedList;

public class Snake {
    private LinkedList<Point> snake;

    public Snake() {
        snake = new LinkedList<>();
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
