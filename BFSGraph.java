import java.util.LinkedList;
import java.util.Queue;

/*
 * Breadth-First Search (BFS) Algorithm
 */
public class BFSGraph {
	private final int vertices;
	private final LinkedList<Integer>[] adjacencyList;

	@SuppressWarnings("unchecked")
	public BFSGraph(int vertices) {
		this.vertices = vertices;
		adjacencyList = new LinkedList[vertices];
		for (int i = 0; i < vertices; i++) {
			adjacencyList[i] = new LinkedList<>();
		}
	}

	public void addEdge(int source, int destination) {
		adjacencyList[source].add(destination);
	}

	public void bfs(int start) {
		boolean[] visited = new boolean[vertices];
		Queue<Integer> queue = new LinkedList<>();
		visited[start] = true;
		queue.add(start);

		while (!queue.isEmpty()) {
			int vertex = queue.poll();
			System.out.print(vertex + " ");

			for (int neighbor : adjacencyList[vertex]) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					queue.add(neighbor);
				}
			}
		}
	}

	public static void main(String[] args) {
		BFSGraph graph = new BFSGraph(6);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 5);

		System.out.print("BFS Traversal: ");
		graph.bfs(0);
	}
}
