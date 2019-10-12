import java.util.List;

class BinarySearch {
    List<Integer> sortedList;

    BinarySearch(List<Integer> sortedList) {
        this.sortedList = sortedList;
    }

    int indexOf(int intTobeFound) throws ValueNotFoundException {
        int start = 0;
        int end = sortedList.size() - 1;

        while (start <= end) {
            int middle = (end + start) / 2;
            if (intTobeFound > sortedList.get(middle)) {
                start = middle + 1;


            } else if (intTobeFound < sortedList.get(middle)) {
                end = middle - 1;
            } else if (intTobeFound == sortedList.get(middle)) {
                return middle;
            }
        }
        throw new ValueNotFoundException("Value not in array");
    }
}
