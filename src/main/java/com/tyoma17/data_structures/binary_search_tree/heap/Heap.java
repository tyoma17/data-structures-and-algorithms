package com.tyoma17.data_structures.binary_search_tree.heap;

import com.tyoma17.util.Helper;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Heap { // max heap

    private int[] heap;
    private int size;

    public Heap(int capacity) {
        heap = new int[capacity];
        log.debug("Heap of capacity {} has been initialized", capacity);
    }

    public void insert(int value) {

        log.debug("Inserting {} to heap", value);

        if (isFull()) {
            throw new IndexOutOfBoundsException("Heap is full");
        }

        heap[size] = value;
        log.debug("heap[{}] = {}", size, value);

        fixHeapAbove(size);
        size++;
        log.debug("Heap size = {}", size);
    }

    public int delete(int index) { // usually the delete methods deletes only root

        int deletedValue = heap[index];
        log.debug("Deleting value {} at index {}", deletedValue, index);

        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        int parentIndex = getParentIndex(index);
        log.debug("Index's {} parent index is {}", index, parentIndex);

        int rightmostValue = heap[size - 1];
        heap[index] = rightmostValue;
        log.debug("heap[{}] = {} <--- rightmost value", index, rightmostValue);
        log.debug("Heap: {}", Helper.arrayAsString(heap, 0, heap.length));

        if (index == 0 || heap[index] < heap[parentIndex]) {
            fixHeapBelow(index, size - 1);
        } else {
            fixHeapAbove(index);
        }

        size--;
        log.debug("Heap size = {}", size);

        log.debug("Value {} was deleted", deletedValue);
        return deletedValue;
    }

    public void sort() {

        log.debug("Sorting heap...");
        int lastHeapIndex = size - 1;
        log.debug("lastHeapIndex = {}", lastHeapIndex);

        for (int i = 0; i < lastHeapIndex; i++) {
            int tmp = heap[0];
            heap[0] = heap[lastHeapIndex - i];
            log.debug("heap[0] = {}", heap[lastHeapIndex - i]);
            heap[lastHeapIndex - i] = tmp;
            log.debug("heap[{}] = {}", lastHeapIndex - i, tmp);
            log.debug(heapAsString());

            fixHeapBelow(0, lastHeapIndex - i - 1);
        }
        // a heap is not a heap after sorting
    }

    private void fixHeapAbove(int index) {

        int newValue = heap[index];
        log.debug("newValue = {}", newValue);

        while (index > 0 && newValue > heap[getParentIndex(index)]) {
            log.debug("Fixing heap above index {}", index);
            int parentIndexValue = heap[getParentIndex(index)];
            heap[index] = parentIndexValue;
            log.debug("heap[{}] = {}", index, parentIndexValue);
            log.debug("Heap: {}", Helper.arrayAsString(heap, 0, heap.length));
            index = getParentIndex(index);
            log.debug("index = {}", index);
        }

        heap[index] = newValue;
        log.debug("heap[{}] = {}", index, newValue);
        log.debug("Heap: {}", Helper.arrayAsString(heap, 0, heap.length));
    }

    private void fixHeapBelow(int index, int lastHeapIndex) {

        log.debug("Fixing heap below index {}", index);
        log.debug("lastHeapIndex = {}", lastHeapIndex);

        int childIndexToSwap;

        while (index <= lastHeapIndex) {

            int leftChildIndex = getChildIndex(index, true);
            log.debug("Index's {} left child index is {}", index, leftChildIndex);
            int rightChildIndex = getChildIndex(index, false);
            log.debug("Index's {} left child index is {}", index, rightChildIndex);

            if (leftChildIndex <= lastHeapIndex) {

                if (rightChildIndex > lastHeapIndex) {
                    childIndexToSwap = leftChildIndex;
                } else {
                    childIndexToSwap = heap[leftChildIndex] > heap[rightChildIndex] ? leftChildIndex : rightChildIndex;
                }

                int childIndexToSwapValue = heap[childIndexToSwap];
                log.debug("childIndexToSwap[{}] = {}", childIndexToSwap, childIndexToSwapValue);

                if (heap[index] < childIndexToSwapValue) {
                    int tmp = heap[index];
                    heap[index] = childIndexToSwapValue;
                    log.debug("heap[{}] = {}", index, childIndexToSwapValue);
                    heap[childIndexToSwap] = tmp;
                    log.debug("heap[{}] = {}", childIndexToSwap, tmp);
                    log.debug("Heap: {}", Helper.arrayAsString(heap, 0, heap.length));

                } else {
                    break;
                }

                index = childIndexToSwap;
                log.debug("index = {}", index);

            } else {
                break;
            }
        }

        int newValue = heap[index];
        log.debug("newValue = {}", newValue);
        int parentIndex = getParentIndex(index);
        log.debug("Index's {} parent index is {}", index, parentIndex);

        while (index > 0 && newValue > heap[parentIndex]) {
            log.debug("Fixing heap above index {}", index);
            int parentIndexValue = heap[parentIndex];
            heap[index] = parentIndex;
            log.debug("heap[{}] = {}", index, parentIndexValue);
            log.debug("Heap: {}", Helper.arrayAsString(heap, 0, heap.length));
            index = getParentIndex(index);
            log.debug("index = {}", index);
        }

        heap[index] = newValue;
        log.debug("heap[{}] = {}", index, newValue);
        log.debug("Heap: {}", Helper.arrayAsString(heap, 0, heap.length));
    }

    public int peek() {

        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        return heap[0];
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    public int getChildIndex(int index, boolean left) {
        return 2 * index + (left ? 1 : 2);
    }

    public int size() {
        return size;
    }

    public String heapAsString() {
        return "Heap: " + Helper.arrayAsString(heap, 0, size);
    }
}