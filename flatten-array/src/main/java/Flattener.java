import java.util.ArrayList;
import java.util.List;

class Flattener{
    private List<Object> flattened;
    Flattener(){
        this.flattened=new ArrayList<>();
    }
    List<Object> flatten(List<Object> notfllatened){
        addElements(notfllatened);
       return this.flattened;
    }

    @SuppressWarnings("unchecked")
    void addElements(List<Object> notfllatened){
        for (Object x:
                notfllatened) {
            if (x instanceof List<?> ) addElements((List<Object>) x);
            else if(x != null) this.flattened.add(x);
        }
    }


}
