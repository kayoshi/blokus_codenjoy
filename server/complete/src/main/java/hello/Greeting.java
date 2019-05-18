package hello;

public class Greeting {

    private final int  color;
    private final int [][] content;

    public Greeting(int color, int[][] content) {
        this.color = color;
        this.content = content;
    }

    public int getColor() {
        return color;
    }

    public int[][] getContent() {
        return content;
    }
}
