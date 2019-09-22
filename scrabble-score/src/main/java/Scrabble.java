import java.util.Arrays;

class Scrabble {
    private String scrabble;

    static final private char[] ONE = {'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'};
    static final private char[] TWO = {'D', 'G'};
    static final private char[] THREE = {'B', 'C', 'M', 'P'};
    static final private char[] FOUR = {'F', 'H', 'V', 'W', 'Y'};
    static final private char[] EIGHT = {'J', 'X'};
    static final private char[] TEN = {'Q', 'Z'};
    static final private char[] FIVE = {'K'};


    Scrabble(String word) {
        scrabble = word;

    }

    int getScore() {
        int score = 0;
        for (char c :
                scrabble.toUpperCase().toCharArray()) {
            if (Arrays.binarySearch(ONE, c) >= 0) score = score + 1;
            else if (Arrays.binarySearch(TWO, c) >= 0) score = score + 2;
            else if (Arrays.binarySearch(THREE, c) >= 0) score = score + 3;
            else if (Arrays.binarySearch(FOUR, c) >= 0) score = score + 4;
            else if (Arrays.binarySearch(EIGHT, c) >= 0) score = score + 8;
            else if (Arrays.binarySearch(TEN, c) >= 0) score = score + 10;
            else if (Arrays.binarySearch(FIVE, c) >= 0) score = score + 5;
        }

        return score;
    }

}
