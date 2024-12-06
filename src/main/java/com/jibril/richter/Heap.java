package com.jibril.richter;

import java.util.ArrayList;
import java.util.List;

public class Heap {

    private List<Integer> heap;

    public Heap(){
        heap = new ArrayList<Integer>();
    }

    public List<Integer> getHeap(){
        return new ArrayList<>(heap);
    }

//    Helper methods
    private int getLeftChildIndex(int index){
        return (index * 2) + 1;
    }
    private int getRightChildIndex(int index){
        return (index * 2) + 2;
    }
    private int getParentIndex(int index){
        return (index -1)/2;
    }
    private void swap(int index1, int index2){
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value){
        heap.add(value);
        int currentIndex = heap.size() - 1;
        while (currentIndex > 0 && heap.get(currentIndex) > heap.get(getParentIndex(currentIndex))){
            swap(currentIndex, getParentIndex(currentIndex));
            currentIndex = getParentIndex(currentIndex);
        }
    }

    public Integer remove(){
        if (heap.size() == 0){
            return null;
        }
        if (heap.size() == 1){
            return heap.remove(0);
        }

        Integer maxValue = heap.get(0);
        heap.set(0, heap.remove(heap.size()-1));

        return null;
    }

    private void sinkDown(int index){
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);
        int maxValueIndex = 0;

        while (true){
            if(leftChildIndex < heap.size() && heap.get(leftChildIndex) > heap.get(maxValueIndex)){
                maxValueIndex = leftChildIndex;
            }
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex) > heap.get(maxValueIndex)){
                maxValueIndex = leftChildIndex;
            }
            if (maxValueIndex != index){
                swap(index, maxValueIndex);
                index = maxValueIndex;
            } else {
                return;
            }
        }
    }


}
