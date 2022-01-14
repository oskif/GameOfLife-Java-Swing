import java.awt.*;

public class Menu implements Constants {
    GamePanel gp;
    KeyHandler keyH;
    public int commmand_num = 0;

    Menu(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
    }

    public void draw(Graphics2D g2) {
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96));
        String text = "Game of life";
        int x = WINDOW_WIDTH * 2 / 7;
        int y = WINDOW_HEIGHT * 1 / 5;
        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48));

        String play = "Play";
        x = WINDOW_WIDTH * 7 / 15;
        y = WINDOW_HEIGHT * 2 / 5;

        if (commmand_num == 0) {
            g2.setColor(Color.ORANGE);
            g2.drawString(play, x, y);
            g2.setColor(Color.WHITE);
        } else {
            g2.setColor(Color.WHITE);
            g2.drawString(play, x, y);
        }
        String tutorial = "Tutorial";
        x = WINDOW_WIDTH * 7 / 16;
        y = WINDOW_HEIGHT * 3 / 5;
        if (commmand_num == 1) {
            g2.setColor(Color.ORANGE);
            g2.drawString(tutorial, x, y);
            g2.setColor(Color.WHITE);
        } else {
            g2.setColor(Color.WHITE);
            g2.drawString(tutorial, x, y);
        }
        String exit = "Exit";
        x = WINDOW_WIDTH * 7 / 15;
        y = WINDOW_HEIGHT * 4 / 5;
        if (commmand_num == 2) {
            g2.setColor(Color.ORANGE);
            g2.drawString(exit, x, y);
            g2.setColor(Color.WHITE);
        } else {
            g2.setColor(Color.WHITE);
            g2.drawString(exit, x, y);
        }
    }


}
