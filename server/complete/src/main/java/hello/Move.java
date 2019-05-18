package hello;

public class Move {
    private final int[] point;
    private final int[][] block;
    private final int type;
    private final int color;

    public Move(int[] point, int[][] block, int type, int color){
        this.block = block;
        this.color = color;
        this.point = point;
        this.type = type;
    }

    public int[] getPoint() {
        return point;
    }

    public int[][] getBlock() {
        return block;
    }

    public int getType() {
        return type;
    }

    public int getColor() {
        return color;
    }
}
