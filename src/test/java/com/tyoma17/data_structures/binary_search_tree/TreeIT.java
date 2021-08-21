package com.tyoma17.data_structures.binary_search_tree;

import com.tyoma17.util.TestHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TreeIT {

    @ParameterizedTest
    @CsvFileSource(resources = "/data_structures/trees_traversal.csv", numLinesToSkip = 1, delimiter = ';')
    void traverseInOrder(String array, String inOrderTraversal, String preOrderTraversal, String postOrderTraversal) {

        int[] unsortedArray = TestHelper.convertArrayAsStringToIntArray(array);
        Tree tree = new Tree();

        for (int intValue : unsortedArray) {
            tree.insert(intValue);
        }

        assertEquals(inOrderTraversal, tree.traverseInOrder());
        assertEquals(preOrderTraversal, tree.traversePreOrder());
        assertEquals(postOrderTraversal, tree.traversePostOrder());
        assertNull(new Tree().traverseInOrder());
    }

    @Test
    void delete() {

        Tree tree = new Tree();
        int[] array = {21, 49, 8, 79, 14, 47, 90, 100, 60, 93};

        for (int intValue : array) {
            tree.insert(intValue);
        }

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

        assertEquals("8,14,21,47,49,60,79,90,93,100,", tree.traverseInOrder());

        tree.delete(93);
        assertEquals("8,14,21,47,49,60,79,90,100,", tree.traverseInOrder());
        tn100 = tree.get(100);
        assertEquals(100, tn100.getData());
        assertNull(tn100.getLeftChild());
        assertNull(tn100.getRightChild());

        tree.delete(100);
        assertEquals("8,14,21,47,49,60,79,90,", tree.traverseInOrder());
        tn90 = tree.get(90);
        assertEquals(90, tn90.getData());
        assertNull(tn90.getLeftChild());
        assertNull(tn90.getRightChild());

        tree.delete(79);
        assertEquals("8,14,21,47,49,60,90,", tree.traverseInOrder());
        tn49 = tree.get(49);
        assertEquals(49, tn49.getData());
        assertEquals(tn47, tn49.getLeftChild());
        tn90 = tn49.getRightChild();
        assertEquals(90, tn90.getData());
        assertEquals(tn60, tn90.getLeftChild());
        assertNull(tn90.getRightChild());

        tree.delete(49);
        assertEquals("8,14,21,47,60,90,", tree.traverseInOrder());
        assertEquals(21, root.getData());
        assertEquals(tn8, root.getLeftChild());
        tn60 = root.getRightChild();
        assertEquals(60, tn60.getData());
        assertEquals(tn47, tn60.getLeftChild());
        tn90 = tn60.getRightChild();
        assertEquals(90, tn90.getData());
        assertNull(tn90.getLeftChild());
        assertNull(tn90.getRightChild());
    }
}