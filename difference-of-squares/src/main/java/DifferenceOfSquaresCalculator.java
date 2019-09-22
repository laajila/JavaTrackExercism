class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        int squareOfSums=0;
        for (int i = 1; i < input+1; i++) {
            squareOfSums+=i;
        }
        return (int) Math.pow(squareOfSums,2);
    }

    int computeSumOfSquaresTo(int input) {
        int sumOfSquares=0;
        for (int i = 1; i < input+1; i++) {
            sumOfSquares+=Math.pow(i,2);
        }
        return sumOfSquares;
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input)-computeSumOfSquaresTo(input);
    }

}
