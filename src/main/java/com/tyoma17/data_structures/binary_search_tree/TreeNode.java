package com.tyoma17.data_structures.binary_search_tree;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Getter
@Setter
@Log4j2
public class TreeNode {

    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }

    public void insert(int value) {

        if (value == data) {
            log.debug("Tree already contains {}, so it won't be inserted once more", value);
            return;
        }

        if (value < data) {

            if (leftChild == null) {
                leftChild = new TreeNode(value);
            } else {
                leftChild.insert(value);
            }

        } else {

            if (rightChild == null) {
                rightChild = new TreeNode(value);
            } else {
                rightChild.insert(value);
            }
        }
    }

    public TreeNode get(int value) {

        if (value == data) {
            return this;
        }

        if (value < data) {

            if (leftChild != null) {
                log.debug("Searching {} in left child {}", value, leftChild);
                return leftChild.get(value);
            }

        } else {

            if (rightChild != null) {
                log.debug("Searching {} in right child {}", value, rightChild);
                return rightChild.get(value);
            }
        }

        log.debug("Value {} was not found", value);
        return null;
    }

    public int min() {

        if (leftChild == null) {
            return data;
        }

        return leftChild.min();
    }

    public int max() {

        if (rightChild == null) {
            return data;
        }

        return rightChild.max();
    }

    public String traverseInOrder() {

        StringBuilder stringBuilder = new StringBuilder();

        if (leftChild != null) {
            stringBuilder.append(leftChild.traverseInOrder());
        }

        stringBuilder
                .append(data)
                .append(",");

        if (rightChild != null) {
            stringBuilder.append(rightChild.traverseInOrder());
        }

        return stringBuilder.toString();
    }

    public String traversePreOrder() {

        StringBuilder stringBuilder = new StringBuilder(data + ",");

        if (leftChild != null) {
            stringBuilder.append(leftChild.traversePreOrder());
        }

        if (rightChild != null) {
            stringBuilder.append(rightChild.traversePreOrder());
        }

        return stringBuilder.toString();
    }

    public String traversePostOrder() {

        StringBuilder stringBuilder = new StringBuilder();

        if (leftChild != null) {
            stringBuilder.append(leftChild.traversePostOrder());
        }

        if (rightChild != null) {
            stringBuilder.append(rightChild.traversePostOrder());
        }

        stringBuilder.append(data + ",");

        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data = " + data +
                ", leftChild = " + (leftChild == null ? "null" : leftChild.data) +
                ", rightChild = " + (rightChild == null ? "null" : rightChild.data) +
                '}';
    }
}