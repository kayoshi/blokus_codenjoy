package hello;

public class State {

    private final String gameState;
    private final int [][] board;
    private final int player;

    public State(String gameState, int[][] board, int player) {
        this.board = board;
        this.gameState = gameState;
        this.player = player;
    }

    public String getGameState() {
        return gameState;
    }

    public int[][] getBoard() {
        return board;
    }

    public int getPlayer() {
        return player;
    }
}
