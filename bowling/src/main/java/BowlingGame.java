import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

class BowlingGame {
    private List<Integer> rolls;
    int frame = 0;
    int rollsCounter = 20;


    BowlingGame() {
        rolls = new ArrayList<>();
    }

    void roll(int pins) {
        if (pins > 10) throw new IllegalStateException("Pin count exceeds pins on the lane");
        if (rolls.size() >= 20 && rolls.get(18) != 10)
            throw new IllegalStateException("Cannot roll after game is over");
        rolls.add(pins);
    }

    int score() {
        int score = 0;
        int i = 0;
        while (i < rolls.size() - 2) {
            if (rolls.get(i) == 10) {
                score += 10 + rolls.get(i + 1) + rolls.get(i + 2);
                i++;
            } else if (rolls.get(i) + rolls.get(i + 1) == 10) {
                score += rolls.get(i) + rolls.get(i + 1) + rolls.get(i + 2);
                i = i + 2;
            } else {
                score += rolls.get(i) + rolls.get(i + 1);
                i = i + 2;
            }
        }

        if (rolls.size() == 20) score += rolls.get(rolls.size() - 2) + rolls.get(rolls.size() - 1);

        return score;
    }


}
