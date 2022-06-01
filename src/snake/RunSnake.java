package snake;

import snake.gamedata.Scores;
import snake.mechanics.GameMechanics;
import snake.misc.Constants;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;

public class RunSnake implements Runnable {
    @Override
    public void run() {
        final JFrame frame = new JFrame("Snake");

        final JPanel scorePanel = new JPanel();
        frame.add(scorePanel, BorderLayout.NORTH);

        final JLabel scoreLabel = new JLabel("Score: " + 0);
        scoreLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        scorePanel.add(scoreLabel);

        final Scores scores = new Scores();
        final JLabel highScoreLabel = new JLabel("High Score: " + scores.getHighScore());
        highScoreLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        scorePanel.add(highScoreLabel);

        final GameMechanics snake = new GameMechanics(scoreLabel);
        frame.add(snake, BorderLayout.CENTER);

        final JPanel statusPanel = new JPanel();
        frame.add(statusPanel, BorderLayout.SOUTH);

        final JLabel statusLabel = new JLabel("Running...");
        statusPanel.add(statusLabel);

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(Constants.WINDOW_LOCATION_X, Constants.WINDOW_LOCATION_Y);
    }
}
