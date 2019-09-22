class ResistorColor {
    int colorCode(String color) {
        int index=0;
        for (String x:
             colors()) {
            if(!x.equals(color.toLowerCase())) index++;
            else return index;
        }
        return index;
    }

    String[] colors() {

        return new String[]{"black","brown","red",
        "orange",
        "yellow",
        "green",
        "blue",
        "violet",
        "grey",
        "white"};
    }
}
