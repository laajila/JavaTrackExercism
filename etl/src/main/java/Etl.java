import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Etl {
    Map<String, Integer> transform(Map<Integer, List<String>> old) {
        //throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        Map<String, Integer> expected = new HashMap<String, Integer>();
        old.forEach(
                (intkey, listLetters) -> {
                    for (String s:
                         listLetters) {
                        expected.put(s.toLowerCase(),intkey);
                    }
                }
        );
        return expected;
    }
}
