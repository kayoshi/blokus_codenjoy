package hello;

import java.util.Scanner;

public class GameMain {

    private Scanner myObj;
    private CheckLogic checklogic;
    private int[][] gameArea;
    private GeneratedMatrix generatedMatrix;
    private boolean isFirstMove = true, isSecondMove = true;
    public static String mState;
    public static int currentPlayer = 1;

    public void GameStart(){
        int[] gameLevel = new int[]{ 16, 18, 20 };
        boolean firstGamerInOn = true, secondGamerInOn = true;
        mState = "IN_PROGRESS";

        generatedMatrix = new GeneratedMatrix();
        gameArea = generatedMatrix.generateArea(gameLevel[2]);

        checklogic = new CheckLogic();
        for (int i = 0; i <gameLevel[2]; i++) {
            for (int j = 0; j < gameLevel[2]; j++) {
                if(i == 0 && j == 0){
                    gameArea[i][j] = 1;
                } else if(i == gameLevel[2]-1 && j == gameLevel[2]-1){
                    gameArea[i][j] = 2;
                } else {
                    gameArea[i][j] = 0;
                }
            }
        }



        generatedMatrix.setGameArea(gameArea);
    }

    private void putEdgeFirstPlayer() {

        System.out.println("Enter x coordinates first player: ");
        int x = myObj.nextInt();
        System.out.println("Enter y coordinates first player: ");
        int y = myObj.nextInt();

        System.out.println("Enter figure x: ");
        int figureX = myObj.nextInt();

        System.out.println("Enter figure y: ");
        int figureY = myObj.nextInt();

        System.out.println("Enter edge: ");
        int edge = myObj.nextInt();

        System.out.println("Enter figure: ");
        int figure = myObj.nextInt();


        int[][] edgeMatrix = new int[figureX][figureY];

        System.out.println("Enter matrix: ");

        for (int i = 0; i < figureX; i++) {
            for (int j = 0; j < figureY; j++) {
                edgeMatrix[i][j] = myObj.nextInt();
            }
        }

        if(checklogic.canPutFigure(gameArea, x, y, edgeMatrix, edge, figure)){
            System.out.println("first player put their figure ");
            generatedMatrix.setGameArea(checklogic.putEdge(gameArea, x, y, edgeMatrix, edge, figure, 1));
            currentPlayer = 2;
        } else {
            System.out.println("first player cannot place figure");
            putEdgeFirstPlayer();
        }
    }

    private void putEdgeSecondPlayer() {
        System.out.println("Enter x coordinates second player: ");
        int x = myObj.nextInt();
        System.out.println("Enter y coordinates second player: ");
        int y = myObj.nextInt();

        System.out.println("Enter figure x: ");
        int figureX = myObj.nextInt();

        System.out.println("Enter figure y: ");
        int figureY = myObj.nextInt();

        System.out.println("Enter edge: ");
        int edge = myObj.nextInt();

        System.out.println("Enter figure: ");
        int figure = myObj.nextInt();

        int[][] edgeMatrix = new int[figureX][figureY];
        System.out.println("Enter matrix: ");

        for (int i = 0; i < figureX; i++) {
            for (int j = 0; j < figureY; j++) {
                edgeMatrix[i][j] = myObj.nextInt();
            }
        }
        if(checklogic.canPutFigure(gameArea, x, y, edgeMatrix, edge, figure)){
            System.out.println("second player put their figure ");
            generatedMatrix.setGameArea(checklogic.putEdge(gameArea, x, y, edgeMatrix, edge, figure, 2));
            currentPlayer = 1;
        } else {
            System.out.println("second player cannot place figure ");
            putEdgeSecondPlayer();
        }
    }

    enum States {
        WAITING("WAITING"),
        GAME_OVER("GAME_OVER"),
        GAME_ON("GAME_ON");


        private final String game_on;

        States(String game_on) {
            this.game_on = game_on;
        }
    }
}
