

import javafx.util.Pair;

import java.util.*;

class Matrix {
    List<List<Integer>> matrix;

    Matrix(List<List<Integer>> values) {
        this.matrix = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        Set<Pair<Integer, Integer>> maxPairs = new HashSet<Pair<Integer, Integer>>();
        Set<MatrixCoordinate> coord = new HashSet<MatrixCoordinate>();

        for (int i = 0; i < this.matrix.size(); i++) {
            List<Integer> row = this.matrix.get(i);
            int max = Collections.max(row);
            for (int j = 0; j < row.size(); j++) {
                if (row.get(j) == max) maxPairs.add(new Pair<Integer, Integer>(i, j));

            }
        }

        for (Pair max :
                maxPairs) {
            int cordX = (int) max.getKey();
            int cordY = (int) max.getValue();
            boolean isMin=true;
            for (int i = 0; i < this.matrix.size(); i++) {
                if (this.matrix.get(cordX).get(cordY) > this.matrix.get(i).get(cordY)){
                    isMin=false;
                    break;
                }
            }
            if(isMin){
                coord.add(new MatrixCoordinate(cordX+1, cordY+1));
            }


        }

        return coord;

    }
}
