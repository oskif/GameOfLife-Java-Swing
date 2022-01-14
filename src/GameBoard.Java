class GameBoard implements Constants {
    private boolean[][] current = new boolean[BOARD_HEIGHT][BOARD_WIDTH];
    private boolean[][] future = new boolean[BOARD_HEIGHT][BOARD_WIDTH];


    GameBoard() {
        //current = new boolean[BOARD_HEIGHT][BOARD_WIDTH];
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

    public void calculateFuture() {
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
}
