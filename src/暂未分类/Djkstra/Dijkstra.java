package 暂未分类.Djkstra;

import java.util.HashMap;


public class Dijkstra {
	public static void main(String args[]) {
		System.out.println("dijkstra");
	}
	
	// djkstra
	public static HashMap<Node, Integer> djkstra(Node head, int size) {
		NodeHeap nodeHeap = new NodeHeap(size);
		nodeHeap.addOrUpdateOrIgnore(head, 0);
		HashMap<Node, Integer> res = new HashMap<>();
		while(!nodeHeap.isEmpty()) {
			NodeRecord record = nodeHeap.pop();
			Node cur = record.node;
			int distance = record.distance;
			for(Edge edge : cur.edges) {
				nodeHeap.addOrUpdateOrIgnore(edge.to, edge.weight+distance);
			}
			res.put(cur, distance);
		}
		return res;
	}
	
	// 用于返回的结构，node表示节点，distance表示从源节点到node的最短距离
	public static class NodeRecord {
		public Node node;
		public int distance;
		
		public NodeRecord(Node node, int distance) {
			this.node = node;
			this.distance = distance;
		}
	}
	
	// 自定义的小根堆
	public static class NodeHeap {
		private Node[] nodes;  //实际的堆数组
		private HashMap<Node, Integer> heapIndexMap;  //key：节点  value：节点在堆数组中的索引
		private HashMap<Node, Integer> distanceMap;  //key：节点 value：目前源节点到节点的最小距离
		private int size; //目前堆的节点数量
		
		public NodeHeap(int size) {
			nodes = new Node[size];
			heapIndexMap = new HashMap<>();
			distanceMap = new HashMap<>();
			size = 0;
		}
		
		// 判断堆是否为空
		public boolean isEmpty() {
			return size == 0;
		}

		// 判断节点是否进入过堆
		public boolean isEntered(Node node) {
			return heapIndexMap.containsKey(node);
		}

		// 判断节点现在是否在堆内
		public boolean inHeap(Node node) {
			return isEntered(node) && heapIndexMap.get(node) != -1;   //-1表示当前不在堆内
		}

		// 输入：node， 从源节点到node的距离
		//
		public void addOrUpdateOrIgnore(Node node, int distance) {
			if (inHeap(node)) {
				distanceMap.put(node, Math.min(distanceMap.get(node), distance));
				insertHeapify(node, heapIndexMap.get(node));
			}
			if (!isEntered(node)) {
				nodes[size] = node;
				heapIndexMap.put(node, size);
				distanceMap.put(node, distance);
				insertHeapify(node, size++);
			}
		}

		// 弹出小根堆的根节点，也就是最小值
		public NodeRecord pop() {
			NodeRecord nodeRecord = new NodeRecord(nodes[0], distanceMap.get(nodes[0]));
			swap(0, size-1);
			heapIndexMap.put(nodes[size-1],-1);
			distanceMap.remove(nodes[size-1]);
			nodes[size-1] = null;
			heapify(0, --size);
			return nodeRecord;
		}

		// 向堆中插入节点
		private void insertHeapify(Node node, int index) {
			while (distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index-1)/2])) {
				swap(index, (index-1)/2);
				index = (index-1)/2;
			}
		}

		private void heapify(int index, int size) {
			int left = index * 2 + 1;
			while (left < size) {
				int smallest = left + 1 < size && distanceMap.get(nodes[left + 1]) < distanceMap.get(nodes[left]) ? left + 1 : left;
				smallest = distanceMap.get(nodes[smallest]) < distanceMap.get(nodes[index]) ? smallest : index;
				if (smallest == index) {
					break;
				}
				swap(smallest, index);
				index = smallest;
				left = index * 2 + 1;
			}
		}

		public void swap(int index1, int index2) {
			heapIndexMap.put(nodes[index1], index2);
			heapIndexMap.put(nodes[index2], index1);
			Node tmp = nodes[index1];
			nodes[index1] = nodes[index2];
			nodes[index2] = tmp;
		}
	}
}
