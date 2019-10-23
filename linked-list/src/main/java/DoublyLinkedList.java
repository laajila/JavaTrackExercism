class DoublyLinkedList<T> {
    int size;
    Node<T> front;
    Node<T> back;

    DoublyLinkedList() {
        size = 0;
    }

    void push(T item) {
        Node<T> newItem = new Node<>(item);
        if (size == 0) {
            front = newItem;
            front.previous = null;
            front.next = newItem;
            back = newItem;
            back.next = null;
            back.previous = newItem;

        } else if (size == 1) {
            back.next = newItem;
            newItem.previous = back;
            back = newItem;
            front.next = back;
        } else {
            back.next = newItem;
            newItem.previous = back;
            back = newItem;
        }
        size++;

    }

    T pop() {
        T value = (back.getValue());
        System.out.println(value.toString());
        if (back.equals(front)) {
            front = null;
            back = null;

        } else {
            back.previous.next = null;
            back = back.previous;
        }
        return value;
    }

    T shift() {
        T value = (front.getValue());
        System.out.println(value.toString());
        if (back.equals(front)) {
            front = null;
            back = null;

        } else {
            front = front.next;
            front.previous = null;
        }
        return value;
    }

    void unshift(T item) {
        Node<T> newItem = new Node<>(item);
        if (size == 0) {
            front = newItem;
            front.previous = null;
            front.next = newItem;
            back = newItem;
            back.next = null;
            back.previous = newItem;

        } else if (size == 1) {
            front.previous = newItem;
            newItem.next = front;
            front = newItem;
            front.next = back;
        } else {
            front.previous = newItem;
            newItem.next = front;
            front = newItem;
        }
        size++;
    }

}