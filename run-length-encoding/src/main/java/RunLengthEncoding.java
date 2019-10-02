import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class RunLengthEncoding {


    RunLengthEncoding() {

    }

    String encode(String phrase) {


        char[] charsPhrase = phrase.toCharArray();
        int count = 1;
        StringBuilder encodedPhrase = new StringBuilder();

        for (int i = 1; i <charsPhrase.length; i++) {
            char cNow = charsPhrase[i - 1];
            //add
            if (charsPhrase[i] == cNow) {
                count++;
            }
            //terminate sequence
            else {
                if (count > 1) {
                    encodedPhrase.append(count).append(cNow);
                    count = 1;
                } else {
                    encodedPhrase.append(cNow);
                }
            }
            //termnate string
            if (i==charsPhrase.length-1){
                if (count > 1 && charsPhrase[i] == cNow) {
                    encodedPhrase.append(count).append(cNow);
                    count = 1;
                } else {
                    encodedPhrase.append(charsPhrase[i]);
                }
            }
        }
        return encodedPhrase.toString();
    }

    String decode(String code) {
        char[] charsCode= code.toCharArray();
        StringBuilder phrase=new StringBuilder();
        StringBuilder number=new StringBuilder();

        for (int i = 0; i <charsCode.length ; i++) {
            if (Character.getNumericValue(charsCode[i]) >=0 && Character.getNumericValue(charsCode[i]) <=9) {
                number.append(charsCode[i]);
            }else{

                if(number.toString().isEmpty()){
                    phrase.append(charsCode[i]);
                }else{
                    for (int j = 0; j <Integer.parseInt(number.toString()) ; j++) {
                        phrase.append(charsCode[i]);
                    }
                    number.setLength(0);
                }
            }
        }
        return phrase.toString();
    }


}
