package homeWork5;



import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class Graph<T> {
	private TreeMap<T, Node<T>> nodeByVlaue;
	int bestDeep;

	public TreeMap<T, Node<T>> getNodeByVlaue() {
		return nodeByVlaue;
	}

	public void setNodeByVlaue() {
		this.nodeByVlaue = new TreeMap<T, Node<T>>();
	}

	public class Node<T> {
		private T value;
		private List<Node> children;
		private Node parent;
		private int deep;

		@SuppressWarnings("rawtypes")
		private Node(T value) {
			setValue(value);
			children = new ArrayList<Node>();

		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public List<Node> getChildren() {
			return children;
		}

		public void setChildren(Node<T> childNodes) {
			getChildren().add(childNodes);
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public int getDeep() {
			return deep;
		}

		public void setDeep(int deep) {
			this.deep = deep;
		}

	}

	public Graph() {
		setNodeByVlaue();
	}

	/**
	 * Create new nod with child. If node exist, add child to them
	 * 
	 * @param value
	 *            - new node
	 * @param newChilds
	 *            - optional - new child
	 */
	@SuppressWarnings("unchecked")
	public void add(T value, T... newChilds) {
		// if parent doesn't exist
		if (!(getNodeByVlaue().containsKey(value))) {
			Node<T> newNode = new Node<T>(value);
			getNodeByVlaue().put(value, newNode);

			for (T child : newChilds) {
				// if child exist
				if (getNodeByVlaue().containsKey(child)) {
					Node<T> churentNewChild = getNodeByVlaue().get(child);
					churentNewChild.setParent(newNode);
					newNode.setChildren(churentNewChild);
					getNodeByVlaue().put(child, churentNewChild);
				}
				// if child doesn't exist
				if (!getNodeByVlaue().containsKey(child)) {
					Node<T> churentNewChild = new Node<T>(child);
					churentNewChild.setParent(newNode);
					newNode.setChildren(churentNewChild);
					getNodeByVlaue().put(child, churentNewChild);
				}
			}
			return;
		}
		// if parent exist
		if (getNodeByVlaue().containsKey(value)) {
			Node<T> currentNode = getNodeByVlaue().get(value);
			for (T child : newChilds) {
				// if child exist
				if (getNodeByVlaue().containsKey(child)) {
					Node<T> churentNewChild = getNodeByVlaue().get(child);
					churentNewChild.setParent(currentNode);
					currentNode.setChildren(churentNewChild);
					getNodeByVlaue().put(child, churentNewChild);
				}
				// if child doesn't exist
				if (!getNodeByVlaue().containsKey(child)) {
					Node<T> churentNewChild = new Node<T>(child);
					churentNewChild.setParent(currentNode);
					currentNode.setChildren(churentNewChild);
					getNodeByVlaue().put(child, churentNewChild);
				}
			}
			getNodeByVlaue().put(value, currentNode);
		}
	}

	@SuppressWarnings("unchecked")
	public void createGraph() {
		System.out.println("Enter the number of edges");
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		int number = Integer.parseInt(s);
		for (int i = 0; i < number; i++) {
			System.out.println("Enter the parent and child separatet by space");
			T[] line = (T[]) scan.nextLine().split(" ");
			T key = line[0];
			if (line.length == 2) {
				this.add(key, (line[1]));
			}
			if (line.length == 1) {
				this.add(key);
			}
		}
	}

	public void print() {
		for (Entry<T, Node<T>> entry : getNodeByVlaue().entrySet()) {
			System.out.println(entry.getKey());
		}

	}

	/**
	 * 
	 * @return root if exist or null if many root - Forest is not a tree. Or No
	 *         Root
	 */
	public Node<T> findRoot() {
		List<Node> listOfRoot = new ArrayList<Node>();
		for (Entry<T, Node<T>> entry : getNodeByVlaue().entrySet()) {
			if (entry.getValue().getParent() == null) {
				listOfRoot.add(entry.getValue());
			}
		}
		if (listOfRoot.size() == 1) {
			if (listOfRoot.get(0).getParent() == null) {
				System.out.println("The root is: "
						+ listOfRoot.get(0).getValue());
				return listOfRoot.get(0);
			}

		} else if (listOfRoot.size() > 1) {
			System.out.println("Forest is not a tree!");
			return null;
		} else {
			System.out.println("No root!");
		}
		return null;
	}

	/**
	 * DFS with recursive
	 */
	private void DFS(Node startNode, int deep) {
		int count = deep;

		Stack<Node> stack = new Stack<Node>();
		Node<T> currentNode = null;

		currentNode = startNode;
		do {
			if (currentNode.getDeep() < count) {
				currentNode.setDeep(count);
			}
			System.out.println("Value: " + currentNode.getValue() + " - Deep: "
					+ currentNode.getDeep());
			for (Node childNode : currentNode.getChildren()) {
				stack.add(childNode);

				this.DFS(childNode, count + 1);
				currentNode = stack.pop();
			}
		} while (stack.size() > 0);
	}

	/**
	 * Recursive method who find the deepest level and print
	 * 
	 * @param k
	 *            - the value of node who want to start
	 * @return
	 * 
	 */
	public void DFS(Node start) {
		DFS(start, 1);
	}

	/**
	 * crawls all nodes from the root to leaves and back list with leaves
	 * 
	 * @return the list of leaf
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Queue<Node> findLeaf() {
		Stack<Node> stack = new Stack<Node>();
		Queue<Node> listLeaf = new LinkedList<Node>();
		Node<T> currentNode = this.findRoot();

		stack.add(currentNode);
		do {
			currentNode = stack.pop();

			for (Node childNode : currentNode.getChildren()) {
				stack.add(childNode);
				if (childNode.getChildren().size() == 0) {
					listLeaf.add(childNode);
				}
			}
		} while (stack.size() > 0);

		return listLeaf;
	}

	public void sumLongPath() {
		Queue<Node> leafs = this.findLeaf();
		TreeMap<Integer, Node<T>> maxAmountLeaf = new TreeMap<Integer, Node<T>>();
		@SuppressWarnings("unchecked")
		int sum = 0;
		while (leafs.size() > 0) {
			Node<T> currentNode = leafs.poll();
			System.out.print("Leaf " + currentNode.getValue() + " ");
			do {
				String currentValue = (String) currentNode.getValue();
				sum += Integer.parseInt(currentValue);
				currentNode = currentNode.getParent();
				if (currentNode.getParent() == null) {
					String rootValue = (String) currentNode.getValue();
					sum += Integer.parseInt(rootValue);
				}
			} while (currentNode.getParent() != null);
			System.out.println("- Sum " + sum);
			sum = 0;
		}
		;

	}

}
