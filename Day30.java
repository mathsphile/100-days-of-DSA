// Given a binary tree, find its height.

// The height of a tree is defined as the number of edges on the longest path from the root to a leaf node. A leaf node is a node that does not have any children.
class Solution {
    // Function to find the height of a binary tree.
    int height(Node node) {
        // Base case: if the node is null, return -1 (since we're counting edges).
        if (node == null) {
            return -1;
        }

        // Recursively find the height of left and right subtrees
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Height of the tree is the maximum height of left/right subtree + 1
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
