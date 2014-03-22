package queryTwoForkTree;
/**
 * 
 * @author anping
 * 树节点类，data 使用int 型来演示
 */
public class TreeNode {
	public TreeNode(TreeNode parent ,TreeNode leftChild,TreeNode rightChild,int data){
		this.parent  = parent;
		this.leftChildren = leftChild;
		this.rightChildren  = rightChild;
		this.data = data;
	}
	
	public TreeNode getParent() {
		return parent;
	}
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	public TreeNode getLeftChildren() {
		return leftChildren;
	}
	public void setLeftChildren(TreeNode leftChildren) {
		this.leftChildren = leftChildren;
	}
	public TreeNode getRightChildren() {
		return rightChildren;
	}
	public void setRightChildren(TreeNode rightChildren) {
		this.rightChildren = rightChildren;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
	private TreeNode parent;
	private TreeNode leftChildren;
	private TreeNode rightChildren;
	private int data;
	
	
}
