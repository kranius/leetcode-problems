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
	
	// 101. Symmetric Tree
	public boolean isSymmetric(TreeNode<T> root) {
		if (root == null)
			return true;
		return isSymmetricHelper(root.left, root.right);
	}
	
	// helper for 101. Symmetric Tree
	public boolean isSymmetricHelper(TreeNode<T> left, TreeNode<T> right) {
		if (left == null || right == null)
			return (left == right);
		
		if (left.val != right.val)
			return false;
		
		return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
	}
	
	// 104. maximum depth of binary tree
	public int maxDepth(TreeNode<T> root) {
		if (root == null)
			return 0;
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
	
	// 108 convert sorted array to binary search tree
	public TreeNode<Integer> sortedArrayToBST(int[] nums) {
		return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
	}

	private TreeNode<Integer> sortedArrayToBSTHelper(int[] nums, int left, int right) {
		if (right < left)
			return null;
		int mid = left + (right - left) / 2;
		TreeNode<Integer> root = new TreeNode<>(nums[mid]);
		root.left = sortedArrayToBSTHelper(nums, left, mid - 1);
		root.right = sortedArrayToBSTHelper(nums, mid + 1, right);
		return root;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
