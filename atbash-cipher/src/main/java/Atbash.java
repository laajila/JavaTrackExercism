import java.util.Arrays;

class Atbash {
    final static private char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private char[] invertedAlphabet = new char[26];


    Atbash() {
        for (int i = 0; i < alphabet.length; i++) {
            invertedAlphabet[i] = alphabet[25 - i];
        }
    }

    String encode(String data) {
        StringBuilder rotString = new StringBuilder();
        char[] dataString = data.toCharArray();
        int index = 0;
        int buffer = 0;
        for (int i = 0; i < data.length(); i++) {
            index = Arrays.binarySearch(alphabet, Character.toLowerCase(dataString[i]));
            if (Character.isDigit(dataString[i])) {
                buffer++;
                rotString.append(dataString[i]);
            } else if (index >= 0) {
                buffer++;
                rotString.append(alphabet[25-index]);
            }
            if (buffer == 5) {
                System.out.println(i);
                rotString.append(" ");
                buffer = 0;
            }
        }
        return rotString.toString().trim();
    }

    String decode(String data) {
        StringBuilder rotString = new StringBuilder();
        char[] dataString = data.toCharArray();
        int index = 0;

        for (int i = 0; i < data.length(); i++) {
            index = Arrays.binarySearch(alphabet, Character.toLowerCase(dataString[i]));
            if (Character.isDigit(dataString[i])) {
                rotString.append(dataString[i]);
            } else if (index >= 0) {
                rotString.append(alphabet[25 - index]);
            }
        }
        return rotString.toString();
    }
}
