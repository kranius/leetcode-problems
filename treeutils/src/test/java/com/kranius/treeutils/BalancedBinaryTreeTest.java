package com.kranius.treeutils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class BalancedBinaryTreeTest {
	private final TreeUtils<Integer> utils = new TreeUtils<>();

	@Test
	public void properTree() {
		var list = Arrays.asList(new Integer[] {3,9,20,null,null,15,7});
		var root = utils.constructTreeFromList(list);
		
		assertTrue(utils.isBalanced(root));
	}
	
	@Test
	public void malformedTree() {
		var list = Arrays.asList(new Integer[] {1,2,2,3,3,null,null,4,4});
		var root = utils.constructTreeFromList(list);
		
		assertFalse(utils.isBalanced(root));	
	}
}
