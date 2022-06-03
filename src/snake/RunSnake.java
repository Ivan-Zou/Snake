package snake;

import snake.gamedata.Scores;
import snake.mechanics.GameMechanics;
import snake.misc.Constants;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.Color;

public class RunSnake implements Runnable {
    @Override
    public void run() {
        final JFrame frame = new JFrame("Snake");

        final JPanel scorePanel = new JPanel();
        scorePanel.setBackground(Color.BLACK);
        frame.add(scorePanel, BorderLayout.NORTH);

        final JLabel scoreLabel = new JLabel("Score: " + 0);
        scoreLabel.setForeground(Constants.LABEL_COLOR);
        scoreLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        scorePanel.add(scoreLabel);

        final Scores scores = new Scores();
        final JLabel highScoreLabel = new JLabel("High Score: " + scores.getHighScore());
        highScoreLabel.setForeground(Constants.LABEL_COLOR);
        highScoreLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        scorePanel.add(highScoreLabel);

        final JPanel statusPanel = new JPanel();
        statusPanel.setBackground(Color.BLACK);
        frame.add(statusPanel, BorderLayout.SOUTH);

        final JLabel statusLabel = new JLabel("Running...");
        statusLabel.setForeground(Constants.LABEL_COLOR);
        statusPanel.add(statusLabel);

        final GameMechanics snake = new GameMechanics(scoreLabel, highScoreLabel, statusLabel);
        frame.add(snake, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(Constants.WINDOW_LOCATION_X, Constants.WINDOW_LOCATION_Y);
    }
}
