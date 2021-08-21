package com.tyoma17.data_structures.binary_search_tree.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapIT {

    @Test
    void testHeap() {

        Heap heap = new Heap(10);
        int[] ints = {21, 49, 8, 79, 14, 47, 90, 100, 60, 93};

        assertEquals(0, heap.size());
        assertTrue(heap.isEmpty());
        assertFalse(heap.isFull());

        heap.insert(21);
        assertEquals(1, heap.size());
        assertFalse(heap.isEmpty());
        assertFalse(heap.isFull());
        assertEquals(21, heap.peek());
        assertEquals("Heap: 21", heap.heapAsString());

        heap.insert(49);
        assertEquals(2, heap.size());
        assertFalse(heap.isEmpty());
        assertFalse(heap.isFull());
        assertEquals(49, heap.peek());
        assertEquals("Heap: 49,21", heap.heapAsString());

        heap.insert(8);
        assertEquals(3, heap.size());
        assertFalse(heap.isEmpty());
        assertFalse(heap.isFull());
        assertEquals(49, heap.peek());
        assertEquals("Heap: 49,21,8", heap.heapAsString());

        heap.insert(79);
        assertEquals(4, heap.size());
        assertFalse(heap.isEmpty());
        assertFalse(heap.isFull());
        assertEquals(79, heap.peek());
        assertEquals("Heap: 79,49,8,21", heap.heapAsString());

        heap.insert(14);
        assertEquals(5, heap.size());
        assertFalse(heap.isEmpty());
        assertFalse(heap.isFull());
        assertEquals(79, heap.peek());
        assertEquals("Heap: 79,49,8,21,14", heap.heapAsString());

        heap.insert(47);
        assertEquals(6, heap.size());
        assertFalse(heap.isEmpty());
        assertFalse(heap.isFull());
        assertEquals(79, heap.peek());
        assertEquals("Heap: 79,49,47,21,14,8", heap.heapAsString());

        heap.insert(90);
        assertEquals(7, heap.size());
        assertFalse(heap.isEmpty());
        assertFalse(heap.isFull());
        assertEquals(90, heap.peek());
        assertEquals("Heap: 90,49,79,21,14,8,47", heap.heapAsString());

        heap.insert(100);
        assertEquals(8, heap.size());
        assertFalse(heap.isEmpty());
        assertFalse(heap.isFull());
        assertEquals(100, heap.peek());
        assertEquals("Heap: 100,90,79,49,14,8,47,21", heap.heapAsString());

        heap.insert(60);
        assertEquals(9, heap.size());
        assertFalse(heap.isEmpty());
        assertFalse(heap.isFull());
        assertEquals(100, heap.peek());
        assertEquals("Heap: 100,90,79,60,14,8,47,21,49", heap.heapAsString());

        heap.insert(93);
        assertEquals(10, heap.size());
        assertFalse(heap.isEmpty());
        assertTrue(heap.isFull());
        assertEquals(100, heap.peek());
        assertEquals("Heap: 100,93,79,60,90,8,47,21,49,14", heap.heapAsString());


        heap.delete(1);
        assertEquals(9, heap.size());
        assertFalse(heap.isEmpty());
        assertFalse(heap.isFull());
        assertEquals(100, heap.peek());
        assertEquals("Heap: 100,90,79,60,14,8,47,21,49", heap.heapAsString());

        heap.delete(4);
        assertEquals(8, heap.size());
        assertFalse(heap.isEmpty());
        assertFalse(heap.isFull());
        assertEquals(100, heap.peek());
        assertEquals("Heap: 100,90,79,60,49,8,47,21", heap.heapAsString());

        heap.delete(0);
        assertEquals(7, heap.size());
        assertFalse(heap.isEmpty());
        assertFalse(heap.isFull());
        assertEquals(90, heap.peek());
        assertEquals("Heap: 90,60,79,21,49,8,47", heap.heapAsString());
    }
}