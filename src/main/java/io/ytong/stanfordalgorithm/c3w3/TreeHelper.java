package io.ytong.stanfordalgorithm.c3w3;

import java.util.LinkedList;
import java.util.Queue;

public class TreeHelper {
	
	public static int[] getMaxAndMinLength(TreeNode root) {
		// run level traverse
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		int length = 0;
		int minLength = Integer.MAX_VALUE;
		int maxLength = Integer.MIN_VALUE;
		while (queue.size() > 0) {
			int size = queue.size();
			for (int i=0; i<size; i++) {
				TreeNode curr = queue.poll();
				if (curr.getLeft() != null) {
					queue.add(curr.getLeft());
				}
				if (curr.getRight() != null) {
					queue.add(curr.getRight());
				}
				if (curr.isLeaf()) {
					minLength = Math.min(minLength, length);
					maxLength = Math.max(maxLength, length);
				}
			}
			length++;
		}
		
		int[] lengths = {minLength, maxLength};
		return lengths;
	}
	
}
