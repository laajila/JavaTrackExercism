import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class DnDCharacter {
    private int constitution;
    private int modifier;
    private int strength;
    private int dex;
    private int intelligence;
    private int wisdom;
    private int charisma;

    DnDCharacter() {
        constitution = ability();
        strength = ability();
        dex = ability();
        intelligence = ability();
        wisdom = ability();
        charisma = ability();
        modifier=modifier(constitution);
    }

    int ability() {
        int sum = 0;
        List<Integer> rolls=rollDice(4, 3);
        for (int x :
               rolls ) {
            sum += x;
        }

        return sum;

    }

    int modifier(int input) {
         return (int) Math.floor(((input - 10.0) / 2));
    }

    int getStrength() {
        return strength;
    }

    int getDexterity() {
        return dex;
    }

    int getConstitution() {
        return constitution;
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {

        return (10 + modifier);
    }

    private int rollDice() {
        return (int) (Math.ceil(Math.random() * 6));
    }

    private List<Integer> rollDice(int times, int numMaxValues) {
        List<Integer> values = new ArrayList<Integer>();
        PriorityQueue<Integer> val=new PriorityQueue<Integer>(numMaxValues, Collections.reverseOrder());

        for (int i = 0; i < times; i++) {
            val.add(rollDice());
        }
        for (int i = 0; i < numMaxValues; i++) values.add(val.poll());
        return values;
    }


}
