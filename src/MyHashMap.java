import java.util.List;
import java.util.Objects;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Comparator;

public class MyHashMap<K, V> implements DefaultMap<K, V> {

    public static final int DEFAULT_INITIAL_CAPACITY = 10;
    public static final String ILLEGAL_ARG_CAPACITY = 
        "Initial Capacity must be non-negative";
    public static final String ILLEGAL_ARG_NULL_KEY = "Keys must be non-null";

    private double loadFactor;
    private int capacity;
    private int size;	
    private Comparator myComparator;
    private Character[] sections;

    // Use this instance variable for Separate Chaining conflict resolution
    // private List<HashMapEntry<K, V>>[] buckets;  
    private List<MaxHeap<K, V>> buckets;

    // Use this instance variable for Linear Probing
    //	private HashMapEntry<K, V>[] entries; 

    public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, null);}

    @SuppressWarnings("unchecked")
    public MyHashMap(int initialCapacity, Comparator myComparator)
        throws IllegalArgumentException {
        this.capacity = initialCapacity; 
        this.size = 0;
        this.sections = new Character[initialCapacity];
        this.buckets = new ArrayList(initialCapacity);
        //constrcutor for the hashMap
    }

    @Override
    public boolean put(K key, V value) throws IllegalArgumentException {
        HashMapEntry entry = new HashMapEntry<K,V>(key, value);
        int hashCode = Math.abs(Objects.hashCode(key));
        //Method to add the key value pair to the hashMap
        int index = hashCode % buckets.size();

    }



    @Override
    public V get(K key) throws IllegalArgumentException {

        //Method to get the value of given key
    }

    @Override
    public boolean containsKey(K key) throws IllegalArgumentException {
        //Method to check if key is present
    }

    @Override
    public int size() {
        //Method to get size of the hashMap
    }

    @Override
    public boolean isEmpty() {
        //Method to check if hashMap is empty
    }

    protected static class HashMapEntry<K, V> implements DefaultMap.Entry<K, V> {

        K key;
        V value;

        public HashMapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean equals(Object o) {
            if (o instanceof MyHashMap.HashMapEntry<?, ?>) {
                HashMapEntry<K, V> other = null;
                try {
                    other = (HashMapEntry<K, V>) o;
                } catch (ClassCastException e) {
                    return false;
                }

                return Objects.equals(key, other.key);
            }


            return false;
        }

    }
}
