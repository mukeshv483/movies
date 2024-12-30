package com.example.demo.unionfind;

/**
 * @author Mukesh Verma
 */
public class UnionFind {
    private int size;
    private int[] sizes;
    private int[] ids;
    private int components;

    public UnionFind(int size) {
        this.size = size;
        sizes = new int[size];
        ids = new int[size];
        components=size;
        for (int i = 0; i < size; i++) {
            sizes[i] = 1;
            ids[i] = i;

        }
    }

    public int find(int p) {
        int root = p;

        while (root != ids[root]) {
            root = ids[root];
        }
        while (p != root) {
            int next = ids[p];
            ids[p] = root;
            p = next;
        }
        return root;
    }

    public boolean isConnected(int u, int v) {
        return find(u) == find(v);
    }

    public void unify(int p, int q) {
        int root1 = find(p);
        int root2 = find(q);

        if (root1 == root2) {
            return;
        }
        if (sizes[root1] < sizes[root2]) {
            sizes[root2] += sizes[root1];
            ids[root1] = root2;

        }
        else {
            sizes[root1] += sizes[root1];
            ids[root2] = root1;
        }
        components--;
    }

    public static void main(String[] args) {

    }


}
