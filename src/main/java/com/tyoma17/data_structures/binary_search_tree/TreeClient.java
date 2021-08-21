package com.tyoma17.data_structures.binary_search_tree;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TreeClient {

    public static void main(String[] args) {
        Tree intTree = new Tree();
        int[] ints = {21, 49, 8, 79, 14, 47, 90, 100, 60, 93};

        for (int intValue : ints) {
            log.info("Inserting {} to tree", intValue);
            intTree.insert(intValue);
        }

        log.info("In-order traversal: {}", intTree.traverseInOrder());
        log.info("Pre-order traversal: {}", intTree.traversePreOrder());
        log.info("Post-order traversal: {}", intTree.traversePostOrder());
        log.info("Searching for node with value {}...", 0);
        log.info("Node is {}", intTree.get(0));

        for (int intValue : ints) {
            log.info("Searching for node with value {}...", intValue);
            log.info("Node is {}", intTree.get(intValue));
        }

        log.info("Min value in tree is {}", intTree.min());
        log.info("Max value in tree is {}", intTree.max());

        log.info("Deleting 93...");
        intTree.delete(93);
        log.info("Tree: {}", intTree.traverseInOrder());

        log.info("Deleting 100...");
        intTree.delete(100);
        log.info("Tree: {}", intTree.traverseInOrder());

        log.info("Deleting 79...");
        intTree.delete(79);
        log.info("Tree: {}", intTree.traverseInOrder());

        log.info("Deleting 49...");
        intTree.delete(49);
        log.info("Tree: {}", intTree.traverseInOrder());
    }
}