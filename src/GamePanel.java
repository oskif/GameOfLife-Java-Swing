import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GamePanel extends JPanel implements Constants, Runnable {
    int X, Y;
    KeyHandler keyH = new KeyHandler();
    MouseHandler mouseH = new MouseHandler();
    Thread gameThread;
    int FPS = 30;
    GameBoard board = new GameBoard(this, keyH);
    Menu menu = new Menu(this, keyH);
    Tutorial tutorial = new Tutorial(this, keyH);

    enum State {
        GAME,
        MENU,
        PAUSE,
        TUTORIAL
    }

    public State gameState = State.TUTORIAL;


    public GamePanel() {
//        board.changeState(2, 0);
//        board.changeState(2, 2);
//        board.changeState(2, 1);
//        board.changeState(0, 1);
//        board.changeState(1, 2);
        this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        System.out.print(this.getLocation());
        this.addMouseListener(mouseH);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double nextDrawTime = System.nanoTime();
        double drawInterval;
        while (gameThread != null) {
            drawInterval = 1000000000 / FPS;
            update();
            repaint();
            double remainingTime = nextDrawTime - System.nanoTime();
            try {
                remainingTime = remainingTime / 1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        if (gameState == State.GAME) {
            if (keyH.rightPressed) {
                if (this.FPS < 60)
                    this.FPS += 5;
            } else if (keyH.leftPressed) {
                if (this.FPS > 5) {
                    this.FPS -= 5;
                }
            } else if (keyH.spacePressed) {
                //this.FPS = 1;
                this.gameState = State.PAUSE;
            }
            board.update();


        } else if (gameState == State.PAUSE) {
            if (mouseH.mousePressed) {
                if (mouseH.mouseX != X && mouseH.mouseY != Y) {
                    board.changeState(mouseH.mouseX / RECTANGLE_WIDTH, mouseH.mouseY / RECTANGLE_HEIGHT);
                    X = mouseH.mouseX;
                    Y = mouseH.mouseY;
                }
            }
            if (keyH.rightPressed) {
                this.gameState = State.GAME;
            }

        } else if (gameState == State.MENU) {
            if (keyH.upPressed) {
                menu.commmand_num--;
                keyH.upPressed = false;
                if (menu.commmand_num == -1) {
                    menu.commmand_num = 2;
                }
            } else if (keyH.downPressed) {
                menu.commmand_num++;
                keyH.downPressed = false;
                if (menu.commmand_num > 2) {
                    menu.commmand_num = 0;
                }
            } else if (keyH.enterPressed) {
                if (menu.commmand_num == 1) {
                    System.out.println("Juz w krótce :)");
                } else if (menu.commmand_num == 2) {
                    System.exit(0);
                }
            }
        }else if (gameState == State.TUTORIAL)
        {

        }


    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (gameState == State.GAME) {
            board.draw(g2);
        } else if (gameState == State.PAUSE) {
            board.draw(g2);
        } else if (gameState == State.MENU) {
            menu.draw(g2);
        }else if (gameState == State.TUTORIAL) {
            tutorial.draw(g2);
        }

        g2.dispose();

    }
}
