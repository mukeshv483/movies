package com.example.demo.hash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Objects;

/**
 * @author Mukesh Verma
 */
@Data
@AllArgsConstructor
@ToString
public class Entry<K extends  Comparable<K>,V extends  Comparable<V>> {
     K key;

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Entry<?, ?> entry = (Entry<?, ?>) o;
          return Objects.equals(key, entry.key) && Objects.equals(value, entry.value) && Objects.equals(next, entry.next);
     }

     @Override
     public int hashCode() {
          return Objects.hash(key, value, next);
     }

     V value;
     Entry<K,V> next;
}
