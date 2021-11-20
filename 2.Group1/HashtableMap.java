// --== CS400 Project One File Header ==--
// Name: Julian Zhu
// Email: zzhu344@wisc.edu / julian.zhu@wisc.edu
// Team: Purple
// Group: DE
// TA: Daniel Finer
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * HashtableMap is a generic hashtable which implements the MapADT interface.
 *
 * @param <KeyType>   - class type of keys
 * @param <ValueType> - class type of values
 */
public class HashtableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {
    private LinkedList<KVPair<KeyType, ValueType>>[] data;
    private int capacity;
    private int numItems;
    private double threshold = 0.8;

    /**
     * Constructor function that manually set the initial capacity.
     *
     * @param capacity - initial capacity
     */
    public HashtableMap(int capacity) {
        this.capacity = capacity;
        numItems = 0;
        data = (LinkedList<KVPair<KeyType, ValueType>>[]) new LinkedList[capacity];
    }

    /**
     * Constructor function with default capacity = 20
     */
    public HashtableMap() {
        this(20);
    }

    /**
     * Put a key-value pair into the hashtable
     *
     * @param key
     * @param value
     * @return whether the putting action succeeded.
     * It fails if the key is null or is already used in the hashtable.
     */
    @Override
    public boolean put(KeyType key, ValueType value) {
        if (key == null || containsKey(key))
            return false;

        numItems++;
        KVPair<KeyType, ValueType> pair = new KVPair<>(key, value);
        int idx = hash(key, capacity);
        if (data[idx] == null) {
            data[idx] = new LinkedList<>();
        }
        data[idx].add(pair);

        if ((1.0 * numItems / capacity) >= threshold) {
            // new capacity = old capacity * 2
            resize(capacity << 1);
        }
        return true;
    }

    /**
     * Get a value by providing its corresponding key.
     *
     * @param key
     * @return the corresponding value of the provided key.
     * @throws NoSuchElementException if no such key was stored in the hashtable or key is null
     */
    @Override
    public ValueType get(KeyType key) throws NoSuchElementException {
        if (key == null)
            throw new NoSuchElementException("Error: Key cannot be null!");
        int idx = hash(key, capacity);
        if (data[idx] == null) {
            throw new NoSuchElementException("Error: no element with provided " +
                    "key was stored in the HashtableMap!");
        }
        for (KVPair<KeyType, ValueType> pair : data[idx]) {
            if (pair.key.equals(key)) {
                return pair.value;
            }
        }
        throw new NoSuchElementException("Error: no element with provided " +
                "key was stored in the HashtableMap!");
    }

    /**
     * Return the current number of key-value pairs stored in the hashtable
     *
     * @return the current # of key-value pairs stored in the hashtable
     */
    @Override
    public int size() {
        return numItems;
    }

    /**
     * Check if the provided key is stored in the hashtable or not.
     *
     * @param key
     * @return true if the key is in used, otherwise false
     */
    @Override
    public boolean containsKey(KeyType key) {
        if (key == null)
            return false;
        int idx = hash(key, capacity);
        if (data[idx] == null) {
            return false;
        }
        for (KVPair<KeyType, ValueType> pair : data[idx]) {
            if (pair.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Remove the key-value pair in the hashtable by giving the key
     *
     * @param key the key of k-v pair to be removed
     * @return the value of k-v pair that is removed
     */
    @Override
    public ValueType remove(KeyType key) {
        if (key == null)
            return null;
        int idx = hash(key, capacity);
        if (data[idx] == null) {
            return null;
        }
        for (int i = 0; i < data[idx].size(); i++) {
            KVPair<KeyType, ValueType> pair = data[idx].get(i);
            if (pair.key == key) {
                data[idx].remove(i);
                numItems--;
                return pair.value;
            }
        }
        return null;
    }

    /**
     * Remove all elements stored in the hashtable
     */
    @Override
    public void clear() {
        numItems = 0;
        data = (LinkedList<KVPair<KeyType, ValueType>>[]) new LinkedList[capacity];
    }

    /**
     * Compute the index of a given key in a hashtable with a given capacity
     *
     * @param key
     * @param capacity
     * @return the index of the given key in the hashtable with the given capacity
     */
    private int hash(KeyType key, int capacity) {
        int hashcode = key.hashCode();
        if (hashcode < 0)
            hashcode = -hashcode;
        return (hashcode % capacity);
    }

    /**
     * Resize the capacity of the hashtable
     *
     * @param newCapacity - the new capacity of the hashtable
     */
    private void resize(int newCapacity) {
        LinkedList<KVPair<KeyType, ValueType>>[] newData =
                (LinkedList<KVPair<KeyType, ValueType>>[]) new LinkedList[newCapacity];
        for (LinkedList<KVPair<KeyType, ValueType>> list : data) {
            if (list == null)
                continue;
            for (KVPair<KeyType, ValueType> pair : list) {
                int idx = hash(pair.key, newCapacity);
                if (newData[idx] == null) {
                    newData[idx] = new LinkedList<>();
                }
                newData[idx].add(pair);
            }
        }
        data = newData;
        capacity = newCapacity;
    }

    public static void main(String[] args) {
        HashtableMap<Integer, Integer> map = new HashtableMap<>(1);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
    }
}

/**
 * A generic class to represent a key-value pair datatype.
 *
 * @param <KeyType>   the class type of key
 * @param <ValueType> the class type of value
 */
class KVPair<KeyType, ValueType> {
    public KeyType key;
    public ValueType value;

    KVPair(KeyType key, ValueType value) {
        this.key = key;
        this.value = value;
    }
}
