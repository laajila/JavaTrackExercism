import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Robot{
    private String name;
    private char[] digits="0123456789".toCharArray();
    private char[] Letters="ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static List<String> robotRegistry=new ArrayList<String>();
    private Random generator;
    Robot(){
        this.generator=new Random();
    }

    String getName(){
        this.name=generateName();
        if (robotRegistry.contains(this.name)){
            this.name=generateName();
            return this.name;
        }
        robotRegistry.add(this.name);
        return this.name;
    }

    private String generateName(){
        StringBuilder name=new StringBuilder();
        for (int i = 0; i <2 ; i++) {
            name.append(Letters[generator.nextInt(26)]);
        }
        for (int i = 0; i <3 ; i++) {
            name.append(digits[generator.nextInt(10)]);
        }
        return name.toString();
    }

    void reset(){
        robotRegistry.remove(this.name);
        getName();
        robotRegistry.add(this.name);
    }
}
