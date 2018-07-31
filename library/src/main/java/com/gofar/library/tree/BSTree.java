package com.gofar.library.tree;

/**
 * @author lcf
 * @date 31/7/2018 下午 3:19
 * @since 1.0
 */
public class BSTree {
    BSNode root;

    /**
     * 前序遍历
     * 1.访问根节点
     * 2.先序遍历左子树
     * 3.先序遍历右子树
     *
     * @param bsNode
     */
    public void preOrder(BSNode bsNode) {
        if (bsNode != null) {
            System.out.println(bsNode.key);
            preOrder(bsNode.left);
            preOrder(bsNode.right);
        }
    }

    /**
     * 中序遍历
     * 1.中序遍历左子树
     * 2.访问根节点
     * 3.中序遍历右子树
     *
     * @param bsNode
     */
    public void inOrder(BSNode bsNode) {
        if (bsNode != null) {
            inOrder(bsNode.left);
            System.out.println(bsNode.key);
            inOrder(bsNode.right);
        }
    }

    /**
     * 后序遍历
     * 1.后序遍历左子树
     * 2.后序遍历右子树
     * 3.访问根节点
     *
     * @param bsNode
     */
    public void postOrder(BSNode bsNode) {
        if (bsNode != null) {
            postOrder(bsNode.left);
            postOrder(bsNode.right);
            System.out.println(bsNode.key);
        }
    }

    /**
     * 查找
     *
     * @param key
     * @return
     */
    public BSNode search(int key) {
        BSNode currentRoot = root;
        while (root != null && root.key != key) {
            if (root.key < key) {
                currentRoot = currentRoot.right;
            } else {
                currentRoot = currentRoot.left;
            }
        }
        return currentRoot;
    }

    private BSNode minNode(BSNode bsNode) {
        if (bsNode == null) {
            return null;
        }
        BSNode min = bsNode;
        while (min.left != null) {
            min = min.left;
        }
        return min;
    }

    public int minNode() {
        BSNode bsNode = minNode(root);
        if (bsNode != null) {
            return bsNode.key;
        } else {
            return -1;
        }
    }

    public int maxNode() {
        BSNode bsNode = maxNode(root);
        if (bsNode != null) {
            return bsNode.key;
        } else {
            return -1;
        }
    }

    private BSNode maxNode(BSNode bsNode) {
        if (bsNode == null) {
            return null;
        }
        BSNode max = bsNode;
        while (max.right != null) {
            max = max.right;
        }
        return max;
    }

    public BSNode deleteMin() {
        BSNode currentNode = root;
        BSNode lastNode;
        while (currentNode != null && currentNode.left != null) {
            if (currentNode.left.right != null) {
                lastNode = currentNode.left.right;
            }
            currentNode = currentNode.left;
        }
        return currentNode;
    }

    private class BSNode {
        /**
         * 节点key
         */
        int key;
        /**
         * 节点值
         */
        int value;
        /**
         * 左子节点
         */
        BSNode left;
        /**
         * 右子节点
         */
        BSNode right;

        public BSNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
