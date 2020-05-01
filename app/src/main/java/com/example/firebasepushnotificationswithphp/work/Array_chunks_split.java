package com.example.firebasepushnotificationswithphp.work;

import java.util.ArrayList;
import java.util.List;

public class Array_chunks_split {

     public   List<List<Object>> createBatch(List<Object> originalList, int batch_size) {
        int Length = originalList.size();
        int chunkSize = Length / batch_size;
        int residual = Length-chunkSize*batch_size;
        List<Integer> list_nums = new ArrayList<Integer>();
        for (int i = 0; i < batch_size; i++) {
            list_nums.add(chunkSize);
        }
        for (int i = 0; i < residual; i++) {
            list_nums.set(i, list_nums.get(i) + 1);
        }
        List<Integer> list_index = new ArrayList<Integer>();
        int cumulative = 0;
        for (int i = 0; i < batch_size; i++) {
            list_index.add(cumulative);
            cumulative += list_nums.get(i);
        }
        list_index.add(cumulative);
        List<List<Object>> listOfChunks = new ArrayList<List<Object>>();
        for (int i = 0; i < batch_size; i++) {
            listOfChunks.add(originalList.subList(list_index.get(i), list_index.get(i + 1)));
        }
        return listOfChunks;
    }
}
