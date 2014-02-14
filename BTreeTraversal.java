package tree;  
  
import java.util.Stack;  
  
// 二叉树节点   
class BTNode {  
    private char key;  
    private BTNode left, right;  
    public BTNode(char key) {      //新建一个值为key的结点  
        this(key, null, null);  
     }  
    public BTNode(char key, BTNode left, BTNode right) {  
        this.key = key;            //新建一个结点，并指定其左右结点  
        this.left = left;  
        this.right = right;  
     }  
    public char getKey() {         //返回结点的值  
        return key;  
     }  
    public void setKey(char key) { //设定结点的值  
        this.key = key;  
     }  
    public BTNode getLeft() {      //返回其左孩子结点  
        return left;  
     }  
    public BTNode getRight() {     //返回其右孩子结点  
        return right;  
     }  
    public void setLeft(BTNode left) {//设定其左孩子结点  
        this.left = left;  
     }  
    public void setRight(BTNode right) {//设定其右孩子结点  
        this.right = right;  
     }  
}  
//二叉树遍历   
public class BinTree {  
    protected BTNode root;  
    public BinTree(BTNode root) {  
        this.root = root;  
     }  
    public BTNode getRoot() {  
        return root;  
     }  
    //构造树  
    public static BTNode init() {  
         BTNode a = new BTNode('A');  
         BTNode b = new BTNode('B', null, a);  
         BTNode c = new BTNode('C');  
         BTNode d = new BTNode('D', b, c);  
         BTNode e = new BTNode('E');  
         BTNode f = new BTNode('F', e, null);  
         BTNode g = new BTNode('G', null, f);  
         BTNode h = new BTNode('H', d, g);  
         return h;             // 返回根结点  
     }  
    //访问节点  
    public static void visit(BTNode p) {  
         System.out.print(p.getKey() + " ");  
     }  
    //递归实现前序遍历  
    protected static void preorder(BTNode p) {  
        if (p != null) {  
             visit(p);  
             preorder(p.getLeft());  
             preorder(p.getRight());  
         }  
     }  
    //递归实现中序遍历  
    protected static void inorder(BTNode p) {  
        if (p != null) {  
             inorder(p.getLeft());  
             visit(p);  
             inorder(p.getRight());  
         }  
     }  
    //递归实现后序遍历   
    protected static void postorder(BTNode p) {  
        if (p != null) {  
             postorder(p.getLeft());  
             postorder(p.getRight());  
             visit(p);  
         }  
     }  
    //非递归实现前序遍历  
    protected static void iterativePreorder(BTNode p){  
        Stack<BTNode> stack = new Stack<BTNode>();  
        if(p!=null){  
            stack.push(p);  
            while(!stack.empty()){  
                p = stack.pop();  
                visit(p);  
                //右子结点先进栈，左子结点再进栈，所以先访问的是左子结点            
                if(p.getRight()!= null)  
                    stack.push(p.getRight());  
                if(p.getLeft()!= null)  
                    stack.push(p.getLeft());  
            }  
        }  
    }  
    /* 非递归实现后序遍历 
     * 除了最左的一个左子结点，把所有的左子结点相继入栈（是一个循环过程） 
     * 这时p指向最左的那个左子结点， 
     * 重复：若p没有右子结点（或者p的右子结点已经输出），则输出p，同时出栈，将值赋给p 
     * 若p有右子结点，则将p入栈，同时p指向其右子结点 
     * 重复以上步骤，直到p为空 
     */  
    protected static void iterativePostorder(BTNode p){  
        BTNode q = p;  
        Stack<BTNode> stack = new Stack<BTNode>();  
        while(p!=null){  
            //所有的左子结点相继入栈，除了最后一个  
            while(p.getLeft()!=null){  
                stack.push(p);  
                p = p.getLeft();  
            }  
            //当前节点无右子结点或右子结点已经输出  
            while(p.getRight()==null||p.getRight()==q){  
                visit(p);  
                q = p;//记录上一个已输出节点  
                if(stack.empty())  
                    return;  
                p = stack.pop();  
            }  
            //处理右子结点  
            stack.push(p);//如果上面的while循环没有执行，那么此处入栈的是最左的一个左子结点  
            p = p.getRight();//这里p的右子结点必定不会为空  
        }  
    }  
    //非递归实现中序遍历  
    protected static void iterativeInorder(BTNode p){  
        Stack<BTNode> stack = new Stack<BTNode>();  
        while(p!= null){  
            while(p!=null){  
                if(p.getRight()!=null)  
                    stack.push(p.getRight());//当前右子结点入栈  
                stack.push(p);//当前节点入栈  
                p = p.getLeft();  
            }  
            p = stack.pop();  
            while(!stack.empty()&& p.getRight()== null){  
                visit(p);  
                p = stack.pop();  
            }  
            visit(p);  
            if(!stack.empty())  
                p = stack.pop();  
            else  
                p = null;  
        }  
    }  
    public static void main(String[] args){  
        BinTree tree = new BinTree(init());    
        System.out.print("前序遍历:");  
        preorder(tree.getRoot());  
        System.out.print("/n中序遍历:");  
        inorder(tree.getRoot());  
        System.out.print("/n后序遍历:");  
        postorder(tree.getRoot());  
        //以下为非递归遍历二叉树  
        System.out.print("/n/n前序遍历:");  
        iterativePreorder(tree.getRoot());  
        System.out.print("/n中序遍历:");  
        iterativeInorder(tree.getRoot());  
        System.out.print("/n后序遍历:");  
        iterativePostorder(tree.getRoot());  
    }  
}  
