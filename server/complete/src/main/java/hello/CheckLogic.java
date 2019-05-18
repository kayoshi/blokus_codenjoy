package hello;

public class CheckLogic extends GeneratedMatrix{


    public boolean canPutFigure(int[][] currentMatrix, int x, int y, int[][] edgeMatrix, int edge, int figure){

        if(figure == 1){
            if (edge == 1) {
                if(currentMatrix[x-1][y-1] != 0){
                    System.out.println("Enter matrix: ");
                    return false;
                }
            } else if (edge == 2) {
                if(currentMatrix[x+1][y-1] != 0) {
                    return false;
                }
            }else if (edge == 3) {
                if(currentMatrix[x+1][y+1] != 0) {
                    return false;
                }
            }else if (edge == 4) {
                if(currentMatrix[x-1][y+1] != 0) {
                    return false;
                }
            }
        }
        if(figure == 2){
            if(edge == 1 ){
                if(edgeMatrix.length == 3){
                    if (currentMatrix[x-1][y-1] != 0 || currentMatrix[x-1][y-2] != 0){
                        return false;
                    }
                } else {
                    if (currentMatrix[x-1][y-1] != 0 || currentMatrix[x-2][y-1] != 0){
                        return false;
                    }
                }
            } else if(edge == 2){
                if(edgeMatrix.length == 3){
                    if (currentMatrix[x+1][y-1] != 0 || currentMatrix[x+1][y-2] != 0){
                        return false;
                    }
                } else {
                    if (currentMatrix[x+1][y-1] != 0 || currentMatrix[x+2][y-1] != 0){
                        return false;
                    }
                }
            } else if(edge == 3){
                if(edgeMatrix.length == 3){
                    if (currentMatrix[x+1][y+1] != 0 || currentMatrix[x+1][y+2] != 0){
                        return false;
                    }
                } else {
                    if (currentMatrix[x+1][y+1] != 0 || currentMatrix[x+2][y+1] != 0){
                        return false;
                    }
                }
            } else if (edge == 4){
                if(edgeMatrix.length == 3){
                    if (currentMatrix[x-1][y+1] != 0 || currentMatrix[x-1][y+2] != 0){
                        return false;
                    }
                } else {
                    if (currentMatrix[x-1][y+1] != 0 || currentMatrix[x-2][y+1] != 0){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public int[][] putEdge(int[][] currentMatrix, int x, int y, int[][] edgeMatrix, int edge, int figure, int player){


        //put 1x1
        if(figure == 1){
            if (edge == 1) {
                currentMatrix[x-1][y-1] = player;
            } else if (edge == 2) {
                currentMatrix[x+1][y-1] = player;
            }else if (edge == 3) {
                currentMatrix[x+1][y+1] = player;
            }else if (edge == 4) {
                currentMatrix[x-1][y+1] = player;
            }
        }

        //put 1x2 and 2x1
        if(figure == 2){
            if(edge == 1 ){
                if(edgeMatrix.length == 3){
                    currentMatrix[x-1][y-1] = player;
                    currentMatrix[x-1][y-2] = player;
                } else {
                    currentMatrix[x-1][y-1] = player;
                    currentMatrix[x-2][y-1] = player;
                }
            } else if(edge == 2){
                if(edgeMatrix.length == 3){
                    currentMatrix[x+1][y-1] = player;
                    currentMatrix[x+1][y-2] = player;
                } else {
                    currentMatrix[x+1][y-1] = player;
                    currentMatrix[x+2][y-1] = player;
                }
            } else if(edge == 3){
                if(edgeMatrix.length == 3){
                    currentMatrix[x+1][y+1] = player;
                    currentMatrix[x+1][y+2] = player;
                } else {
                    currentMatrix[x+1][y+1] = player;
                    currentMatrix[x+2][y+1] = player;
                }
            } else if (edge == 4){
                if(edgeMatrix.length == 3){
                    currentMatrix[x-1][y+1] = player;
                    currentMatrix[x-1][y+2] = player;
                } else {
                    currentMatrix[x-1][y+1] = player;
                    currentMatrix[x-2][y+1] = player;
                }
            }
        }

        return currentMatrix;
    }

}
