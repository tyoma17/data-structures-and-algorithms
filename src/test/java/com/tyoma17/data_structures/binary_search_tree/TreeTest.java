package com.tyoma17.data_structures.binary_search_tree;

import org.junit.jupiter.api.Test;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TreeTest {

    private static final int[] ARRAY = {21, 49, 8, 79, 14, 47, 90, 100, 60, 93};
    private final Tree tree;

    private TreeTest() {

        tree = new Tree();

        for (int intValue : ARRAY) {
            tree.insert(intValue);
        }
    }

    @Test
    void get() {
        assertNull(tree.get(0));

        TreeNode tn14 = tree.get(14);
        assertEquals(14, tn14.getData());
        assertNull(tn14.getLeftChild());
        assertNull(tn14.getRightChild());

        TreeNode tn47 = tree.get(47);
        assertEquals(47, tn47.getData());
        assertNull(tn47.getLeftChild());
        assertNull(tn47.getRightChild());

        TreeNode tn93 = tree.get(93);
        assertEquals(93, tn93.getData());
        assertNull(tn93.getLeftChild());
        assertNull(tn93.getRightChild());

        TreeNode tn60 = tree.get(60);
        assertEquals(60, tn60.getData());
        assertNull(tn60.getLeftChild());
        assertNull(tn60.getRightChild());

        TreeNode tn100 = tree.get(100);
        assertEquals(100, tn100.getData());
        assertEquals(tn93, tn100.getLeftChild());
        assertNull(tn100.getRightChild());

        TreeNode tn90 = tree.get(90);
        assertEquals(90, tn90.getData());
        assertNull(tn90.getLeftChild());
        assertEquals(tn100, tn90.getRightChild());

        TreeNode tn8 = tree.get(8);
        assertEquals(8, tn8.getData());
        assertNull(tn8.getLeftChild());
        assertEquals(tn14, tn8.getRightChild());

        TreeNode tn79 = tree.get(79);
        assertEquals(79, tn79.getData());
        assertEquals(tn90, tn79.getRightChild());
        assertEquals(tn60, tn79.getLeftChild());

        TreeNode tn49 = tree.get(49);
        assertEquals(49, tn49.getData());
        assertEquals(tn47, tn49.getLeftChild());
        assertEquals(tn79, tn49.getRightChild());

        TreeNode root = tree.get(21);
        assertEquals(21, root.getData());
        assertEquals(tn8, root.getLeftChild());
        assertEquals(tn49, root.getRightChild());
    }

    @Test
    void min() {
        assertEquals(8, tree.min());
    }

    @Test
    void min_onEmptyTree() {
        assertEquals(MIN_VALUE, new Tree().min());
    }

    @Test
    void max() {
        assertEquals(100, tree.max());
    }

    @Test
    void max_onEmptyTree() {
        assertEquals(MAX_VALUE, new Tree().max());
    }

    @Test
    void delete_whenNodeHasNoChildren() {
        tree.delete(93);
        assertEquals("8,14,21,47,49,60,79,90,100,", tree.traverseInOrder());
    }

    @Test
    void delete_whenNodeHasOnlyLeftChild() {
        tree.delete(100);
        assertEquals("8,14,21,47,49,60,79,90,93,", tree.traverseInOrder());
    }

    @Test
    void delete_whenNodeHasOnlyRightChild() {
        tree.delete(8);
        assertEquals("14,21,47,49,60,79,90,93,100,", tree.traverseInOrder());
    }

    @Test
    void delete_whenNodeHasTwoChildren() {
        tree.delete(49);
        assertEquals("8,14,21,47,60,79,90,93,100,", tree.traverseInOrder());
    }
}