import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RailFenceCipher {
    int cypherNumTofindSizeOfsubstrings;
    int cypherLines;

    RailFenceCipher(int x) {
        cypherLines = x;
        cypherNumTofindSizeOfsubstrings = (x - 1) * 2;
    }

    String getDecryptedData(String cryptedInput) {


        StringBuilder decyphred = new StringBuilder();
        List<Integer> sizeRows = new ArrayList<Integer>();
        int inputLength = cryptedInput.length();

        int rowSize = 0;
        int begining = 0;
        int end = 0;
        List<String> rows = new ArrayList<String>();
        for (int i = 0; i < cypherLines; i++) {
            begining = begining + rowSize;
            if (i == 0 || i == cypherLines - 1) rowSize = inputLength / (cypherNumTofindSizeOfsubstrings);
            else rowSize = (inputLength / (cypherNumTofindSizeOfsubstrings) * 2);

            if ((inputLength % cypherNumTofindSizeOfsubstrings) != 0) {
                if (inputLength % cypherNumTofindSizeOfsubstrings > i)
                    rowSize = rowSize + 1;
            }
            end = end + rowSize;
            rows.add(cryptedInput.substring(begining, end));

            sizeRows.add(rowSize);
        }



        int counter = 0;
        for (int i = 0; i < sizeRows.get(0); i++) {

            if (counter >= inputLength) break;
            for (int j = 0; j < cypherLines; j++) {
                if (j == 0 || j == cypherLines - 1) decyphred.append(rows.get(j).charAt(i));
                else decyphred.append(rows.get(j).charAt(2 * i));
                counter++;
                if (counter >= inputLength) break;
            }
            if (counter >= inputLength) break;
            for (int j = cypherLines - 2; j > 0; j--) {
                decyphred.append(rows.get(j).charAt(i * 2 + 1));
                counter++;
                if (counter >= inputLength) break;
            }
        }




        return decyphred.toString();
    }

    String getEncryptedData(String clearInput) {
        int inputLength = clearInput.length();
        int rowSize = 0;
        List<Integer> sizeRows = new ArrayList<Integer>();

        for (int i = 0; i < cypherLines; i++) {

            if (i == 0 || i == cypherLines - 1) rowSize = inputLength / (cypherNumTofindSizeOfsubstrings);
            else rowSize = (inputLength / (cypherNumTofindSizeOfsubstrings) * 2);

            if ((inputLength % cypherNumTofindSizeOfsubstrings) != 0) {
                if (inputLength % cypherNumTofindSizeOfsubstrings > i)
                    rowSize = rowSize + 1;
            }
            sizeRows.add(rowSize);
        }

        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < sizeRows.size(); i++) {
            rows.add(new StringBuilder());
        }

        for (int j = 0; j < inputLength; j = j + (cypherLines - 1) * 2) {

            for (int i = 0; i < sizeRows.size(); i++) {

                if(j + i>clearInput.length()-1) break;
                rows.set(i, rows.get(i).append(clearInput.charAt(j + i)));
            }
            for (int i = sizeRows.size() - 2; i > 0; i--) {
                if(j + 2*(sizeRows.size() - 1) -(i) >inputLength) break;
                rows.set(i, rows.get(i).append(clearInput.charAt(j + 2*(sizeRows.size() - 1) -(i))));
            }

        }
        StringBuilder decrypted = new StringBuilder();
        for (StringBuilder x :
                rows) {
            decrypted.append(x.toString());
        }
        return decrypted.toString();
    }
}