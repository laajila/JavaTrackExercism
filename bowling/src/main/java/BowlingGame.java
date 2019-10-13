import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

class BowlingGame {
    private List<List<Integer>> rolls;
    int frame=0;
    int frameCounter=0;


    BowlingGame() {
        rolls = new ArrayList<>();
    }

    void roll(int pins) {
        frameCounter++;

        if (pins == 10 && frameCounter==1) {
            score += 10 + rolls.get(i + 1) + rolls.get(i + 2);
            i++;
        }else if (rolls.get(i) + rolls.get(i + 1) == 10 ){
            score += rolls.get(i) + rolls.get(i + 1) + rolls.get(i + 2);
            i=i+2;
        }else{
            score +=rolls.get(i) + rolls.get(i + 1);
            i=i+2;
        }
        rolls.add(pins);
    }

    int score() {
        int score = 0;
        int i = 0;
        while (i < rolls.size()-2) {

        }

        if(rolls.size()==20) score +=rolls.get( rolls.size()-2) + rolls.get( rolls.size()-1);

        return score;
    }





}
