import java.util.*;

class School {
    private SortedMap<Integer,TreeSet<String>> register;
    School (){
        register=new TreeMap<Integer,TreeSet<String>>();
    }
    void add(String name,int grade){
        TreeSet<String> studentsIngrade=this.register.get(grade);
        if(studentsIngrade!=null){
            studentsIngrade.add(name);
        }else {
            studentsIngrade=new TreeSet<>();
            studentsIngrade.add(name);
        }


        register.put(grade,studentsIngrade);
    }

    List<String> roster(){
        List<String> roster=new ArrayList<>();
        register.forEach(
                (grade,studentsInClass) ->{
                    roster.addAll(studentsInClass);
                }
        );
        return roster;
    }
    List<String> grade(int grade){
        if(register.get(grade)!=null)
          return   Arrays.asList(register.get(grade).toArray(new String[register.get(grade).size()]));
        else return new ArrayList<>();
    }
}
