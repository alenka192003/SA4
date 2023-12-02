import java.util.ArrayList;
import java.util.List;

public class MaxHeap<E extends Comparable<E>> implements Heap<E> {

    private List<E> elements;

    public MaxHeap() {
        elements = new ArrayList<>();
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public void add(E element) {
        elements.add(element);
        heapifyUp();
    }

    @Override
    public E peek() {
        if (size() == 0) {
            return null; // или бросьте исключение, если нужно
        }
        return elements.get(0);
    }

    private void heapifyUp() {
        int currentIndex = size() - 1;

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;

            if (elements.get(currentIndex).compareTo(elements.get(parentIndex)) > 0) {
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        E temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
}
