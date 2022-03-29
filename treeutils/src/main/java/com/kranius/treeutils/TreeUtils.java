package com.kranius.treeutils;

import java.util.ArrayList;
import java.util.List;

// implementations of leetcode tree manipulation functions
public class TreeUtils<T> {
	
	// 94. Binary Tree Inorder Traversal
	// inorder traversal = left first
	public List<T> inorderTraversal(TreeNode<T> root) {
		List<T> result = new ArrayList<>();
		
		inorderTraversalHelper(root, result);
		
		return result;
	}
	
	//  helper for 94. inorderTraversal
	private void inorderTraversalHelper(TreeNode<T> root, List<T> result) {
		if (root == null)
			return;
		
		if (root.left != null)
			inorderTraversalHelper(root.left, result);
		
		result.add(root.val); // we add value after all left nodes are traversed
		
		if (root.right != null)
			inorderTraversalHelper(root.right, result);
	}

	// 100. Same Tree
	public boolean isSameTree(TreeNode<T> p, TreeNode<T> q) {
		if (p == null || q == null)
			return (p == q);
		
		if (p.val == q.val)
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		
		return false;
	}
}
