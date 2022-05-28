
import java.util.*;

public class MaxHeap<K, V> {

    List<HeapEntry<K,V>> entries;
    int capacity;
    int heapSize = 0;
    Comparator comparator;

    public MaxHeap(int capacity, Comparator comparator){
        // Constructor for the max heap
        this.capacity = capacity;
        this.comparator = comparator;
        this.entries = new ArrayList<HeapEntry<K,V>>(capacity);
        this.entries.add(null);
    }

    public void add(K key, V value){
        // Method to add the key value pair in the heap, remember to satisfy max heap Property
        HeapEntry<K,V> current = new HeapEntry<K,V>(key, value);
        HeapEntry<K,V> temp;
        if(this.entries.size() == 1){
            entries.add(current);
            return;
        }
        int comparison = compare(entries.get(1), current);
        if(comparison < 0){
            temp = entries.get(1);
            entries.set(1, current);
            refactor(1, temp);
        }
        else {
            refactor(1, current);
        }
        // int index = 1;
        // int comparison;
        // HeapEntry<K,V> current;
        // while(index < entries.size()){
        //     current = this.entries.get(index);
        //     comparison = compare(current.getKey(), key);
        //     System.out.format("Add iteration at index %s, using current object with values (%s, %s) and comparison value of %s.\n", index, current.getKey(), current.getValue(), comparison);
        //     if(comparison == 0){break;}
        //     else if(comparison > 0) {index *= 2;}
        //     else if(comparison < 0) {index = index * 2 + 1;}
        // }
        // if(index >= entries.size()){
        //     entries.add(new HeapEntry<K, V>(key, value));
        // }
        // else {
        //     current = this.entries.get(index);
        //     entries.set(index, new HeapEntry<K, V>(key, value));
        //     refactor(index, current);
        // }
    }

    public HeapEntry<K,V> peek() {
        // Method to return the max element in the heap
        return entries.get(1);
    }

    public HeapEntry<K,V> remove() {
        //Method to remove the max element in the heap, remember to satisfy max heap Property
        HeapEntry<K, V> toReturn = this.entries.remove(1);
        // this.entries.set(1, null);
        refactor(1);
        return toReturn;
    }
    // because i don't want to write "comparator.compare() every time"
    private int compare(K entry1, K entry2){
        return comparator.compare(entry1, entry2);
    }
    private int compare(HeapEntry<K,V> entry1, HeapEntry<K,V> entry2){
        return comparator.compare(entry1.getKey(), entry2.getKey());
    }
    // this refactor is intended to fix a branch that might be broken
    private void refactor(int index){
        System.out.format("Refactor iteration running on index %s", index);
        int leftIndex = index*2;
        int rightIndex = leftIndex+1;
        HeapEntry<K, V> leftEntry = entries.get(leftIndex);
        HeapEntry<K, V> rightEntry = entries.get(rightIndex);
        HeapEntry<K, V> current = this.entries.get(index);
        int compareLeft = compare(current, leftEntry);
        int compareRight = compare(current, rightEntry);
        if(compareLeft < 0){
            swap(leftIndex, index);
            refactor(leftIndex);
        }
        if(compareRight < 0) {
            swap(rightIndex, index);
            refactor(rightIndex);
        }
    }
    // this version of refactor is intended to insert a value
    private void refactor(int index, HeapEntry<K,V> relocateTarget){
        System.out.format("Refactor iteration running on index %s, using object with values (%s, %s)\n", index, relocateTarget.getKey(), relocateTarget.getValue());

        HeapEntry<K,V> leftEntryOperation = operateLeft(index, relocateTarget);
        HeapEntry<K,V> rightEntryOperation = operateRight(index, relocateTarget);
        if(index >= entries.size()){
            entries.add(relocateTarget);
        }
        else if(leftEntryOperation != null){
            refactor(index*2, leftEntryOperation);
        }
        else if(rightEntryOperation != null) {
            refactor(index*2 + 1, rightEntryOperation);
        }
        return;
        // int leftIndex = index*2;
        // int rightIndex = leftIndex+1;
        // if(leftIndex >= entries.size() || rightIndex >= entries.size()) {
        //     entries.add(relocateTarget);
        //     return;
        // }
        // HeapEntry<K,V> leftEntry = entries.get(leftIndex);
        // HeapEntry<K,V> rightEntry = entries.get(rightIndex);
        // int compareLeft = compare(relocateTarget, leftEntry);
        // int compareRight = compare(relocateTarget, rightEntry);
        // if(compareLeft > 0){
        //     HeapEntry<K,V> nextRelocateTarget = this.entries.get(leftIndex);
        //     this.entries.get(index);
        //     refactor(leftIndex, nextRelocateTarget);
        // }
        // if(compareRight > 0) {
        //     HeapEntry<K,V> nextRelocateTarget = this.entries.get(rightIndex);
        //     this.entries.get(index);
        //     refactor(rightIndex, nextRelocateTarget);
        // }
        // // refactor()
    }
    private HeapEntry<K,V> operateLeft(int index, HeapEntry<K,V> relocateTarget){
        int leftIndex = index*2;
        if(leftIndex >= entries.size()){
            return null;
        }
        HeapEntry<K,V> leftEntry = entries.get(leftIndex);
        int comparison = compare(leftEntry, relocateTarget);
        if(comparison < 0){
            HeapEntry<K,V> newRelocateTarget = entries.get(leftIndex);
            entries.set(leftIndex, relocateTarget);
            return newRelocateTarget;
        }
        return null;
    }
    private HeapEntry<K,V> operateRight(int index, HeapEntry<K,V> relocateTarget){
        int rightIndex = index*2+1;
        if(rightIndex >= entries.size()){
            return null;
        }
        HeapEntry<K,V> rightEntry = entries.get(rightIndex);
        int comparison = compare(rightEntry, relocateTarget);
        if(comparison < 0){
            HeapEntry<K,V> newRelocateTarget = entries.get(rightIndex);
            entries.set(rightIndex, relocateTarget);
            return newRelocateTarget;
        }
        return null;
    }
    // private void refactorLeft(int index, HeapEntry<K,V> relocateTarget){
    //     System.out.format("Refactor iteration running on index %s, using object with values (%s, %s)\n", index, relocateTarget.getKey(), relocateTarget.getValue());
    //     int leftIndex = index*2;
    //     HeapEntry<K,V> leftEntry = entries.get(leftIndex);
    //     int comparison = compare(leftEntry, relocateTarget);
    //     if(leftIndex >= entries.size()){
    //         return;
    //     }
    //     if(comparison < 0){
    //         HeapEntry<K,V> newRelocateTarget = entries.get(leftIndex);
    //         entries.set(leftIndex, relocateTarget);
    //         refactorLeft(leftIndex, newRelocateTarget);
    //     }
    //     else {
    //         refactorRight(index, relocateTarget);
    //     }
    // }
    // private void refactorRight(int index, HeapEntry<K,V> relocateTarget){
    //     int rightIndex = index*2+1;
    //     refactorLeft(index*2, relocateTarget);
    // }
    private boolean swap(int start, int end){
        if(start >= entries.size() || end >= entries.size()) {return false;}
        HeapEntry<K, V> temp = this.entries.get(start);
        entries.set(start, entries.get(end));
        entries.set(end, temp);
        return true;
    }

    public String toString(){
        String toReturn = "[";
        for(int i = 1; i < this.entries.size()-1; i++){
            toReturn += String.format("%s, ", this.entries.get(i).getKey());
        }
        toReturn += String.format("%s]", this.entries.get(this.entries.size()-1).getKey());
        return toReturn;
    }
}

class HeapEntry<K, V> implements DefaultMap.Entry<K,V>{
    K key;
    V value;

    HeapEntry(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value){
        this.value = value;
    }
}
