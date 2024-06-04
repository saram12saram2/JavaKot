package main

import "fmt"

// Definition for singly-linked list.
type ListNode struct {
    Val  int
    Next *ListNode
}

// Definition for a binary tree node.
type TreeNode struct {
    Val   int
    Left  *TreeNode
    Right *TreeNode
}

// checkPath function checks if the linked list starting from the given pointer 
// matches a downward path in the binary tree starting from the given node.
func checkPath(head *ListNode, node *TreeNode) bool {
    if head == nil {
        return true
    }
    if node == nil {
        return false
    }
    if head.Val != node.Val {
        return false
    }
    return checkPath(head.Next, node.Left) || checkPath(head.Next, node.Right)
}

// isSubPath function checks if there exists a downward path in the binary tree
// that matches the linked list starting from head.
func isSubPath(head *ListNode, root *TreeNode) bool {
    if head == nil {
        return true
    }
    if root == nil {
        return false
    }
    return checkPath(head, root) || isSubPath(head, root.Left) || isSubPath(head, root.Right)
}

func main() {
    // Creating a sample linked list: 4 -> 2 -> 8
    head := &ListNode{4, &ListNode{2, &ListNode{8, nil}}}

    // Creating a sample binary tree:
    //         1
    //        / \
    //       4   4
    //        \   \
    //         2   2
    //        /   /
    //       6   1
    //        \   \
    //         8   3
    root := &TreeNode{1,
        &TreeNode{4, nil, &TreeNode{2, &TreeNode{6, nil, &TreeNode{8, nil, nil}}, nil}},
        &TreeNode{4, nil, &TreeNode{2, &TreeNode{1, nil, &TreeNode{3, nil, nil}}, nil}},
    }

    // Test the isSubPath function
    result := isSubPath(head, root)
    fmt.Println(result) // Output: true
}
