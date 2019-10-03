import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Allergies {
    List<Allergen> allergens;
    Allergen allergen;


    Allergies(int score) {
        allergens = new ArrayList<>();
        if (score>=256) {
            score=score%(256);
        }
        for (int i = 0; i <=7 ; i++) {
            if (score>=(int)Math.pow(2, 7-i)  ) {
                allergens.add(getAllergen((int) Math.pow(2, 7 - i)));
            }
            score=score%(int)Math.pow(2, 7-i);
        }
        Collections.reverse(allergens);
    }


    boolean isAllergicTo(Allergen allergen) {
        if (allergens.contains(allergen)) return true;
        else return false;
    }

    List<Allergen> getList() {
        return this.allergens;
    }

    Allergen getAllergen(int score) {
        if (score == 1) return Allergen.EGGS;
        if (score == 2) return Allergen.PEANUTS;
        if (score == 4) return Allergen.SHELLFISH;
        if (score == 8) return Allergen.STRAWBERRIES;
        if (score == 16) return Allergen.TOMATOES;
        if (score == 32) return Allergen.CHOCOLATE;
        if (score == 64) return Allergen.POLLEN;
        if (score == 128) return Allergen.CATS;
        else return Allergen.NOT_DEFINED;

    }
}
