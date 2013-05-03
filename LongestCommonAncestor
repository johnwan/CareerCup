import javax.swing.tree.TreeNode;


public class LCA {
  TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if (root == null){
			return null;
		}
		if (root == p && root == q){
			return root;
		}
		
		TreeNode x = commonAncestor(root.left,p,q);
		if ( x!=null && x!=p && x!=q ){
			return x;
		}
		
		TreeNode y = commAncestor(root.right,p,q);
		if ( y!=null && y!=p && y!=q ){
			return y;
		}
		
		if (x!=null && y!= null){
			return root;
			
		} else if(root == p || root == q){
			return root;
		} else {//if either x or y is non-null, return the non-null value
			return x== null ? y:x;
		}
		
		
		
	}

}
