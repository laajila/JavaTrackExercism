import java.util.*;


class Tournament {
    private StringBuilder table = new StringBuilder();



    Tournament() {
        table.append("Team                           | MP |  W |  D |  L |  P\n");
        scoreTable = new HashMap<>();
    }

    Comparator<Map.Entry<String, Integer[]>> valueComparator = new Comparator<Map.Entry<String, Integer[]>>() {

        @Override
        public int compare(Map.Entry<String, Integer[]> o1, Map.Entry<String, Integer[]> o2) {
            return o2.getValue()[4]-o1.getValue()[4];
        }
    };

    /*MP: Matches Played
    W: Matches Won
    D: Matches Drawn (Tied)
    L: Matches Lost
    P: Points*/
    HashMap<String, Integer[]> scoreTable;

    String printTable() {
        return this.toString();
    }

    void applyResults(String manyResults) {
        String[] manyResultsArray = manyResults.split("\n");
        for (String result :
                manyResultsArray) {
            applyOneResult(result);
        }
    }

    void applyOneResult(String singleResultString) {
        String[] team1Team2Result = singleResultString.split(";");
        if (scoreTable.containsKey(team1Team2Result[0])) {
            Integer[] result = scoreTable.get(team1Team2Result[0]);
            result[0] = result[0] + 1;
            if (team1Team2Result[2].equals("win")) {
                result[1] = result[1] + 1;
                result[4] = result[4] + 3;
            } else if (team1Team2Result[2].equals("draw")) {
                result[2] = result[2] + 1;
                result[4] = result[4] + 1;
            } else {
                result[3] = result[3] + 1;
            }
            scoreTable.put(team1Team2Result[0], result);
        } else {
            if (team1Team2Result[2].equals("win")) {
                scoreTable.put(team1Team2Result[0], new Integer[]{1, 1, 0, 0, 3});
            } else if (team1Team2Result[2].equals("draw")) {
                scoreTable.put(team1Team2Result[0], new Integer[]{1, 0, 1, 0, 1});
            } else {
                scoreTable.put(team1Team2Result[0], new Integer[]{1, 0, 0, 1, 0});
            }
        }


        if (scoreTable.containsKey(team1Team2Result[1])) {
            Integer[] result = scoreTable.get(team1Team2Result[1]);
            result[0] = result[0] + 1;
            if (team1Team2Result[2].equals("loss")) {
                result[1] = result[1] + 1;
                result[4] = result[4] + 3;
            } else if (team1Team2Result[2].equals("draw")) {
                result[2] = result[2] + 1;
                result[4] = result[4] + 1;
            } else {
                result[3] = result[3] + 1;
            }
            scoreTable.put(team1Team2Result[1], result);
        } else {
            if (team1Team2Result[2].equals("loss")) {
                scoreTable.put(team1Team2Result[1], new Integer[]{1, 1, 0, 0, 3});
            } else if (team1Team2Result[2].equals("draw")) {
                scoreTable.put(team1Team2Result[1], new Integer[]{1, 0, 1, 0, 1});
            } else {
                scoreTable.put(team1Team2Result[1], new Integer[]{1, 0, 0, 1, 0});
            }
        }
    }

    @Override
    public String toString() {
        System.out.println(scoreTable.toString());
        Set<Map.Entry<String, Integer[]>> entries = scoreTable.entrySet();
        List<Map.Entry<String, Integer[]>> listOfEntries = new ArrayList<Map.Entry<String, Integer[]>>(entries);
        Collections.sort(listOfEntries, valueComparator);

        listOfEntries.forEach(
                (entry) -> {
                    Integer[] v=entry.getValue();
                    String k=entry.getKey();
                    table.append(k);
                    for (int i = 0; i < 31 - k.length(); i++) {
                        table.append(" ");
                    }

                    for (int i = 0; i < v.length - 1; i++) {
                        table.append("|  ").append(v[i]).append(" ");
                    }
                    table.append("|  ").append(v[v.length - 1]).append("\n");
                });

        return table.toString();
    }
}
