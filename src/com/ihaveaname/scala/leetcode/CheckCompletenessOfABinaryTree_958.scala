package com.ihaveaname.scala.leetcode

import com.ihaveaname.java.leetcode.TreeNode

object CheckCompletenessOfABinaryTree_958 extends App {
  object Solution {
    def height(root: TreeNode): Int =
      if (root != null) Math.max(height(root.left), height((root.right))) + 1
      else 0

    def isCompleteTree(root: TreeNode): Boolean =
      if (root != null) {
        val cr = isCompleteTree(root.left) && isCompleteTree(root.right)
        if (cr) {
          val diff = height(root.left) - height(root.right)
          if (diff == 0 || diff == 1) true
          else false
        } else false
      } else true
  }

  val tree1 =
    new TreeNode(
      1,
      new TreeNode(2, new TreeNode(4), new TreeNode(5)),
      new TreeNode(3, new TreeNode(6), null)
    )
  println(s"${Solution.isCompleteTree(tree1)}")

  val tree2 =
    new TreeNode(
      1,
      new TreeNode(2, new TreeNode(4), new TreeNode(5)),
      new TreeNode(3, null, new TreeNode(6))
    )
  println(s"${Solution.isCompleteTree(tree2)}")
}
