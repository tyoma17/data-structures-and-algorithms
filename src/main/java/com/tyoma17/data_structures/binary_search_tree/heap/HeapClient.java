package com.tyoma17.data_structures.binary_search_tree.heap;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class HeapClient {

    public static void main(String[] args) {

        Heap heap = new Heap(10);
        int[] ints = {21, 49, 8, 79, 14, 47, 90, 100, 60, 93};

        for (int intValue : ints) {
            log.info("Inserting {} to heap", intValue);
            heap.insert(intValue);
            log.info(heap.heapAsString());
        }

        log.info("Deleting 93...");
        heap.delete(1);
        log.info(heap.heapAsString());

        log.info("Deleting 14...");
        heap.delete(4);
        log.info(heap.heapAsString());

        log.info("Deleting 100...");
        heap.delete(0);
        log.info(heap.heapAsString());
    }
}