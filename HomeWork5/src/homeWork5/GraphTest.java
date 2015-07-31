package homeWork5;

import homeWork5.Graph.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class GraphTest {

	public static void main(String[] args) {
		Graph<Integer> myGraph = new Graph<Integer>();

		myGraph.createGraph();

		myGraph.DFS(myGraph.findRoot());

		Queue<Node> leaf = myGraph.findLeaf();

		for (Node node : leaf) {
			System.out.println("leaf " + node.getValue());
		}
		System.out.println("--------------------------");
		myGraph.sumLongPath();

	}
}
