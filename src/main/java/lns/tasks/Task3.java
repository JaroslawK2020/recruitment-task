package lns.tasks;

import java.util.*;

public class Task3 implements ConsoleTool {
    public void execute() {
        System.out.println("Task3. Type numbers: ");
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<List<Integer>> connections = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            connections.add(List.of(a, b));
        }
        int result = findSeparatedGraphs(n, connections);
        System.out.println("result: " + result);

        scanner.close();
    }

    private int findSeparatedGraphs(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (List<Integer> integerList : connections) {
            int a = integerList.get(0);
            int b = integerList.get(1);
            if (!graph.containsKey(a)) {
                graph.put(a, new ArrayList<>());
            }
            if (!graph.containsKey(b)) {
                graph.put(b, new ArrayList<>());
            }
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        List<Set<Integer>> setsList = new ArrayList<>();

        for (Integer key : graph.keySet()) {
            setsList.add(isConnected(graph, key));
        }
        List<Set<Integer>> uniqueSets = new ArrayList<>();

        for (Set<Integer> currentSet : setsList) {
            boolean isUnique = true;
            for (Set<Integer> uniqueSet : uniqueSets) {
                if (!Collections.disjoint(currentSet, uniqueSet)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                uniqueSets.add(new HashSet<>(currentSet));
            }
        }
        return uniqueSets.size();
    }

    private Set<Integer> isConnected(Map<Integer, List<Integer>> graph, int key) {
        Set<Integer> visited = new LinkedHashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(key);
        while (!stack.isEmpty()) {
            Integer vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Integer v : graph.get(key)) {
                    stack.push(v);
                }
            }
        }
        return visited;
    }
}


