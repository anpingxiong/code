package queryTwoForkTree;
/**
 * 查询二叉树的中序遍历是将树按照值的顺序读取出来
 * 通过中序遍历拿到的前驱和后继是方便于二叉树的节点删除的，使用后继节点来替换它，而后继一定是叶子节点
 * @author anping
 * 查询二叉树
 */
public class QueryTwoForkTree {
	
	
	public QueryTwoForkTree(TreeNode root){
		this.root = root;
	}
	/**
	 * 插入树节点
	 * @param node  这个是需要插入的节点
	 * 在这里插入的规则，节点需要插入在合适的地方。在插入的时候，节点都是始终在当前树的叶子节点中
	 * 也就是说需要从根节点开始，不断的往下比较，如果最后比较的节点没有当前节点大且该节点没有了右孩子则将该节点作为右孩子插入
	 * 相反，将器插入在左边作为孩子插入
	 */
	public void insertNode(int  data){
		TreeNode currentNode = this.root;
		while(currentNode!=null){
			
			//如果大于当前的节点，那么判断当前节点是否有孩子，如果有则插入在右侧
			if(data>currentNode.getData()){
				
				if(currentNode.getRightChildren()!=null){
					currentNode = currentNode.getRightChildren();
				}else{
					currentNode.setRightChildren(new TreeNode(currentNode, null, null, data));
					currentNode = null;
				 }
		 	}
			//否则在左侧判断
			else {
			   
				if(currentNode.getLeftChildren()!=null){
					currentNode = currentNode.getLeftChildren();
				}else{
					currentNode.setLeftChildren(new TreeNode(currentNode, null, null, data));
					currentNode = null;
				 }
				
			}	
	 	}
	}
	
	/**
	 * 删除节点 ，表面是删除数据，本质是将节点也删除
	 * @param data   需要删除的值
	 * 删除数据时应该先查询到数据在哪里，取到具体需要删除的节点之后，就需要按照删除的规则来走。
	 * 它如果没有孩子节点的话就可以直接删除而不需要额外的操作，
	 * 
	 * 
	 */
	public void deleteNode (int data){
		
	}
	
	/**
	 * 查找数据
	 * @param data 需要查找的数据的值
	 * @return  返回的是查找数据的节点。  为什么返回的是TreeNode 而不直接是true,false 
	 * 因为为了方便查找方法的复用，比如在删除的时候，首先就得先查找，然后在删除查找到的节点。
	 * 
	 * 搜索比较简单，和插入一样可以使用循环来操作，一直搜索到叶子节点，如果没有则返回的是null,
	 * 相反返回的就是当前的节点，只取出第一次相匹配的节点
	 */
	public TreeNode search(int data){
		 
		TreeNode currentNode  = this.root;
		TreeNode resultNode = null;
		while(currentNode!=null){
			if(data==currentNode.getData()){
				resultNode =currentNode;
				currentNode = null;
			}else if(data>currentNode.getData()){
				if(currentNode.getRightChildren()==null){
					currentNode =null;
				}else{
					currentNode = currentNode.getRightChildren();
				}
				
			}else{
				if(currentNode.getLeftChildren()==null){
					currentNode =null;
				}else{
					currentNode = currentNode.getLeftChildren();
				}
				
			}
			
		}
		
		return resultNode;
	}
	
	/**
	 * 拿到的树的最大值 
	 * @return  返回的是树的最小值节点
	 * 最大   的节点一定是父亲节点的右节点，并且是最做的右叶子节点
	 */
	public TreeNode getMaxValue(TreeNode currentNode){
		 
		
		while(currentNode.getRightChildren()!=null){
			currentNode  = currentNode.getRightChildren();
		}
		return currentNode;
	}
	/**
	 * 拿到的是树的最小值
	 * @return  返回的是树的最小值节点
	 * 最小的节点一定是父亲节点的左节点，并且是最做的左叶子节点
	 */
	public  TreeNode getMinValue(TreeNode currentNode){
		 
		while(currentNode.getLeftChildren()!=null){
			currentNode = currentNode.getLeftChildren();
		}
		return currentNode;
	}
	
	/**
	 * 返回的树的前驱节点（树以中序遍历）
	 * @param data   需要查找节点数据
	 * @return  返回的数据所在节点的前驱节点
	 *    通过分析树的结构将会发现：当节点是叶子节点的时候，那么需要往上去找前驱。并且是右叶子节点就是父亲节点，而
	 *    左叶子节点是一直往上找，直到不是它的左节点为止。
	 *    但是对于有孩子的左节点的话比较简单，直接拿取左节点孩子树中最大的值
	 */
	public TreeNode successor(int data){
		TreeNode   node = this.search(data);//首先我拿到当前的节点
		//如果当前节点有左孩子的话，直接拿取孩子的最大值
		if(node.getLeftChildren()!=null){
			return this.getMaxValue(node.getLeftChildren());
		}
		
		//如果没有的话那么就需要去往上需找到合适的
		TreeNode parent  = node.getParent();
		if(parent!=null && node==parent.getLeftChildren()){
			node = parent;
			parent= parent.getParent();
		}
		
		
		return parent;
	}
	/**
	 * 返回的是的后继节点（树以中序遍历）
	 * @param data  需要查找的节点数据
	 * @return   返回数据所在节点的后继节点
	 *  前驱和后继是没有差别的，不用思考就是说将左孩子修改成右孩子处理，如果有右孩子的话，那么寻找左孩子树中最小的值
	 *  没有的话，如果是左节点那么后继就是父亲，否则就是往上寻找知道不是右节点为止
	 */
	public TreeNode predecessor(int data){
		TreeNode   node = this.search(data);//首先我拿到当前的节点
		//如果当前节点有左孩子的话，直接拿取孩子的最大值
		if(node.getRightChildren()!=null){
			return this.getMaxValue(node.getRightChildren());
		}
		
		//如果没有的话那么就需要去往上需找到合适的
		TreeNode parent  = node.getParent();
		if(parent!=null && node==parent.getRightChildren()){
			node = parent;
			parent= parent.getParent();
		}
		
		
		return parent;
	}
	private TreeNode root;
	public TreeNode getRoot() {
		return root;
	}
	
	
	
}
