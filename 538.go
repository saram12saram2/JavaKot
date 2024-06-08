func convertBST(root *TreeNode) *TreeNode {
    sum := 0
    var dfs func(node *TreeNode)
    dfs = func(node *TreeNode) {
        if node == nil {
            return
        }
        // Traverse right subtree first (greater values).
        dfs(node.Right)
        // Update current node's value with accumulated sum.
        sum += node.Val
        node.Val = sum
        // Traverse left subtree (smaller values).
        dfs(node.Left)
    }
    dfs(root)
    return root
}








/*
package main

import "fmt"

// Definition for a binary tree node.
type TreeNode struct {
    Val   int
    Left  *TreeNode
    Right *TreeNode
}


// Function to print the tree in in-order (for testing purposes).
func inOrderPrint(root *TreeNode) {
    if root == nil {
        return
    }
    inOrderPrint(root.Left)
    fmt.Printf("%d ", root.Val)
    inOrderPrint(root.Right)
}

func main() {
    // Example usage:
    root := &TreeNode{Val: 4}
    root.Left = &TreeNode{Val: 1}
    root.Right = &TreeNode{Val: 6}
    root.Left.Left = &TreeNode{Val: 0}
    root.Left.Right = &TreeNode{Val: 2}
    root.Left.Right.Right = &TreeNode{Val: 3}
    root.Right.Left = &TreeNode{Val: 5}
    root.Right.Right = &TreeNode{Val: 7}
    root.Right.Right.Right = &TreeNode{Val: 8}

    fmt.Println("Original BST (in-order):")
    inOrderPrint(root)
    fmt.Println()

    convertBST(root)

    fmt.Println("Greater Tree (in-order):")
    inOrderPrint(root)
    fmt.Println()
}

*/
