package io.ytong.stanfordalgorithm.c3w3;

import java.util.PriorityQueue;

public class HuffmanSolver {
	
	public static TreeNode buildHuffmanTree(int[] weights) {
		// init
		PriorityQueue<TreeNode> pq = new PriorityQueue<TreeNode>();
		for (int weight : weights) {
			TreeNode node = new TreeNode(weight);
			pq.add(node);
		}
		
		// build tree
		while(pq.size() > 1) {
			TreeNode node = pq.poll();
			TreeNode node2 = pq.poll();
			
			int newValue = node.getValue() + node2.getValue();
			TreeNode parent = new TreeNode(newValue, node, node2);
			pq.add(parent);
		}
		
		TreeNode root = pq.poll();
		return root;
	}

}
