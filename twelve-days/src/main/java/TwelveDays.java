class TwelveDays {
    String startOfVerse=" day of Christmas my true love gave to me:";
    String [] elementsOfVerses={"a Partridge in a Pear Tree",
                                "two Turtle Doves",
                                "three French Hens",
                                "four Calling Birds",
                                "five Gold Rings",
                                "six Geese-a-Laying",
                                "seven Swans-a-Swimming",
                                "eight Maids-a-Milking",
                                "nine Ladies Dancing",
                                "ten Lords-a-Leaping",
                                "eleven Pipers Piping",
                                "twelve Drummers Drumming"};

    String [] theDay={"On the first","On the second","On the third","On the fourth","On the fifth","On the sixth",
            "On the seventh","On the eighth","On the ninth","On the tenth","On the eleventh","On the twelfth"};

    TwelveDays(){


    }
    String verse(int verseNumber) {
        StringBuilder verse=new StringBuilder();
        verse.append(this.theDay[verseNumber-1]).append(this.startOfVerse);
        if(verseNumber==1) {
            verse.append(" ").append(elementsOfVerses[0]).append(".").append("\n");
        }
        else {
            for (int i = verseNumber - 1; i > 0; i--) {
                verse.append(" ").append(elementsOfVerses[i]).append(",");
            }
            verse.append(" and ").append(elementsOfVerses[0]).append(".").append("\n");
        }
        return verse.toString();
    }

    String verses(int startVerse, int endVerse) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
    
    String sing() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}
