public class Node<T>{
    private T value;
    Node<T> next;
    Node<T> previous;

    Node(T value){
        this.value=value;
    }

    public T getValue() {
        return value;
    }


}