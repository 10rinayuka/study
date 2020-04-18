package com.riku.study.other;

/**
 * This is Description
 *
 * @author jay
 * @date 2020/03/04
 */
public class Demo {

    private static int tmp = Integer.MIN_VALUE;


    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        System.out.println("" + intercept(root));
    }

    private static boolean intercept(TreeNode node) {
        if (node == null) return true;

        if (!intercept(node.left)) return false;
        if (node.val < tmp) return false;
        tmp = node.val;
        return intercept(node.right);
    }
}
