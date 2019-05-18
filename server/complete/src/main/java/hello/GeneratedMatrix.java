package hello;

public class GeneratedMatrix {

    public static int[][] gameArea;

    public static int[][] getGameArea() {
        return gameArea;
    }

    public void setGameArea(int[][] gameArea) {
        GeneratedMatrix.gameArea = gameArea;
    }

    public int[][] generateArea(int area){
        gameArea = new int[area][area];
        return gameArea;
    }

}
