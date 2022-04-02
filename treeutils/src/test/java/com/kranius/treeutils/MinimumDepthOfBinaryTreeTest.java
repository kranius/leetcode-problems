package com.kranius.treeutils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class MinimumDepthOfBinaryTreeTest {
	private TreeUtils<Integer> utils = new TreeUtils<>();
	
	@Test
	public void nullTree() {
		TreeNode<Integer> tree = null;
		
		assertEquals(0, utils.minDepthDFS(tree));
	}
	
	@Test
	public void emptyTree() {
		var tree = new TreeNode<Integer>();
		
		assertEquals(1, utils.minDepthDFS(tree));
	}
	
	@Test
	public void oneElementTree() {
		var tree = new TreeNode<>(42);
		
		assertEquals(1, utils.minDepthDFS(tree));
	}
	
	@Test
	public void simpleTree() {
		var list = Arrays.asList(new Integer[] {1,2,3});
		var actual = utils.constructTreeFromList(list);
		
		assertEquals(2, utils.minDepthDFS(actual));
	}

	@Test
	public void noLeftChildTree() {
		var list = Arrays.asList(new Integer[] {2,null,3,null,4,null,5,null,6});
		var actual = utils.constructTreeFromList(list);
		
		assertEquals(3, utils.minDepthDFS(actual));
	}

	@Test
	public void asymmetricTree() {
		var list = Arrays.asList(new Integer[] {3,9,20,null,null,15,7});
		var actual = utils.constructTreeFromList(list);
		
		assertEquals(2, utils.minDepthDFS(actual));
	}

	@Test
	public void simpleTreeBFS() {
		var list = Arrays.asList(new Integer[] {1,2,3});
		//var actual = utils.constructTreeFromList(list);
		
		TreeNode<Integer> root = new TreeNode<Integer>(1, new TreeNode<Integer>(2), new TreeNode<Integer>(3));
		
		assertEquals(2, utils.minDepthBFS(root));
	}

	
	
	
}
