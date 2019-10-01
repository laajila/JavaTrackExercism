import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;

class DiamondPrinter {
    char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    List<String> printToList(char a) {
        List<String> daimond = new ArrayList<>();
        int index = Arrays.binarySearch(alphabet, a);
        int numberSpaces = index * 2;
        if (index == 0) return singletonList("A");
        if (index > 0) {
            for (int i = 0; i <= index ; i++) {
                StringBuilder line = new StringBuilder();
                for (int j = 0; j <= numberSpaces; j++) {
                    if (i == j - index || i == index - j) line.append(alphabet[i]);
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
