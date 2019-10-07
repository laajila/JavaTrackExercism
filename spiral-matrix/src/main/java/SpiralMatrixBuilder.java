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

            for (int j = indexStartRightDown; j <= indexFinishRightDown; j++) {
                matrix[indexStartRightDown][j] = counter;
                counter++;
            }

            for (int i = indexStartRightDown + 1; i <= indexFinishRightDown; i++) {
                matrix[i][indexFinishRightDown] = counter;
                counter++;
            }


            for (int[] x :
                    matrix) {
                System.out.println(Arrays.toString(x));

            }
            System.out.println("-______________________________");

            for (int j = indexFinishRightDown - 1; j >= indexStartRightDown; j--) {
                matrix[indexFinishRightDown][j] = counter;
                counter++;
            }
            for (int i = indexFinishRightDown - 1; i >= indexStartRightDown + 1; i--) {
                matrix[i][indexStartRightDown] = counter;
                counter++;
            }


            indexFinishRightDown--;
            indexStartRightDown++;
            for (int[] x :
                    matrix) {
                System.out.println(Arrays.toString(x));

            }
            System.out.println("-______________________________");


        }
        for (int[] x :
                matrix) {
            System.out.println(Arrays.toString(x));

        }

        return matrix;
    }

}

