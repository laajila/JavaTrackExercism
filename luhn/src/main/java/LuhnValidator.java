import java.util.Arrays;

class LuhnValidator {

    boolean isValid(String candidate) {
        if(candidate.replaceAll("\\s","").length()<=1) return false;
        char[] charsOfCandidate=candidate.replaceAll("\\s","").toCharArray();
        int sum=0;
        for (int i = 0; i <charsOfCandidate.length ; i++) {
            int num=Character.getNumericValue(charsOfCandidate[i]);
            if(i%2==1){
                if(num*2>9) num=(num*2)-9;
                else num=num*2;
            }
            sum=sum+num;
        }
        return sum%10==0;
    }

}
