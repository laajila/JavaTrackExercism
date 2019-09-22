import static java.util.Arrays.sort;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        char[] letters=phrase.toLowerCase().toCharArray();
        sort(letters);
        for(int i=0;i<letters.length-1;i++){
            //numbers are utf-8 characters in lowercase
            if (('a'<=letters[i]) && letters[i]<='z' && letters[i]==letters[i+1] ) return false;
        }
        return true;
    }

}
