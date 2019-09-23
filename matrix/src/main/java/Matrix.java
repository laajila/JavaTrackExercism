import java.util.ArrayList;
import java.util.List;

class Matrix {

    int[][] matrix;



    Matrix(String matrixAsString) {
        String[] lines=matrixAsString.split("\n");
        int lineSize=lines[0].split(" ").length;
        this.matrix = new int[lines.length][lineSize];

        for (int i = 0; i <lines.length ; i++) {
            this.matrix[i]=parseLine(lines[i]);
        }
    }

    int[] getRow(int rowNumber) {
        return  matrix[rowNumber-1];
    }

    int[] getColumn(int columnNumber) {
        int[] column=new int[matrix.length];
        for (int i = 0; i <matrix.length ; i++) {
            column[i]=matrix[i][columnNumber-1];
        }
        return column;
    }

   int[] parseLine(String line){
        String[] elements=line.split(" ");
       int[] elementsInt=new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            elementsInt[i]=Integer.parseInt(elements[i]);
        }
        return elementsInt;
    }


}
