public class SetADT {
    private int size;           // Number of elements in the set
    private char[] elements;    // Array to hold elements of the set
    private static final int MAX_SIZE = 100; // Maximum size of the set

    // Constructor to initialize the set
    public SetADT() {
        size = 0;
        elements = new char[MAX_SIZE];
    }

    // Method to return the current size of the set
    public int size() {
        return size;
    }

    // Method to check if the set is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to check if the set contains a specific element
    public boolean contains(char element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                return true;
            }
        }
        return false;
    }

    // Method to add an element to the set
    public boolean add(char element) {
        if (!contains(element) && size < MAX_SIZE) {
            elements[size++] = element;
            return true;
        }
        return false;
    }

    // Method to remove an element from the set
    public boolean remove(char element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                for (int j = i; j < size - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    // Method to clear the set (remove all elements)
    public void clear() {
        size = 0;
    }

    // Method to convert the set to an array
    public char[] toArray() {
        char[] array = new char[size];
        System.arraycopy(elements, 0, array, 0, size);
        return array;
    }

    // Method to get the size of the set
    public int getSize() {
        return size;
    }
}
