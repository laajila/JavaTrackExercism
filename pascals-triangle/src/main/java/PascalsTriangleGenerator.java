import java.util.Arrays;

class PascalsTriangleGenerator {

    int[][] generateTriangle(int rows) {
        int[][] triangle = new int[rows][];
        for (int i = 1; i < rows + 1; i++) {
            int[] row = new int[i];
            for (int j = 0; j < i; j++) {
                if (j == 0) row[j] = 1;
                else if (j == i - 1) row[j] = 1;
                else {
                    row[j] = triangle[i - 2][j - 1] + triangle[i - 2][j];
                }
            }
            triangle[i - 1] = row;
        }
        return triangle;
    }
}