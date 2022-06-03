package snake.mechanics;

import snake.classes.Field;
import snake.classes.Snake;
import snake.gamedata.Scores;
import snake.misc.Constants;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.Timer;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameMechanics extends JPanel {
    private final Scores scores;
    private final JLabel score, highScore, status;
    private final Snake snake;
    private final Field field;
    private boolean writtenToFile;

    public GameMechanics(JLabel score, JLabel highScore, JLabel status) {
        scores = new Scores();
        this.score = score;
        this.highScore = highScore;
        this.status = status;
        snake = new Snake();
        field = new Field(snake);
        writtenToFile = false;

        Timer timer = new Timer(Constants.REFRESH_RATE, actionEvent -> tick());

        timer.start();
        timer.setDelay(Constants.DELAY);

        setBorder(BorderFactory.createLineBorder(Color.GREEN));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
                    snake.left();
                } else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
                    snake.up();
                } else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
                    snake.down();
                } else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
                    snake.right();
                }
            }
        });
    }

    private void tick() {
        if (!field.gameOver()) {
            field.update();
            repaint();
            scores.setScores(field.getPoints());
            score.setText("Score: " + scores.getScore());
            highScore.setText("High Score: " + scores.getHighScore());
        }

        if (field.gameOver() && !writtenToFile) {
            writeGameDataToFiles();
            status.setText("Game Over!");
            SwingUtilities.invokeLater(() -> {
                JOptionPane.showMessageDialog(null,
                        "Game Over\n" +
                                "Score: " + scores.getScore() +
                                " | High Score: " + scores.getHighScore() +
                                "\nPlay Again?");
                reset();
                repaint();
            });
        }
    }

    private void writeGameDataToFiles() {
        scores.recordScore();
        scores.writeToFile();
        writtenToFile = true;
    }

    public void reset() {
        writtenToFile = false;
        field.reset();
        scores.reset();
        status.setText("Running...");
        score.setText("Score: " + scores.getScore());
        requestFocusInWindow();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        field.draw(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Constants.FIELD_WIDTH, Constants.FIELD_HEIGHT);
    }
}
