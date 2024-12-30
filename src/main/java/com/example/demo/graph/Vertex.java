package com.example.demo.graph;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

/**
 * @author Mukesh Verma
 */
@Data
public class Vertex {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return value == vertex.value && Objects.equals(next, vertex.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, next);
    }

    int value;
    Vertex next;
    public Vertex(int value) {
        this.value = value;
        this.next = null;
    }

}
