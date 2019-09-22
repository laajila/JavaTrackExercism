class RnaTranscription {

    String transcribe(String dnaStrand) {
        char[] strand = dnaStrand.toCharArray();
        for (int i = 0; i < strand.length; i++) {
            if (strand[i] == 'G') strand[i] = 'C';
            else if (strand[i] == 'C') strand[i] = 'G';
            else if (strand[i] == 'T') strand[i] = 'A';
            else if (strand[i] == 'A') strand[i] = 'U';
        }

        return new String(strand);
    }

}
