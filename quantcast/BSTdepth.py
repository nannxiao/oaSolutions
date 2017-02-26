 
public class Solution {
    public int countLeaves(TreeNode node) {
    // Return the number of leaves in the tree to which node points.
        if (node == null)
            return 0;
        else if (node.left == null && node.right == null)
            return 1;  // Node is a leaf.
        else
            return countLeaves(node.left) + countLeaves(node.right);
    }
    static int sumOfLeafDepths( TreeNode node, int depth ) {
    
        if ( node == null ) {
        // Since the tree is empty and there are no leaves, the sum is zero.
            return 0;
        }
        else if ( node.left == null && node.right == null) {
        // The node is a leaf, and there are no subtrees of node, so
        // the sum of the leaf depth is just the depths of this node.
            return depth;
        }
        else {
        // The node is not a leaf.  Return the sum of the
        // the depths of the leaves in the subtrees.
            return sumOfLeafDepths(node.left, depth + 1) + sumOfLeafDepths(node.right, depth + 1);
        }
    }

    public static void main(String[] args) {
           
        int leafCount = countLeaves(root);
        int depthSum = sumOfLeafDepths(root,0);
        double averageDepth = ((double)depthSum) / leafCount;
        System.out.println("Maximum depth of leaves:  " + depthMax);
   
    }

        
}
