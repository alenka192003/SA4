public class Main {
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.add(5);
        maxHeap.add(10);
        maxHeap.add(3);
        maxHeap.add(4);
        maxHeap.add(7);
        maxHeap.add(-1);
        maxHeap.add(0);

        System.out.println("Max Heap:");
        maxHeap.printHeap();

        Queue<Integer> priorityQueue = new Queue<>();

        priorityQueue.add(5);
        priorityQueue.add(2);
        priorityQueue.add(8);
        priorityQueue.add(1);
        priorityQueue.add(0);
        priorityQueue.add(11);
        priorityQueue.add(3);

        System.out.println("Current Queue:");
        priorityQueue.printQueue();


        MaxHeapVA<Integer> maxHeapVa = new MaxHeapVA<>();
        MaxHeapVA<Integer> maxHeapVa2 = new MaxHeapVA<>();

        // Добавление элементов
        maxHeapVa.add(10);
        maxHeapVa.add(5);
        maxHeapVa.add(-1);

        maxHeapVa2.add(11);
        maxHeapVa2.add(0);
        maxHeapVa2.add(12);

        long startTime = System.currentTimeMillis();
        maxHeapVa.merge(maxHeapVa2);
        long endTime = System.currentTimeMillis();

        System.out.println("Merge using MaxHeapVa.merge():");
        maxHeapVa.printHeap();
        System.out.println();
        System.out.println("Time taken for merging: " + (endTime) + " milliseconds");


        MaxHeap<Integer> maxHeap1 = new MaxHeap<>();
        MaxHeap<Integer> maxHeap2 = new MaxHeap<>();

        maxHeap1.add(10);
        maxHeap1.add(5);
        maxHeap1.add(-1);

        maxHeap2.add(11);
        maxHeap2.add(0);
        maxHeap2.add(12);

        long startTime2 = System.currentTimeMillis();

        MaxHeap<Integer> merge2 = new MaxHeap<>();
        while (maxHeap1.size() > 0) {
            merge2.add(maxHeap1.poll());
        }
        // Добавление всех элементов из второй кучи
        while (maxHeap2.size() > 0) {
            merge2.add(maxHeap2.poll());
        }
        long endTime2 = System.currentTimeMillis();

        System.out.println("Merge 2 using MaxHeap:");
        merge2.printHeap();
        System.out.println();
        System.out.println("Time taken for merging: " + (endTime2) + " milliseconds");

        // Вывод размера кучи
        System.out.println("Heap size: " + maxHeap.size());

        // Вывод максимального элемента
        System.out.println("Max element: " + maxHeap.peek());

        MaxHeapVA<Integer> f = new MaxHeapVA<>();
        f.add(1);
        f.add(-91);
        f.add(0);
        //f.add(4);
        //f.add(5);
        //f.add(19);
        f.add(-5);
        f.add(10);
        f.add(12);
        f.add(14);
        System.out.println("Current heap: ");
        f.printHeap();
    }
}
