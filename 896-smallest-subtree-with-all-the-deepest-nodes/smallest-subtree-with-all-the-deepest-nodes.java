/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     class Node {
        TreeNode treeNode;
        int maxDepth;

        Node(TreeNode t, int d) {
            treeNode = t;
            maxDepth = d;
        }
    }

    // TC: O(n) to traverse all the nodes in the tree
    // SC: O(n) for the call stack and to store return types for all nodes
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        // base condition
        if (root == null) {
            return null;
        }
        // recursive helper function to find the min subtree for this node
        return findSubTree(root).treeNode;
    }

    // TC: O(n) to traverse all the nodes in the tree
    // SC: O(n) for the call stack and to store return types for all nodes
    private Node findSubTree(TreeNode root) {
        // if root is null, then return null and some bogus depth
        if (root == null) {
            return new Node(null, Integer.MIN_VALUE);
        }
        // if leaf node then return that node with depth 1
        if (root.left == null && root.right == null) {
            return new Node(root, 1);
        }
        // recursively find the answer for left and right sub trees
        Node left = findSubTree(root.left);
        Node right = findSubTree(root.right);
        // if depth of left and right are equal then include the curent node because that forms the complete tree
        if (left.maxDepth == right.maxDepth) {
            return new Node(root, left.maxDepth + 1);
        }
        // if not equal, find the subtree that has maximum depth and return that reference to bubble up, also make sure to carry the increasing max depth so that when comparign with other sub trees, we compare it with accurate number
        if (left.maxDepth > right.maxDepth) {
            return new Node(left.treeNode, left.maxDepth + 1);
        }
        return new Node(right.treeNode, right.maxDepth + 1);
    }
}