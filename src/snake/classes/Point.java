package snake.classes;

import snake.misc.Direction;

public class Point {
    int x, y;
    Direction direction;

    Point(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
}