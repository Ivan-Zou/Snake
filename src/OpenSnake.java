import snake.RunSnake;

import javax.swing.SwingUtilities;

public class OpenSnake {
    public static void main(String[] args) {
        Runnable snake = new RunSnake();
        SwingUtilities.invokeLater(snake);
    }
}
