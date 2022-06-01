package snake.mechanics;

import snake.misc.Constants;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

public class GameMechanics extends JPanel {

    public GameMechanics(JLabel score) {

        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setFocusable(true);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Constants.FIELD_WIDTH, Constants.FIELD_HEIGHT);
    }
}
