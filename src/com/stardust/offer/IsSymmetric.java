package com.stardust.offer;

/**
 * @author :hly
 *
 * @CSDN :blog.csdn.net/Sirius_hly
 * @WeChat :xcvip2021
 * @date :2021/5/15
 * @desc : 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 */
public class IsSymmetric {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return judge(root.left, root.right);

    }

    private boolean judge(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return judge(left.left, right.right) && judge(left.right, right.left);

    }


    public static void main(String[] args) {
        System.out.println("");
    }
}
