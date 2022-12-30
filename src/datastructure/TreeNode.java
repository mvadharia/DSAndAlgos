package datastructure;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    Integer value;
    public TreeNode(){
        left=null;
        right=null;
        value=null;
    }
    public TreeNode(TreeNode left, TreeNode right, Integer value){
        this.value=value;
        this.left=left;
        this.right=right;
    }

    public TreeNode addNode(Integer target, TreeNode root){
        if(root==null){
            return new TreeNode(null,null, value);
        }
        if(root.value>target){
            root.left=addNode(target,root.left);
        }else if(root.value<target){
            root.right=addNode(target,root.right);
        }else{
            throw new RuntimeException();
        }
        return root;
    }

    public TreeNode buildBST(int[] arr){
        TreeNode root=null;
        for(int item:arr){
            root=addNode(item,root);
        }
        return root;
    }
    public boolean query(int target, TreeNode root){
        if(root.value>target){
            query(target,root.left);
        }else if (root.value<value){
            query(target,root.right);
        }else{
            return true;
        }
        return false;
    }

    public int getHeight(TreeNode root){
        if(root==null)return 0;
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }

    public int getDepth(TreeNode root, int value, int depth){
        if(root.value==value){
            return depth;
        }
        int leftVal =getDepth(root.left,value,depth+1);
        if(leftVal!=-1)return leftVal;
        int rightVal=getDepth(root.right,value,depth+1);
        if(rightVal!=-1)return rightVal;
        return -1;
    }
}
