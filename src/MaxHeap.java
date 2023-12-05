public class MaxHeap<E extends Comparable<E>> implements Heap<E> {
    private static final int cap = 10;
    private Object[] elements;
    private int size;

    public MaxHeap() {
        this.elements = new Object[cap];
        this.size = 0;
    }

    @Override
    public int size() {return size;}

    @Override
    public void add(E element) {
        elements[size] = element;
        heapifyUp(size);
        size++;
    }

    @Override
    public E peek() {
        if (size == 0) {return null;}
        return (E) elements[0];
    }

    public E poll() {
        if (size == 0) {return null;}
        E max = (E) elements[0];

        // Последний элемент в корень
        elements[0] = elements[size - 1];
        size--;

        heapifyDown(0);
        return max;
    }

    private void heapifyUp(int index) {
        int current = index;
        while (current > 0) {
            int parent = (current - 1) / 2;
            if (compareElements(current, parent) > 0) {
                swap(current, parent);
                current = parent;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        int currentIndex = index;
        int maxChildIndex;

        while (true) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            if (leftChildIndex < size) {
                if (rightChildIndex < size && compareElements(rightChildIndex, leftChildIndex) > 0) {
                    maxChildIndex = rightChildIndex;
                } else {
                    maxChildIndex = leftChildIndex;
                }

                if (compareElements(maxChildIndex, currentIndex) > 0) {
                    swap(currentIndex, maxChildIndex);
                    currentIndex = maxChildIndex;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        Object temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    private int compareElements(int i, int j) {
        return ((E) elements[i]).compareTo((E) elements[j]);
    }

    public void printHeap() {
        if (size == 0) {
            System.out.println("Heap is empty.");
            return;
        }

        int treeHeight = (int) (Math.log(size) / Math.log(2)) + 1;
        int maxWidth = (int) Math.pow(2, treeHeight) - 1;

        int index = 0;
        for (int level = 1; level <= treeHeight; level++) {
            int nodesCount = (int) Math.pow(2, level - 1);

            for (int j = 0; j < nodesCount; j++) {
                if (index < size) {
                    printSpaces(maxWidth / nodesCount);
                    System.out.print(elements[index]);
                    printSpaces(maxWidth / nodesCount);
                    index++;
                } else {
                    printSpaces(maxWidth / nodesCount * 2);
                }
            }
            System.out.println();
        }
    }

    private void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }
}
