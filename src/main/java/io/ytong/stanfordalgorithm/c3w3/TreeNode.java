package io.ytong.stanfordalgorithm.c3w3;

public class TreeNode implements Comparable<TreeNode> {
	private int value;
	private boolean leaf;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(int value, boolean leaf, TreeNode left, TreeNode right) {
		this.value = value;
		this.leaf = leaf;
		this.left = left;
		this.right = right;
	}
	
	public TreeNode(int value, TreeNode left, TreeNode right) {
		this.value = value;
		this.leaf = false;
		this.left = left;
		this.right = right;
	}
	
	public TreeNode(int value) {
		this.value = value;
		this.leaf = true;
		this.left = null;
		this.right = null;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public boolean isLeaf() {
		return leaf;
	}
	
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	
	public TreeNode getLeft() {
		return left;
	}
	
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	
	public TreeNode getRight() {
		return right;
	}
	
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	@Override
	public int compareTo(TreeNode o) {
		// TODO Auto-generated method stub
		return this.value - o.value;
	}
}
