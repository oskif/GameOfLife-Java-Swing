import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.Line;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class GameRendering extends JPanel implements Constants {
    enum State {
        GAME,
        MENU,
        PAUSE
    }

    State state = State.GAME;
    GameBoard game;// = new GameBoard();


    public GameRendering() {
        game = new GameBoard();
        game.changeState(2, 0);
        game.changeState(2, 2);
        game.changeState(2, 1);
        game.changeState(0, 1);
        game.changeState(1, 2);
    }

    public void nextFrame() {
        this.game.calculateFuture();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.state == State.GAME) {
            boolean[][] board = game.getCurrent();
            for (int i = 0; i < BOARD_HEIGHT; i++) {
                for (int j = 0; j < BOARD_WIDTH; j++) {
                    if (board[i][j]) {
                        g.setColor(Color.BLUE);
                        g.fillRect(j * RECTANLE_WIDTH, i * RECTANLE_HEIGHT, RECTANLE_WIDTH, RECTANLE_HEIGHT);
                    }
                    g.setColor(Color.BLACK);
                    g.drawLine(0, j * RECTANLE_WIDTH, WINDOW_WIDTH, j * RECTANLE_WIDTH);
                    g.drawLine(j * RECTANLE_HEIGHT, 0, j * RECTANLE_HEIGHT, j * WINDOW_HEIGHT * BOARD_HEIGHT);
                }

            }
        }
        if (this.state == State.MENU) {

        }
        //if (lives > 0) {
        //    System.out.println("Still have " + lives + " lives");
        //    g.setColor(Color.RED);
        //    g.fillRect(5 * 20, 25 * 20, 100, 30);
        //    g.setColor(Color.BLACK);
        //    String result = "Lives: " + lives;
        //    g.drawString(result, 6 * 20, 26 * 20);
        //} else if (gameOverImage != null) {
        //    System.out.println("Game over");
        //    int x = (getWidth() - gameOverImage.getIconWidth()) / 2;
        //    int y = (getHeight() - gameOverImage.getIconHeight()) / 2;
        //    g.drawImage(gameOverImage.getImage(), x, y, gameOverImage.getIconWidth(), gameOverImage.getIconHeight(), this);
        //}
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);
    }


}