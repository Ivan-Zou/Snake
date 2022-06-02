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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Point)) {
            return false;
        }

        Point point = (Point) obj;

        return x == point.x && y == point.y;
    }
}