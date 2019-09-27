import java.util.Arrays;

class RotationalCipher {
    final static private char[] alphabet="abcdefghijklmnopqrstuvwxyz".toCharArray();
    private char[] shiftedAlphabet=new char[26];


    RotationalCipher(int shiftKey) {
        for (int i = 0; i <alphabet.length ; i++) {
            int shift=i+shiftKey;
            if(shift>=26) shift=shift-26;
            shiftedAlphabet[i]=alphabet[shift];
        }
    }

    String rotate(String data) {
        StringBuilder rotString=new StringBuilder();
        char[] dataString=data.toCharArray();
        int index=0;
        for (int i = 0; i <data.length() ; i++) {
            if(Character.isLowerCase(dataString[i])){
                index=Arrays.binarySearch(alphabet,dataString[i]);
                if (index>=0) rotString.append(shiftedAlphabet[index]);
                else rotString.append(dataString[i]);
            }else{
                index=Arrays.binarySearch(alphabet,Character.toLowerCase(dataString[i]));
                if (index>=0) rotString.append(Character.toUpperCase(shiftedAlphabet[index]));
                else rotString.append(dataString[i]);
            }




        }
        return rotString.toString();
    }

}
