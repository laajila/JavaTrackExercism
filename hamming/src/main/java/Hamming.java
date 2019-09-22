class Hamming {
    private char[] leftSt, rightSt;

    Hamming(String leftStrand, String rightStrand) {


        if (leftStrand.length() != rightStrand.length() ) {
            if(leftStrand.isEmpty() ) throw new IllegalArgumentException("left strand must not be empty.");
            if(rightStrand.isEmpty()) throw new IllegalArgumentException("right strand must not be empty.");
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        leftSt = leftStrand.toCharArray();
        rightSt = rightStrand.toCharArray();
    }

    int getHammingDistance() {
        int hamming = 0;
        for (int i = 0; i < leftSt.length; i++) {
            if (leftSt[i] != rightSt[i]) hamming++;
        }
        return hamming;
    }

}
