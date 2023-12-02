import java.util.ArrayList;
import java.util.List;

public class PriorityQueueImpl<E extends Comparable<E>> implements AbstractQueue<E> {

    private List<E> elements;

    public PriorityQueueImpl() {
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
            return null;
        }
        return elements.get(0);
    }

    @Override
    public E poll() {
        if (size() == 0) {
            return null; // или бросьте исключение, если нужно
        }

        E maxElement = elements.get(0);
        int lastIndex = size() - 1;
        elements.set(0, elements.get(lastIndex));
        elements.remove(lastIndex);
        heapifyDown();

        return maxElement;
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

    private void heapifyDown() {
        int currentIndex = 0;
        int maxChildIndex;
        while (true) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            if (leftChildIndex < size()) {
                if (rightChildIndex < size() && elements.get(rightChildIndex).compareTo(elements.get(leftChildIndex)) > 0) {
                    maxChildIndex = rightChildIndex;
                } else {
                    maxChildIndex = leftChildIndex;
                }

                if (elements.get(maxChildIndex).compareTo(elements.get(currentIndex)) > 0) {
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
        E temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
}
