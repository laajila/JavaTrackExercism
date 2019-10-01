import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;

class DiamondPrinter {
    char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    List<String> printToList(char a) {
        List<String> daimond = new ArrayList<>();
        int letterIndex = Arrays.binarySearch(alphabet, a);
        int numberSpaces = letterIndex * 2;
        if (letterIndex == 0) return singletonList("A");
        if (letterIndex > 0) {
            for (int i = 0; i <= letterIndex ; i++) {
                StringBuilder line = new StringBuilder();
                for (int j = 0; j <= numberSpaces; j++) {
                    if (i == j - letterIndex || i == letterIndex - j) line.append(alphabet[i]);
                    else line.append(" ");
                }
                daimond.add(line.toString());
            }

            for (int i = daimond.size()-1; i >0 ; i--) {
                daimond.add(daimond.get(i-1));
            }
        }
        return daimond;
    }

}
