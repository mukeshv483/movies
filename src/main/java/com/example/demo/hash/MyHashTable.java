package com.example.demo.hash;

import lombok.ToString;


/**
 * @author Mukesh Verma
 */
@ToString
public class MyHashTable<K extends Comparable<K>, V extends Comparable<V>> {
    Entry[] entries;
    int hashSize;
    int capacity;

    public MyHashTable(int capacity) {
        this.capacity=capacity;
        this.entries = new Entry[capacity];

    }

    public void put(K key, V value) {
        hashSize++;
        int index = getHashCode(key);
        if (entries[index] == null) {
            entries[index] = new Entry(key, value, null);
            return;
        }
        Entry<K, V> temp = entries[index];
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(new Entry<>(key, value, null));
    }

    public V get(K key) {
        if (containsKey(key)) {
            Entry<K, V> temp = entries[getHashCode(key)];
            while (temp != null) {
                if (temp.getKey().compareTo(key) == 0) {
                    return temp.getValue();
                }
                temp = temp.getNext();
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        int index = getHashCode(key);
        if (entries[index] != null) {
            return true;
        }
        return false;
    }

    private int getHashCode(K key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode()) % capacity;
    }

    public int size() {
        return hashSize;
    }

    public static void main(String[] args) {
        MyHashTable<String,Integer>hashTable=new MyHashTable<>(6);
        hashTable.put("A",1);
        hashTable.put("C",8);
        hashTable.put("F",5);
        hashTable.put("FD",4);
        hashTable.put("A2",1);
        hashTable.put("C3",8);
        hashTable.put("F3",5);
        hashTable.put("FD1",4);
      //  System.out.println(hashTable.toString());
        System.out.println(hashTable.get("3"));


    }

}
