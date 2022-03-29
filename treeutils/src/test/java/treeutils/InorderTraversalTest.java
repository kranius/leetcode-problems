package treeutils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.kranius.treeutils.TreeNode;
import com.kranius.treeutils.TreeUtils;

// tests for 94 inorder binary tree traversal
public class InorderTraversalTest {
	
	private TreeUtils<Integer> utils = new TreeUtils<>();
	private TreeNode<Integer> root;
	private List<Integer> result;
	
	@Test
	public void emptyTree() {
		root = null;
		
		assertTrue(utils.inorderTraversal(root).isEmpty());
	}

	@Test
	public void oneElementTree() {
		root = new TreeNode<>(42);
		result = utils.inorderTraversal(root);
		
		assertEquals(result.size(), 1);
		assertEquals(result.get(0), 42);
	}
	
	@Test
	public void noLeftSubtreeTree() {
		TreeNode<Integer> right_left = new TreeNode<>(3);
		TreeNode<Integer> right = new TreeNode<>(2, right_left, null);
		root = new TreeNode<>(1, null, right);
		result = utils.inorderTraversal(root);
		
		assertArrayEquals(result.toArray(), new Integer[] {1,3,2});
	}
}
