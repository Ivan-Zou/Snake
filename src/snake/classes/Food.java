package snake.classes;

import snake.misc.Constants;
import snake.misc.Direction;

import java.awt.Graphics;
import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Food {
    private final Color color;
    private final Point position;

    public Food() {
        color = Color.RED;
        position = new Point(-1, -1, Direction.NONE);
    }

    public void generate() {
        position.setX(getRandomInt(0, Constants.FIELD_SIZE - 1));
        position.setY(getRandomInt(0, Constants.FIELD_SIZE - 1));
    }

    private static int getRandomInt(int min, int max) {
        return BigDecimal.valueOf((int) ((Math.random() * (max - min)) + min))
                .setScale(0, RoundingMode.HALF_UP).intValue();
    }

    public Point getPosition() {
        return position;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(position.getX() * Constants.CELL_SIZE,
                position.getY() * Constants.CELL_SIZE,
                Constants.CELL_SIZE,
                Constants.CELL_SIZE);
    }
}
