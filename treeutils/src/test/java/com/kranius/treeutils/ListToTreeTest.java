package com.kranius.treeutils;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ListToTreeTest {
	private TreeUtils<Integer>	utils = new TreeUtils<>();
	
	@Test
	public void emptyTree() {
		var p = utils.constructTreeFromList(null);
		assertNull(p);
	}
	
	@Test
	public void basicTree() {
		List<Integer> list = Arrays.asList(new Integer[] {1,2,3});
		TreeNode<Integer> actual = utils.constructTreeFromList(list);
		TreeNode<Integer> expected = new TreeNode<>(1, new TreeNode<>(2), new TreeNode<>(3));
		
		assertTrue(utils.isSameTree(actual, expected));
	}
	
	@Test
	public void onlyOneChild() {
		List<Integer> list = Arrays.asList(new Integer[] {1,null,3});
		TreeNode<Integer> actual = utils.constructTreeFromList(list);
		TreeNode<Integer> expected = new TreeNode<>(1, null, new TreeNode<>(3));
		
		assertTrue(utils.isSameTree(actual, expected));	
	}
}
