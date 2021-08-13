import com.sun.source.tree.Tree;
import org.springframework.boot.SpringApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * 前序遍历和回溯， 输出 二叉树中，所有从根节点到业子节点的路径。
 */
public class Solution {
    //di gui fang fa
    public List<String> binaryTreePaths(TreeNode root){
        List<String> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        List<Integer> paths = new ArrayList<>();
        traversal(root,paths,res);
        return res;
    }
    private void traversal(TreeNode root, List<Integer> paths, List<String> res) {
        paths.add(root.val);
        // leaf node
        if(root.left==null && root.right == null){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<paths.size()-1;i++){
                // output
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size()-1));
            res.add(sb.toString());
            return;
        }
        if(root.left!=null){
            traversal(root.left,paths,res);
            paths.remove(paths.size()-1);// hui su
        }
        if(root.right!=null){
            traversal(root.right,paths,res);
            paths.remove(paths.size()-1); //hui su
        }
    }


    public static void main(String[] args){
        Solution solution = new Solution();
        TreeNode leve3right = new TreeNode(5,null,null);
        TreeNode leve2right = new TreeNode(3,null,null);
        TreeNode leve2left = new TreeNode(2,null,leve3right);
        TreeNode root = new TreeNode(1,leve2left,leve2right);
        List<String> res = solution.binaryTreePaths(root);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }

    }
}
class TreeNode {
    public Integer val;

    public TreeNode left;
    public TreeNode right;
    public TreeNode(Integer val,TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
