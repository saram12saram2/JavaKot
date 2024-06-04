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

func isSubPath(head *ListNode, root *TreeNode) bool {
    if head == nil {
        return true
    }
    if root == nil {
        return false
    }
    return dfs(head, root) || isSubPath(head, root.Left) || isSubPath(head, root.Right)
}

func dfs(head *ListNode, node *TreeNode) bool {
    if head == nil {
        return true
    }
    if node == nil {
        return false
    }
    if head.Val != node.Val {
        return false
    }
    return dfs(head.Next, node.Left) || dfs(head.Next, node.Right)
}
