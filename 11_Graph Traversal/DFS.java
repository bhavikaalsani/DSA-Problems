import java.util.*;

class DFS {
    private Map<Integer, List<Integer>> graph;

    public DFS() {
        graph = new HashMap<>();
    }

    public void addEdge(int u, int v) {
        if (!graph.containsKey(u)) {
            graph.put(u, new ArrayList<>());
        }
        graph.get(u).add(v);
    }

    public void DFS(int v) {
        Set<Integer> visited = new HashSet<>();
        DFSUtil(v, visited);
    }

    private void DFSUtil(int v, Set<Integer> visited) {
        visited.add(v);
        System.out.print(v + " ");
        
        for (int neighbor : graph.getOrDefault(v, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        
        // Input: n = 4, e = 6
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        System.out.println("DFS from vertex 1:");
        g.DFS(1);  // Output: 1 2 0 3
        System.out.println();

        // New input: n = 4, e = 6
        Graph g2 = new Graph();
        g2.addEdge(2, 0);
        g2.addEdge(0, 2);
        g2.addEdge(1, 2);
        g2.addEdge(0, 1);
        g2.addEdge(3, 3);
        g2.addEdge(1, 3);
        
        System.out.println("DFS from vertex 2:");
        g2.DFS(2);  // Output: 2 0 1 3
    }
}
