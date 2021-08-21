package com.tyoma17.data_structures.binary_search_tree;

import lombok.extern.log4j.Log4j2;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

@Log4j2
public class Tree {

    private TreeNode root;

    public void insert(int value) {

        if (root == null) {

            log.debug("Root node hasn't been found");
            root = new TreeNode(value);
            log.debug("Root node of the tree is {}", root);

        } else {

            root.insert(value);
        }
    }

    public TreeNode get(int value) {
        return root == null ? null : root.get(value);
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private TreeNode delete(TreeNode subtreeRoot, int value) {

        if (subtreeRoot == null) {
            return subtreeRoot;
        }

        int subtreeRootData = subtreeRoot.getData();
        TreeNode leftChild = subtreeRoot.getLeftChild();
        TreeNode rightChild = subtreeRoot.getRightChild();

        if (value < subtreeRootData) {

            log.debug("Value {} is less than value of {}", value, subtreeRoot);
            log.debug("Candidate for deletion is {}", leftChild);
            TreeNode candidateForDeletion = delete(leftChild, value);
            log.debug("For {} setting left child to {}", subtreeRoot, candidateForDeletion);
            subtreeRoot.setLeftChild(candidateForDeletion);

        } else if (value > subtreeRootData) {

            log.debug("Value {} is greater than value of {}", value, subtreeRoot);
            log.debug("Candidate for deletion is {}", rightChild);
            TreeNode candidateForDeletion = delete(rightChild, value);
            log.debug("For {} setting right child to {}", subtreeRoot, candidateForDeletion);
            subtreeRoot.setRightChild(candidateForDeletion);

        } else {
            log.debug("Value {} is equal to value of {}", value, subtreeRoot);

            if (leftChild == null) {
                return rightChild;
            } else if (rightChild == null) {
                return leftChild;
            } else {

                log.debug("{} has both left and right children", subtreeRoot);
                int minValueOnRightSide = rightChild.min();
                log.debug("Min value on the right side of {} is {}", subtreeRoot, minValueOnRightSide);
                log.debug("Replacing data value of {} with {}", subtreeRoot, minValueOnRightSide);
                subtreeRoot.setData(minValueOnRightSide);
                TreeNode nodeWithSmallestValueOnRight = delete(rightChild, subtreeRoot.getData());
                log.debug("Node with smallest value in the right subtree is {}", nodeWithSmallestValueOnRight);
                log.debug("Setting it as right child of {}", subtreeRoot);
                subtreeRoot.setRightChild(nodeWithSmallestValueOnRight);
            }
        }

        return subtreeRoot;
    }

    public int min() {
        return root == null ? MIN_VALUE : root.min();
    }

    public int max() {
        return root == null ? MAX_VALUE : root.max();
    }

    public String traverseInOrder() {
        return root == null ? null : root.traverseInOrder();
    }

    public String traversePreOrder() {
        return root == null ? null : root.traversePreOrder();
    }

    public String traversePostOrder() {
        return root == null ? null : root.traversePostOrder();
    }
}