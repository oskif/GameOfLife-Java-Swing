import java.awt.*;

class GameBoard implements Constants {
    private boolean[][] current;
    private boolean[][] future;
    GamePanel gp;
    KeyHandler keyH;


    GameBoard(GamePanel gp, KeyHandler keyH) {
        current = new boolean[BOARD_HEIGHT][BOARD_WIDTH];
        future = new boolean[BOARD_HEIGHT][BOARD_WIDTH];
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                this.current[i][j] = false;
                this.future[i][j] = false;
            }
        }
        this.gp = gp;
        this.keyH = keyH;
    }

    public boolean[][] getCurrent() {
        return current;
    }

    private int calculatePosition(int x, boolean isHeight) {
        if (isHeight)
            return x == -1 ? BOARD_HEIGHT - 1 : x % BOARD_HEIGHT;
        else
            return x == -1 ? BOARD_WIDTH - 1 : x % BOARD_WIDTH;
    }

    private void calculateFuture() {
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                int aliveNeighbours = this.current[i][j] ? -1 : 0;
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        if (this.current[this.calculatePosition(i + x, true)][this.calculatePosition(j + y, false)]) {

                            aliveNeighbours += 1;
                        }
                    }
                }
                if (aliveNeighbours == 3 ||
                        (aliveNeighbours == 2 && this.current[i][j])) {
                    this.future[i][j] = true;
                } else {
                    this.future[i][j] = false;
                }
            }
        }
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                this.current[i][j] = this.future[i][j];
            }
        }
    }

    public void changeState(int x, int y) {
        current[x][y] = !current[x][y];
    }

    public void update() {
        this.calculateFuture();
    }

    public void run() {

    }

    public void draw(Graphics2D g2) {
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                if (current[i][j]) {
                    g2.setColor(Color.WHITE);
                    g2.fillRect(j * RECTANGLE_WIDTH, i * RECTANGLE_HEIGHT, RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
                }
                g2.setColor(Color.BLACK);
                g2.drawLine(0, j * RECTANGLE_WIDTH, WINDOW_WIDTH, j * RECTANGLE_WIDTH);
                g2.drawLine(j * RECTANGLE_HEIGHT, 0, j * RECTANGLE_HEIGHT, j * WINDOW_HEIGHT * BOARD_HEIGHT);
            }
        }
    }
}