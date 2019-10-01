import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class NucleotideCounter{
    private char[] dna;
    private Map<Character,Integer> countMap=new HashMap<>(){{
        put('A', 0);
        put('C', 0);
        put('G', 0);
        put('T', 0);
    }};;
    NucleotideCounter(String dna){
        this.dna=dna.toCharArray();
        for (char c:
             this.dna) {
            char[] nucleotide = {'A', 'C', 'G', 'T'};
            if(Arrays.binarySearch(nucleotide,c)<0) throw new IllegalArgumentException("DNA invalid");
            this.countMap.put(c,countMap.get(c)+1);
        }
    }

    Map<Character,Integer> nucleotideCounts(){
        return this.countMap;
    }
}
