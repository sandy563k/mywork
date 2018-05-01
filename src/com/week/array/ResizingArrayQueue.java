package com.week.array;

import java.util.Arrays;

public class ResizingArrayQueue {
    private String[] arr = new String[1];
    int first = 0, last = 0;

    public void enqueue(String newItem) {
        ensureCapacity(false);
        arr[last++] = newItem;

    }

    public int size() {
        return last - first;

    }

    public String dequeue() {
        if (!this.isEmpty()) {
            ensureCapacity(true);
            return this.arr[first++];
        } else {
            System.out.println("queue already empty");
            return null;
        }
    }

    private boolean isEmpty() {

        return (first == last);
    }

    private void ensureCapacity(boolean isRemoved) {
        if (isRemoved) {
            //look for downsizing
            if (last - first +1  <= 0.25 * arr.length) {
                this.arr = copyArrayElements(arr.length / 2);
            }
        } else {
            // look for doubling the capacity
            if (last == this.arr.length - 1) {

                if (last - first +1 >= 0.75 * arr.length) {
                    this.arr = copyArrayElements(arr.length * 2);
                } else {
                    this.arr = copyArrayElements(arr.length);
                }

            }
        }


    }

    private String[] copyArrayElements(int newLength) {
        String[] target = new String[newLength];
        System.arraycopy(arr, first, target, 0, last - first+1);
        last= last - first;
        first = 0;
        return target;
    }

    private void printArray(){
        for(int i=first;i<last;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ResizingArrayQueue newQueue = new ResizingArrayQueue();
        newQueue.enqueue("a");
        System.out.println(newQueue.size());
        newQueue.printArray();
        newQueue.enqueue("b");
        System.out.println(newQueue.size());
        newQueue.printArray();
        newQueue.enqueue("c");
        System.out.println(newQueue.size());
        newQueue.printArray();
        newQueue.enqueue("d");
        System.out.println(newQueue.size());
        newQueue.printArray();
        newQueue.enqueue("e");
        System.out.println(newQueue.size());
        newQueue.printArray();

        newQueue.dequeue();
        System.out.println(newQueue.size());
        newQueue.printArray();
        newQueue.dequeue();
        System.out.println(newQueue.size());
        newQueue.printArray();
        newQueue.dequeue();
        System.out.println(newQueue.size());
        newQueue.printArray();
        newQueue.dequeue();
        System.out.println(newQueue.size());
        newQueue.printArray();
        newQueue.dequeue();
        System.out.println(newQueue.size());
        newQueue.printArray();


    }



}
