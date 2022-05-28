
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
        int index = 1;
        int comparison;
        HeapEntry<K,V> current;
        while(index < entries.size()){
            current = this.entries.get(index);
            comparison = compare(current.getKey(), key);
            if(comparison == 0){break;}
            else if(comparison == 1) {index *= 2;}
            else if(comparison == -1) {index = index * 2 + 1;}
        }
        entries.set(index, new HeapEntry<K, V>(key, value));
    }

    public HeapEntry<K,V> peek() {
        // Method to return the max element in the heap
        return entries.get(1);
    }

    public HeapEntry<K,V> remove() {
        //Method to remove the max element in the heap, remember to satisfy max heap Property
        HeapEntry<K, V> toReturn = this.entries.get(1);
        this.entries.set(1, null);
        refactor(1);
        return toReturn;
    }
    // because i don't want to write "comparator.compare() every time"
    private int compare(K entry1, K entry2){
        return comparator.compare(entry1, entry2);
    }
    private int compare(HeapEntry<K,V> entry1, HeapEntry<K,V> entry2){
        return comparator.compare(entry1, entry2);
    }
    // this refactor is intended to fix a branch that might be broken
    private void refactor(int index){
        int leftIndex = index*2;
        int rightIndex = leftIndex+1;
        HeapEntry<K, V> leftEntry = entries.get(leftIndex);
        HeapEntry<K, V> rightEntry = entries.get(rightIndex);
        HeapEntry<K, V> current = this.entries.get(index);
        int compareLeft = compare(current, leftEntry);
        int compareRight = compare(current, rightEntry);
        if(compareLeft > 0){
            swap(leftIndex, index);
            refactor(leftIndex);
        }
        if(compareRight > 0) {
            swap(rightIndex, index);
            refactor(rightIndex);
        }
    }
    // this version of refactor is intended to insert a value
    private void refactor(int index, HeapEntry<K,V> relocateTarget){
        int leftIndex = index*2;
        int rightIndex = leftIndex+1;
        HeapEntry<K,V> leftEntry = entries.get(leftIndex);
        HeapEntry<K,V> rightEntry = entries.get(rightIndex);
        // HeapEntry<K,V> head = entries.get(index);
        int compareLeft = compare(relocateTarget, leftEntry);
        int compareRight = compare(relocateTarget, rightEntry);
        if(compareLeft > 0){
            HeapEntry<K,V> nextRelocateTarget = this.entries.get(leftIndex);
            this.entries.get(index);
            refactor(leftIndex, nextRelocateTarget);
        }
        if(compareRight > 0) {
            HeapEntry<K,V> nextRelocateTarget = this.entries.get(rightIndex);
            this.entries.get(index);
            refactor(rightIndex, nextRelocateTarget);
        }
        if(leftIndex >= entries.size() || rightIndex >= entries.size()) {
            entries.add(relocateTarget);
        }
    }
    private boolean swap(int start, int end){
        if(start >= entries.size() || end >= entries.size()) {return false;}
        HeapEntry<K, V> temp = this.entries.get(start);
        entries.set(start, entries.get(end));
        entries.set(end, temp);
        return true;
    }

    public String toString(){
        String toReturn = "[";
        for(int i = 0; i < this.entries.size(); i++){
            toReturn = String.format("%s, %s", toReturn, entries.get(i));
        }
        return String.format("%s]", toReturn);
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
