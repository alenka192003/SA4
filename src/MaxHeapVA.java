import java.util.ArrayList;

import java.util.List;
import java.util.Stack;

public class MaxHeapVA<E extends Comparable<E>> implements Heap<E> {

    private ArrayList<E> elements;

    public MaxHeapVA() {
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
        if (size() == 0) {return null;}
        return elements.get(0);
    }

    private void heapifyUp() {
        int current = size() - 1;
        while (current > 0) {
            int parent = (current - 1) / 2;
            if (elements.get(current).compareTo(elements.get(parent)) > 0) {
                swap(current, parent);
                current = parent;
            } else {break;}
        }
    }

    public E poll() {
        if (size() == 0) {return null;}

        E maxElement = elements.get(0);
        int lastIndex = size() - 1;

        // Замена корня на последний элемент
        elements.set(0, elements.get(lastIndex));
        elements.remove(lastIndex);
        // Восстановление свойств кучи
        heapifyUp();
        return maxElement;
    }


    private void swap(int i, int j) {
        E temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }

    public void printHeap() {
        if (size() == 0) {
            System.out.println("Heap is empty.");
            return;
        }

        int treeHeight = (int) (Math.log(size()) / Math.log(2)) + 1;
        int maxWidth = (int) Math.pow(2, treeHeight) - 1;

        List<E> heapCopy = new ArrayList<>(elements);

        for (int level = 1, i = 0; level <= treeHeight; level++) {
            int nodesCount = (int) Math.pow(2, level - 1);

            for (int j = 0; j < nodesCount; j++) {
                if (i < heapCopy.size()) {
                    printSpaces(maxWidth / nodesCount);
                    System.out.print(heapCopy.get(i));
                    printSpaces(maxWidth / nodesCount);
                    i++;
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

    public void merge(MaxHeapVA<E> otherHeap) {
        // Объединяем списки элементов без использования дополнительной памяти
        elements.addAll(otherHeap.elements);

        // Применяем heapifyDown для каждого элемента, начиная с последнего добавленного элемента
        for (int i = size() - 1; i >= 0; i--) {
            heapifyDown(i, size());
        }
    }
    private void heapifyDown(int index, int heapSize) {
        int currentIndex = index;
        int maxChildIndex;

        while (true) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            if (leftChildIndex < heapSize) {
                if (rightChildIndex < heapSize && elements.get(rightChildIndex).compareTo(elements.get(leftChildIndex)) > 0) {
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


}
