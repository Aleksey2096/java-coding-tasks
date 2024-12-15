import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Implement Dijkstra's algorithm
 */
public class DijkstraShortestPath {
	static class Graph {
		private final Map<Integer, List<int[]>> adjacencyList = new HashMap<>();

		public void addEdge(int source, int destination, int weight) {
			adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(new int[] { destination, weight });
			adjacencyList.computeIfAbsent(destination, k -> new ArrayList<>()).add(new int[] { source, weight });
		}

		public int[] dijkstra(int start, int vertices) {
			int[] distances = new int[vertices];
			Arrays.fill(distances, Integer.MAX_VALUE);
			distances[start] = 0;

			PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
			pq.offer(new int[] { start, 0 });

			while (!pq.isEmpty()) {
				int[] current = pq.poll();
				int node = current[0], dist = current[1];

				if (dist > distances[node])
					continue;

				for (int[] neighbor : adjacencyList.getOrDefault(node, new ArrayList<>())) {
					int nextNode = neighbor[0], weight = neighbor[1];
					if (distances[node] + weight < distances[nextNode]) {
						distances[nextNode] = distances[node] + weight;
						pq.offer(new int[] { nextNode, distances[nextNode] });
					}
				}
			}

			return distances;
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 1);
		graph.addEdge(2, 1, 2);
		graph.addEdge(1, 3, 1);
		graph.addEdge(2, 3, 5);

		int[] distances = graph.dijkstra(0, 4);
		System.out.println("Shortest distances from node 0: " + Arrays.toString(distances));
	}
}
