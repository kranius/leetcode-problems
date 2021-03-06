package com.kranius.treeutils;

import java.util.*;

// implementations of leetcode tree manipulation functions
public class TreeUtils<T> {

	public TreeNode<T> constructTreeFromList(List<T> list) {
		if (list == null || list.isEmpty())
			return null;
		return constructTreeFromListHelper(list, 0);
	}

	private TreeNode<T> constructTreeFromListHelper(List<T> list, int index) {
		if (list.size() <= index || list.get(index) == null)
			return null;
		TreeNode<T> node = new TreeNode<>(list.get(index));
		node.left = constructTreeFromListHelper(list, 2 * index + 1);
		node.right = constructTreeFromListHelper(list, 2 * index + 2);
		return node;
	}

	// 94. Binary Tree Inorder Traversal
	// inorder traversal = left first
	public List<T> inorderTraversal(TreeNode<T> root) {
		List<T> result = new ArrayList<>();
		inorderTraversalHelper(root, result);
		return result;
	}

	// helper for 94. inorderTraversal
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
	private boolean isSymmetricHelper(TreeNode<T> left, TreeNode<T> right) {
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

	// helper for 108: sorted array to BST
	private TreeNode<Integer> sortedArrayToBSTHelper(int[] nums, int left, int right) {
		if (right < left)
			return null;
		int mid = left + (right - left) / 2;
		TreeNode<Integer> root = new TreeNode<>(nums[mid]);
		root.left = sortedArrayToBSTHelper(nums, left, mid - 1);
		root.right = sortedArrayToBSTHelper(nums, mid + 1, right);
		return root;
	}

	// 110. balanced binary tree
	// my solution doesn't seem optimal, we iterate through elements multiple time
	public boolean isBalanced(TreeNode<T> root) {
		if (root == null)
			return true;
		int left = computeHeight(root.left);
		int right = computeHeight(root.right);
		return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}

	// helper for 110. balanced binary tree
	public int computeHeight(TreeNode<T> root) {
		if (root == null)
			return 0;
		return Math.max(computeHeight(root.left), computeHeight(root.right)) + 1;
	}

	// 111. minimum depth of binary tree
	// obvious solution is classic depth first search
	public int minDepthDFS(TreeNode<T> root) {
		if (root == null)
			return 0;
		int left = minDepthDFS(root.left);
		int right = minDepthDFS(root.right);
		if (left == 0 || right == 0) // only one child ?
			return Math.max(left, right) + 1; // we return depth of side with a child ie MAX(left, right)
		return Math.min(left, right) + 1; // two childs = we return smallest depth ie MIN(left, right)
	}

	// 111. minimum depth of binary tree
	// here we use breadth first search
	// wikipedia procedure :
	//
	// procedure BFS(G, root) is
	// let Q be a queue
	// label root as explored
	// Q.enqueue(root)
	// while Q is not empty do
	// v := Q.dequeue()
	// if v is the goal then
	// return v
	// for all edges from v to w in G.adjacentEdges(v) do
	// if w is not labeled as explored then
	// label w as explored
	// Q.enqueue(w)
	//
	public int minDepthBFS(TreeNode<T> root) {
		if (root == null)
			return 0;
		Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
		queue.offer(root);
		int level = 1;

		while (queue.isEmpty() == false) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode<T> node = queue.poll();
				if (node.left == null && node.right == null)
					return level;
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			}
			level++;
		}
		return level;
	}

	// 112. Path Sum
	// root to leaf = sum
	public  boolean hasPathSum(TreeNode<Integer> root, int targetSum) {
		if (root == null)
			return false;

		if (root.val == null && root.right == null && targetSum-root.val == 0)
			return true;

		return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
	}

	// 144. Binary tree preorder traversal
	public List<T> preorderTraversal(TreeNode<T> root) {
		List<T> result = new ArrayList<>();
		preorderTraversalHelper(root, result);
		return result;
	}

	// recursion helper for 144. preorder traversal
	private List<T> preorderTraversalHelper(TreeNode<T> root, List<T> result) {
		if (root == null)
			return result;

		result.add(root.val);

		if (root.left != null)
			preorderTraversalHelper(root.left, result);

		if (root.right != null)
			preorderTraversalHelper(root.right, result);

		return result;
	}

	// 145. Binary tree postorder traversal
	public List<T> postorderTraversal(TreeNode<T> root) {
		List<T> result = new ArrayList<>();
		postorderTraversalHelper(root, result);
		return result;
	}

	// recursion helper for 145. postorder traversal
	private List<T> postorderTraversalHelper(TreeNode<T> root, List<T> result) {
		if (root == null)
			return result;

		if (root.left != null)
			postorderTraversalHelper(root.left, result);

		if (root.right != null)
			postorderTraversalHelper(root.right, result);

		result.add(root.val);

		return result;
	}


	// 235. Lowest Common Ancestor of a BST
	// p and q are in the same subtree <=> both p and q are smaller or both p and q are bigger than root
	public TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
		// 3 cases :
		// p and q are smaller than root (we check left subtree)
		// p and q are bigger (we check right subtree)
		// otherwise ancestor = current root

		while ((root.val - p.val) * (root.val - q.val) > 0) // we check the sign of the product of the difference
			root = p.val < root.val ? root.left : root.right; // if p and q smaller we go left else we go right
		return root;
	}


	// 257 Binary Tree Paths
	public List<String> binaryTreePaths(TreeNode<T> root) {
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		binaryTreePathsHelper(result, root, sb);

		return result;
	}

	private void binaryTreePathsHelper(List<String> result, TreeNode<T> root, StringBuilder sb) {
		if (root == null) {
			return;
		}

		int len = sb.length();
		sb.append(root.val);

		if (root.left == null && root.right == null) {
			result.add(sb.toString());
		} else {
			sb.append("->");
			binaryTreePathsHelper(result, root.left, sb);
			binaryTreePathsHelper(result, root.right, sb);
		}
		sb.setLength(len);
	}
}