import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordCount {


    WordCount() {

    }

    Map<String, Integer> phrase(String phrase) {
        Map<String, Integer> count = new HashMap<>();
        String formattedPhrase = phrase
                .replaceAll("\n", " ")
                .replaceAll("[.!?,:&@$%^&]", " ")
                .replaceAll(" {2,}", " ")
                .toLowerCase()
                .trim();
        System.out.println(formattedPhrase);

        for (String word :
                formattedPhrase.split(" ")) {
            if(2 == word.replaceAll("[^']", "").length()){
                String quotes=word.replace("'", "");
                if (count.containsKey(quotes)) {
                    count.put(quotes, count.get(quotes) + 1);
                }else count.put(quotes, 1);
            } else if (count.containsKey(word)) count.put(word, count.get(word) + 1);
            else count.put(word, 1);
        }
        return count;

    }

}