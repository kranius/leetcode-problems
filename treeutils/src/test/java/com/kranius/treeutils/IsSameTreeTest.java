package com.kranius.treeutils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class IsSameTreeTest {
	private final TreeUtils<Integer> utils = new TreeUtils<>();
	private TreeNode<Integer> p;
	private TreeNode<Integer> q;
	
	@Test
	public void emptyTree() {
		p = null;
		q = new TreeNode<>(1);
		
		assertFalse(utils.isSameTree(p, q));
	}
	
	@Test
	public void sameTree() {
		TreeNode<Integer> left = new TreeNode<>(2);
		TreeNode<Integer> right = new TreeNode<>(3);
		p = new TreeNode<>(1, left, right);
		q = new TreeNode<>(1, left, right);
		
		assertTrue(utils.isSameTree(p, q));
	}
	
	@Test
	public void asymetricTree() {
		TreeNode<Integer> left = new TreeNode<>(2);
		p = new TreeNode<>(1, left, null);
		q = new TreeNode<>(1, null, left);
		
		assertFalse(utils.isSameTree(p, q));
	}
	
	@Test
	public void reversedTree() {
		TreeNode<Integer> left = new TreeNode<>(2);
		TreeNode<Integer> right = new TreeNode<>(3);
		p = new TreeNode<>(1, left, right);
		q = new TreeNode<>(1, right, left);
		
		assertFalse(utils.isSameTree(p, q));
	}
}
