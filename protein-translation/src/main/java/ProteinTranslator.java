import java.sql.Array;
import java.util.*;

class ProteinTranslator {
    static final Map<String,String[]> translator=new HashMap<>() {{
        put("Methionine", new String[]{"AUG"});
        put("Phenylalanine", new String[]{"UUC","UUU"});
        put("Leucine", new String[]{"UUA", "UUG"});
        put("Serine", new String[]{"UCA","UCC","UCG","UCU"});
        put("Tyrosine", new String[]{"UAC","UAU"});
        put("Cysteine", new String[]{"UGC","UGU" });
        put("Tryptophan", new String[]{"UGG"});
        put("STOP", new String[]{"UAA", "UAG", "UGA"});
    }};;
    ProteinTranslator(){

    }

    List<String> translate(String rnaSequence) {
        List<String> splitted=split3CharactersSubs(rnaSequence);
        List<String> translated=new ArrayList<>();

        for (String x:
             splitted) {
            if(Arrays.binarySearch(translator.get("Methionine"),x)>=0) translated.add("Methionine");
            if(Arrays.binarySearch(translator.get("Phenylalanine"),x)>=0) translated.add("Phenylalanine");
            if(Arrays.binarySearch(translator.get("Leucine"),x)>=0) translated.add("Leucine");
            if(Arrays.binarySearch(translator.get("Serine"),x)>=0)translated.add("Serine");
            if(Arrays.binarySearch(translator.get("Tyrosine"),x)>=0)translated.add("Tyrosine");
            if(Arrays.binarySearch(translator.get("Cysteine"),x)>=0)translated.add("Cysteine");
            if(Arrays.binarySearch(translator.get("Tryptophan"),x)>=0)translated.add("Tryptophan");
            if(Arrays.binarySearch(translator.get("STOP"),x)>=0) break;

        }
        return translated;
    }

    List<String> split3CharactersSubs(String input){
        List<String> splited =new ArrayList<>();
        for (int i = 0; i <input.length() && i+3<=input.length()   ; i=i+3) {
            splited.add(input.substring(i,i+3));
        }
        return splited;
    }
}