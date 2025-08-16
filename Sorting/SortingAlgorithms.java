package Sorting;
import java.util.*;
public class SortingAlgorithms {

    // Demo array
    static int[] demoArray = {64, 34, 25, 12, 22, 11, 90};

    // ----------------- 1. Bubble Sort -----------------
    static void bubbleSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // ----------------- 2. Selection Sort -----------------
    static void selectionSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    // ----------------- 3. Insertion Sort -----------------
    static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    // ----------------- 4. Merge Sort -----------------
    static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }
    static void merge(int[] array, int left, int middle, int right) {
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        for (int i = 0; i < leftSize; i++) leftArray[i] = array[left + i];
        for (int j = 0; j < rightSize; j++) rightArray[j] = array[middle + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }
        while (i < leftSize) array[k++] = leftArray[i++];
        while (j < rightSize) array[k++] = rightArray[j++];
    }

    // ----------------- 5. Heap Sort -----------------
    static void heapSort(int[] array) {
        int length = array.length;
        for (int i = length / 2 - 1; i >= 0; i--) heapify(array, length, i);
        for (int i = length - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }
    static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        if (leftChild < heapSize && array[leftChild] > array[largest]) largest = leftChild;
        if (rightChild < heapSize && array[rightChild] > array[largest]) largest = rightChild;

        if (largest != rootIndex) {
            int swap = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = swap;
            heapify(array, heapSize, largest);
        }
    }

    // ----------------- 6. Quick Sort -----------------
    static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }
    static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int smallerElementIndex = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                smallerElementIndex++;
                int temp = array[smallerElementIndex];
                array[smallerElementIndex] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[smallerElementIndex + 1];
        array[smallerElementIndex + 1] = array[high];
        array[high] = temp;
        return smallerElementIndex + 1;
    }

    // ----------------- 7. Counting Sort -----------------
    static void countingSort(int[] array) {
        int max = array[0];
        for (int num : array) if (num > max) max = num;

        int[] count = new int[max + 1];
        for (int num : array) count[num]++;

        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i]-- > 0) array[index++] = i;
        }
    }

    // ----------------- 8. Radix Sort -----------------
    static void radixSort(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        for (int exp = 1; max / exp > 0; exp *= 10) countingSortByDigit(array, exp);
    }
    static void countingSortByDigit(int[] array, int exp) {
        int length = array.length;
        int[] output = new int[length];
        int[] count = new int[10];

        for (int i = 0; i < length; i++) count[(array[i] / exp) % 10]++;
        for (int i = 1; i < 10; i++) count[i] += count[i - 1];

        for (int i = length - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }
        for (int i = 0; i < length; i++) array[i] = output[i];
    }

    // ----------------- 9. Bucket Sort -----------------
    static void bucketSort(int[] array) {
        int length = array.length;
        int max = Arrays.stream(array).max().getAsInt();
        int bucketCount = (int) Math.sqrt(length);

        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) buckets.add(new ArrayList<>());

        for (int num : array) {
            int bucketIndex = (num * bucketCount) / (max + 1);
            buckets.get(bucketIndex).add(num);
        }

        int index = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket); // insertionSort alternative
            for (int num : bucket) array[index++] = num;
        }
    }

    // ----------------- 10. Topological Sort -----------------
    static void topologicalSortDemo() {
        int vertices = 6;
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) adjacencyList.add(new ArrayList<>());

        adjacencyList.get(5).add(2); adjacencyList.get(5).add(0);
        adjacencyList.get(4).add(0); adjacencyList.get(4).add(1);
        adjacencyList.get(2).add(3);
        adjacencyList.get(3).add(1);

        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < vertices; i++)
            if (!visited[i]) topoDFS(i, visited, stack, adjacencyList);

        System.out.print("Topological Sort: ");
        while (!stack.isEmpty()) System.out.print(stack.pop() + " ");
        System.out.println();
    }
    static void topoDFS(int vertex, boolean[] visited, Stack<Integer> stack, List<List<Integer>> adjacencyList) {
        visited[vertex] = true;
        for (int neighbor : adjacencyList.get(vertex))
            if (!visited[neighbor]) topoDFS(neighbor, visited, stack, adjacencyList);
        stack.push(vertex);
    }

    // ----------------- 11. Tim Sort (Java built-in) -----------------
    static void timSort(int[] array) {
        Arrays.sort(array); // uses TimSort internally for objects
    }

    // ----------------- Main -----------------
    public static void main(String[] args) {
        int[] array;

        array = demoArray.clone(); bubbleSort(array); System.out.println("Bubble Sort: " + Arrays.toString(array));
        array = demoArray.clone(); selectionSort(array); System.out.println("Selection Sort: " + Arrays.toString(array));
        array = demoArray.clone(); insertionSort(array); System.out.println("Insertion Sort: " + Arrays.toString(array));
        array = demoArray.clone(); mergeSort(array, 0, array.length - 1); System.out.println("Merge Sort: " + Arrays.toString(array));
        array = demoArray.clone(); heapSort(array); System.out.println("Heap Sort: " + Arrays.toString(array));
        array = demoArray.clone(); quickSort(array, 0, array.length - 1); System.out.println("Quick Sort: " + Arrays.toString(array));
        array = demoArray.clone(); countingSort(array); System.out.println("Counting Sort: " + Arrays.toString(array));
        array = demoArray.clone(); radixSort(array); System.out.println("Radix Sort: " + Arrays.toString(array));
        array = demoArray.clone(); bucketSort(array); System.out.println("Bucket Sort: " + Arrays.toString(array));
        topologicalSortDemo();
        array = demoArray.clone(); timSort(array); System.out.println("TimSort (Arrays.sort): " + Arrays.toString(array));
    }
}
