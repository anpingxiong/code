package sonBrotherTree;

public class TreeNode {
	private TreeNode sonNode;//这里存储的是最左的儿子节点
	private TreeNode brotherNode;//这里存储的是自己的兄弟节点
	private int value;
	public TreeNode(TreeNode sonNode,TreeNode brotherNode,int value){
		this.sonNode = sonNode;
		this.brotherNode = brotherNode;
		this.value = value;
	}
	public TreeNode  getSonNode(){
		return this.sonNode;
	}
	public TreeNode getBrotherNode() {
		return brotherNode;
	}
	public int getValue(){
		return value;
	}
	
	public void setSonNode(TreeNode sonNode){
		this.sonNode  = sonNode;
	}
	
	public void setBrotherNode(TreeNode brotherNode){
		this.brotherNode  = brotherNode;
	}
	
}

