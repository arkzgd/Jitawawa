package com.ihaveaname.scala.leetcode

import com.ihaveaname.java.leetcode.TreeNode

object CheckCompletenessOfABinaryTree_958 extends App {
  object Solution {
    def isCompleteTree(root: TreeNode): Boolean = ???
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

  val tree3 =
    new TreeNode(
      1,
      new TreeNode(2, new TreeNode(5), null),
      new TreeNode(3, new TreeNode(7), new TreeNode(8))
    )
  println(s"${Solution.isCompleteTree(tree3)}")

  val tree4 =
    new TreeNode(
      1,
      new TreeNode(2, new TreeNode(5), null),
      new TreeNode(3)
    )
  println(s"${Solution.isCompleteTree(tree4)}")
}
