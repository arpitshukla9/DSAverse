import java.util.*;

public class SearchingAlgorithms {

    static int[] demoArray = {2, 4, 7, 10, 15, 20, 25, 30};

    // 1. Linear Search
    static int linearSearch(int[] array, int target) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == target) return index;
        }
        return -1;
    }

    // 2. Binary Search
    static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) return mid;
            if (array[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // 3. Jump Search
    static int jumpSearch(int[] array, int target) {
        int length = array.length;
        int step = (int) Math.floor(Math.sqrt(length));
        int prev = 0;

        while (array[Math.min(step, length) - 1] < target) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(length));
            if (prev >= length) return -1;
        }
        while (prev < Math.min(step, length)) {
            if (array[prev] == target) return prev;
            prev++;
        }
        return -1;
    }

    // 4. Exponential Search
    static int exponentialSearch(int[] array, int target) {
        if (array[0] == target) return 0;
        int index = 1;
        while (index < array.length && array[index] <= target) index *= 2;
        return Arrays.binarySearch(array, index / 2, Math.min(index, array.length), target);
    }

    // 5. BFS in Graph
    static void bfs(int vertices, List<List<Integer>> adjacencyList, int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");
            for (int neighbor : adjacencyList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // 6. DFS in Graph
    static void dfs(int vertex, boolean[] visited, List<List<Integer>> adjacencyList) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited[neighbor]) dfs(neighbor, visited, adjacencyList);
        }
    }

    public static void main(String[] args) {
        System.out.println("Linear Search (10): " + linearSearch(demoArray, 10));
        System.out.println("Binary Search (25): " + binarySearch(demoArray, 25));
        System.out.println("Jump Search (15): " + jumpSearch(demoArray, 15));
        System.out.println("Exponential Search (30): " + exponentialSearch(demoArray, 30));

        // Graph for BFS & DFS
        int vertices = 6;
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) adjacencyList.add(new ArrayList<>());
        adjacencyList.get(0).addAll(Arrays.asList(1, 2));
        adjacencyList.get(1).addAll(Arrays.asList(3));
        adjacencyList.get(2).addAll(Arrays.asList(4, 5));

        bfs(vertices, adjacencyList, 0);

        System.out.print("DFS Traversal: ");
        boolean[] visited = new boolean[vertices];
        dfs(0, visited, adjacencyList);
    }
}
