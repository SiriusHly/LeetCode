package com.hly.backup.review.review8_4.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :hly
 *
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/8/1
 * @QQ :1136513099
 * @desc :32、从上往下打印二叉树(层次遍历)
 */
public class PrintFromTopToBottom {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void printFromTopToBottom(TreeNode root) {
        if(root==null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            //应该打印当前节点
            System.out.println(cur.val);
            if(cur.left!=null){
                queue.offer(queue.element());
            }
            if(cur.right!=null){
                queue.offer(cur.right);
            }
        }

    }
}
