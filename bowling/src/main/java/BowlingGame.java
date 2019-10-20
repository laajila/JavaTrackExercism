import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

class BowlingGame {

    List<Frame> game;
    int frameCount = 0;
    Frame currentFrame;
    int roll1;
    int ballThrow = 1;


    BowlingGame() {
        game = new ArrayList<>();

    }


    void roll(int pins) {
        if (pins == 10 && ballThrow == 1) {
            currentFrame = new Frame(pins, 0);
            game.add(currentFrame);
            frameCount++;
            currentFrame = null;
        } else if (pins < 10 && ballThrow == 1) {
            roll1 = pins;
            ballThrow++;
        } else if (pins < 10 && ballThrow == 2) {
            currentFrame = new Frame(roll1, pins);
            game.add(currentFrame);
            frameCount++;
            ballThrow = 1;
            currentFrame = null;
        }
//
        if (frameCount == 10 && (game.get(9).getType().equals("strike") || game.get(9).getType().equals("spare"))) {
            game.get(9).addToLastThrow(pins);
            frameCount++;
        } else if (frameCount == 11 && (game.get(9).getType().equals("strike") || game.get(9).getType().equals("spare"))) {
            game.get(9).addToLastThrow(pins);
            frameCount++;
        } else if (frameCount >= 10) {
            throw new IllegalStateException("Cannot roll after game is over");
        }

    }

    int score() {
        int score = 0;
        for (int i = 0; i < game.size(); i++) {
            Frame current = game.get(i);
            if (current.getType().equals("strike")) {
                if (i < game.size() - 1) {
                    score = score + 10 + game.get(i + 1).getRoll1() + game.get(i + 1).getRoll2();
                } else {
                    score = score + 10 + game.get(9).getLastThrow();
                }
            } else if (current.getType().equals("spare")) {
                if (i < game.size() - 1) {
                    score = score + 10 + game.get(i + 1).getRoll1() + game.get(i + 1).getRoll1();
                } else {
                    score = score + 10 + game.get(9).getLastThrow();
                }

            } else if (current.getType().equals("open")) {
                score = score + current.getRoll1() + current.getRoll2();
            }
        }

        return score;


    }
}
