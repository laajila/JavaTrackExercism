import java.util.Arrays;

class SpiralMatrixBuilder {

    int[][] buildMatrixOfSize(int size) {
        int[][] matrix = new int[size][size];
        int counter = 1;
        int indexStartRightDown = 0;
        int indexFinishRightDown = size - 1;
        boolean rightDown = true;
        boolean leftTop = false;
        while (counter <= size * size) {
            //left
            for (int j = indexStartRightDown; j <= indexFinishRightDown; j++) {
                matrix[indexStartRightDown][j] = counter;
                counter++;
            }
            //down
            for (int i = indexStartRightDown + 1; i <= indexFinishRightDown; i++) {
                matrix[i][indexFinishRightDown] = counter;
                counter++;
            }
            //right
            for (int j = indexFinishRightDown - 1; j >= indexStartRightDown; j--) {
                matrix[indexFinishRightDown][j] = counter;
                counter++;
            }
            //up
            for (int i = indexFinishRightDown - 1; i >= indexStartRightDown + 1; i--) {
                matrix[i][indexStartRightDown] = counter;
                counter++;
            }
            indexFinishRightDown--;
            indexStartRightDown++;
        }


        return matrix;
    }

}

