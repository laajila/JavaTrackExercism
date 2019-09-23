class Proverb {
    private final static String start="For want of a ";
    private final static String middle=" the ";
    private final static String end=" was lost.\n";
    private final static String endSentence="And all for the want of a ";
    private final static String fullStop=".";
    private String[] words;


    Proverb(String[] words) {
        this.words=words;
    }

    String recite() {
        if (this.words.length==0)return "";
        StringBuilder recited=new StringBuilder();
        for (int i = 0; i <this.words.length-1 ; i++) {
            recited.append(start)
                    .append(this.words[i])
                    .append(middle)
                    .append(this.words[i+1])
                    .append(end);
        }

        recited.append(endSentence)
                .append(this.words[0])
                .append(fullStop);
        System.out.println(recited.toString());
        return recited.toString();
    }

}
