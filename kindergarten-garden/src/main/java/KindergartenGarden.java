import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

class KindergartenGarden {
    private Map<String,List<Plant>> mapOfPlants ;
    private String[] shelfs;
    final static private String[] students={"Alice", "Bob", "Charlie", "David",
            "Eve", "Fred", "Ginny", "Harriet",
            "Ileana", "Joseph", "Kincaid", "Larry"};

    KindergartenGarden(String garden) {
        mapOfPlants= new HashMap<String, List<Plant>>();
        shelfs=garden.split("\n");
        for (int i = 0; i < shelfs[0].length()/2; i++) {
            mapOfPlants.put(students[i],asList(Plant.getPlant(shelfs[0].charAt(i*2)),
                    Plant.getPlant(shelfs[0].charAt(i*2+1)),
                    Plant.getPlant(shelfs[1].charAt(i*2)),
                    Plant.getPlant(shelfs[1].charAt(i*2+1))));
        }

    }

    List<Plant> getPlantsOfStudent(String student) {
        return this.mapOfPlants.get(student);
    }

}
