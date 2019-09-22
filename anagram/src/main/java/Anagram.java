import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.sort;

public class Anagram {
    private String word;
    Anagram(String wordToCheck){
        word = wordToCheck.toLowerCase();
    }

    List<String> match(List<String> words){
        List<String> matches = new ArrayList<>();
        char[] comparaisonLetters=word.toCharArray();
        sort(comparaisonLetters);
        for (String x:
                words
             ) {
            char [] letters=x.toLowerCase().toCharArray();
            sort(letters);

            if(Arrays.equals(comparaisonLetters,letters) && !word.equals(x.toLowerCase()) ){
                matches.add(x);
            }
        }
        return matches;
    }
}
