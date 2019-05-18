package hello;

public class GameFigures {

    public int mGameLevel = 0;

    public int[] figures = new int[] {
      0, // 1x1
      1, // 1x3
      2, // 1x4
      3, // 2x2 kvadrat
      4, // lodka
      5, // krestik +
    };

    public int[] typeFigures(int gameLevel){
        return new int []{1,2,3,4,5};
    }



}
