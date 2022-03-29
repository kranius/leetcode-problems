package com.kranius.treeutils;

// as per leetcode naming
// I implement with generics because why not
public class TreeNode<T> {
	T val;
	TreeNode<T> left;
	TreeNode<T> right;
	
	public TreeNode() {
		
	}
	
	public TreeNode(T val) {
		this.val = val;
	}
	
	public TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
