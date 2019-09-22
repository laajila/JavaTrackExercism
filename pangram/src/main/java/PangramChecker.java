import javax.sound.midi.Instrument;
import java.util.Arrays;
import java.util.stream.IntStream;

public class PangramChecker {

    public boolean isPangram(String input) {
        char [] alphabet="abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (char c:
             alphabet) {
            if(input.toLowerCase().chars().noneMatch(x->x==c)) return false;
        }
        return true;
    }

}
