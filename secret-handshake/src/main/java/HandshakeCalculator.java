import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class HandshakeCalculator {
    /*
    * 1 = wink
10 = double blink
100 = close your eyes
1000 = jump


10000 = Reverse the order of the operations in the secret handshake.*/

    List<Signal> calculateHandshake(int number) {
        List<Signal> sig=new ArrayList<>();
        String binary=intToBinaryReversed(number);
        List<Integer> ones=new ArrayList<>();
        for (int i = 0; i <binary.length(); i++) {
            if(binary.charAt(i)=='1') ones.add(i);
        }

        for (int x:
             ones) {
            if(x==0) sig.add(Signal.WINK);
            if(x==1) sig.add(Signal.DOUBLE_BLINK);
            if(x==2) sig.add(Signal.CLOSE_YOUR_EYES);
            if(x==3) sig.add(Signal.JUMP);;
            if(x==4) Collections.reverse(sig);

        }

        return sig;
    }

    String intToBinaryReversed(int input){
        StringBuilder binary=new StringBuilder();
        while(input>0){
            binary.append(input%2);
            input=input/2;
        }

        return binary.toString();

    }

}
