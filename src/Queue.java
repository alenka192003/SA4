
import java.util.LinkedList;
import java.util.List;

public class Queue<E extends Comparable<E>> implements AbstractQueue<E> {
    private LinkedList<E> queue;

    public Queue() {
        queue = new LinkedList<>();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public void add(E element) {
        queue.add(element);
        heapifyUp();
    }

    @Override
    public E peek() {
        if (size() == 0) {
            return null;
        }

        return queue.get(0);
    }

    @Override
    public E poll() {
        if (size() == 0) {
            return null;
        }
        E max = queue.get(0);
        int lastIndex = size() - 1;
        queue.set(0, queue.get(lastIndex));
        queue.remove(lastIndex);
        heapifyDown();

        return max;
    }

    private void heapifyUp() {
        int current = size() - 1;
        while (current > 0) {
            int pIndex = (current - 1) / 2;
            if (queue.get(current).compareTo(queue.get(pIndex)) > 0) {
                swap(current, pIndex);
                current = pIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown() {
        int current = 0;
        int maxIndex;
        while (true) {
            int lIndex = 2 * current + 1;
            int rIndex = 2 * current + 2;

            if (lIndex < size()) {
                if (rIndex < size() && queue.get(rIndex).compareTo(queue.get(lIndex)) > 0) {
                    maxIndex = rIndex;
                } else {
                    maxIndex = lIndex;
                }

                if (queue.get(maxIndex).compareTo(queue.get(current)) > 0) {
                    swap(current, maxIndex);
                    current = maxIndex;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        E temp = queue.get(i);
        queue.set(i, queue.get(j));
        queue.set(j, temp);
    }

    public void printQueue() {
        int treeHeight = (int) (Math.log(size()) / Math.log(2)) + 1;
        int maxWidth = (int) Math.pow(2, treeHeight) - 1;

        for (int i = 0; i < treeHeight; i++) {
            int nodesOnCurrentLevel = (int) Math.pow(2, i);
            int spacingBetweenNodes = maxWidth / (nodesOnCurrentLevel + 1);

            for (int j = 0; j < nodesOnCurrentLevel; j++) {
                int currentIndex = (int) Math.pow(2, i) - 1 + j;

                if (currentIndex >= size()) {
                    break;
                }

                printSpaces(spacingBetweenNodes);
                System.out.print(queue.get(currentIndex));
                printSpaces(spacingBetweenNodes);

                if (j < nodesOnCurrentLevel - 1) {
                    System.out.print("  ||  ");
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
