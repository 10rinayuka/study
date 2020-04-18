package com.riku.study.other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is Description
 *
 * @author jay
 * @date 2020/03/08
 */
public class Codec {

    public static void main(String[] args) {
//        String data = "[1,2,3,null,null,4,5]";
        String data = "[1,2,null,null,3,4,null,null,5]";
        TreeNode root = deserialize(data);
        System.out.println("end");
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ret = new StringBuilder("[");
        helper(root, ret);
        ret.delete(ret.length() - 1, ret.length());
        ret.append("]");
        return ret.toString();
    }

    private void helper(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append("null,");
            return;
        }
        str.append(root.val).append(",");
        helper(root.left, str);
        helper(root.right, str);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {

        if (data.length() == 2) return null;
        data = data.substring(1, data.length() - 1);
        String[] values = data.split(",");

        Queue<TreeNode> deque = new LinkedList<>();
        int idx = 1;

        TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        deque.add(root);
        while (idx + 1 < values.length) {
            TreeNode node = deque.poll();
            if (!"null".equals(values[idx])) {
                node.left = new TreeNode(Integer.valueOf(values[idx]));
                deque.add(node.left);
            }
            idx++;
            if (!"null".equals(values[idx])) {
                node.right = new TreeNode(Integer.valueOf(values[idx]));
                deque.add(node.right);


            }
            idx++;
        }
        return root;
    }

}
