package main

import "fmt"

// Definition for a binary tree node.
type TreeNode struct {
    Val   int
    Left  *TreeNode
    Right *TreeNode
}

// Function to balance a BST.
func balanceBST(root *TreeNode) *TreeNode {
    nodes := []*TreeNode{}
    inOrderTraversal(root, &nodes) // Step 1: Convert BST to sorted array using in-order traversal
    return sortedArrayToBST(0, len(nodes)-1, nodes) // Step 2: Construct and return the balanced BST
}

// Helper function to perform in-order traversal and collect the node values in a sorted array.
func inOrderTraversal(root *TreeNode, nodes *[]*TreeNode) {
    if root == nil {
        return
    }
    inOrderTraversal(root.Left, nodes)
    *nodes = append(*nodes, root)
    inOrderTraversal(root.Right, nodes)
}

// Helper function to construct a balanced BST from a sorted array.
func sortedArrayToBST(left int, right int, nodes []*TreeNode) *TreeNode {
    if left > right {
        return nil
    }
    mid := left + (right-left)/2 // Find the middle element
    root := nodes[mid]
    root.Left = sortedArrayToBST(left, mid-1, nodes) // Recursively build the left subtree
    root.Right = sortedArrayToBST(mid+1, right, nodes) // Recursively build the right subtree
    return root
}

// Helper function to print the tree in pre-order for testing.
func preOrderPrint(root *TreeNode) {
    if root == nil {
        return
    }
    fmt.Printf("%d ", root.Val)
    preOrderPrint(root.Left)
    preOrderPrint(root.Right)
}

func main() {
    // Example usage:
    root := &TreeNode{Val: 1}
    root.Right = &TreeNode{Val: 2}
    root.Right.Right = &TreeNode{Val: 3}
    root.Right.Right.Right = &TreeNode{Val: 4}

    fmt.Println("Original BST:")
    preOrderPrint(root)
    fmt.Println()

    balancedRoot := balanceBST(root)

    fmt.Println("Balanced BST:")
    preOrderPrint(balancedRoot)
    fmt.Println()
}





/*
// Function to balance a BST
func balanceBST(root *TreeNode) *TreeNode {
    ans := []int{} // This slice will store the nodes' values in sorted order

    // dfs is an inner function that performs in-order traversal
    var dfs func(*TreeNode)
    dfs = func(root *TreeNode) {
        if root == nil {
            return
        }
        dfs(root.Left)                // Traverse the left subtree
        ans = append(ans, root.Val)   // Visit the root and add its value to ans
        dfs(root.Right)               // Traverse the right subtree
    }

    // build is an inner function that constructs a balanced BST from the sorted array
    var build func(i, j int) *TreeNode
    build = func(i, j int) *TreeNode {
        if i > j {
            return nil               // Base case: no elements to construct a tree from
        }
        mid := (i + j) >> 1          // Find the middle element (same as (i + j) / 2)
        left := build(i, mid-1)      // Recursively build the left subtree
        right := build(mid+1, j)     // Recursively build the right subtree
        return &TreeNode{Val: ans[mid], Left: left, Right: right}      // Create the root node with left and right subtrees
    }

    dfs(root)                        // Step 1: Perform in-order traversal to get the sorted node values
    return build(0, len(ans)-1)      // Step 2: Construct and return the balanced BST
}

// Helper function to print the tree in pre-order for testing
func preOrderPrint(root *TreeNode) {
    if root == nil {
        return
    }
    fmt.Printf("%d ", root.Val)
    preOrderPrint(root.Left)
    preOrderPrint(root.Right)
}
*/
