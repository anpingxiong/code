package TreeTest;

import org.junit.Test;

import queryTwoForkTree.QueryTwoForkTree;
import queryTwoForkTree.TreeNode;

public class TreeJunitTest {
	@Test
	public void testInsertMethod(){
		TreeNode node = new TreeNode(null,null,null,2);
		QueryTwoForkTree  tree  = new QueryTwoForkTree(node);
		tree.insertNode(3);
		tree.insertNode(1);
		 System.out.println(node.getLeftChildren().getData()+"---"+node.getRightChildren().getData());
		
		tree.insertNode(6);
		tree.insertNode(5);
		
		System.out.println(node.getRightChildren().getRightChildren().getLeftChildren().getData());
	}
	
	@Test
	public void testSearchMethod(){
		TreeNode node = new TreeNode(null,null,null,2);
		QueryTwoForkTree  tree = new QueryTwoForkTree(node);
		tree.insertNode(3);
		tree.insertNode(1);
		tree.insertNode(6);
		tree.insertNode(5);
		
		System.out.println(tree.search(3).getData());
		
	}
	
	@Test
	public void testGetMaxValue(){
		TreeNode node = new TreeNode(null,null,null,2);
		QueryTwoForkTree  tree = new QueryTwoForkTree(node);
		tree.insertNode(3);
		tree.insertNode(1);
		tree.insertNode(6);
		tree.insertNode(5);
		tree.insertNode(100);
		System.out.println(tree.getMaxValue(tree.getRoot()).getData());
	}
	
	@Test
	public void testGetMinValue(){
		TreeNode node = new TreeNode(null,null,null,2);
		QueryTwoForkTree  tree = new QueryTwoForkTree(node);
		tree.insertNode(3);
		tree.insertNode(1);
		tree.insertNode(6);
		tree.insertNode(5);
		tree.insertNode(0);
		System.out.println(tree.getMinValue(tree.getRoot()).getData());
	}
	@Test
	public  void testSuccessor(){
		TreeNode node = new TreeNode(null,null,null,2);
		QueryTwoForkTree  tree = new QueryTwoForkTree(node);
		tree.insertNode(3);
		tree.insertNode(1);
		tree.insertNode(6);
		tree.insertNode(5);
		tree.insertNode(0);
		System.out.println(tree.successor(0).getData());
		
	}
}
