package com.gofar.library.unionfind;

/**
 * 路径压缩的加权quick-union
 *
 * @author lcf
 * @date 2018/7/4 16:46
 * @since 1.0
 */
public class PathWeightedQuickUnionUF extends UF {
    private int[] sz;

    /**
     * 构造大小为N的并查集
     *
     * @param N 元素数量
     */
    public PathWeightedQuickUnionUF(int N) {
        super(N);
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }

    @Override
    public int find(int p) {
        int r = p;
        while (id[r] != r) {
            r = id[r];
        }
        // 将p与跟节点间的所有上级节点指向跟节点
        int k = p;
        int j;
        while (k != r) {
            // j暂存k的父节点
            j = id[k];
            // k的父节点指向根节点
            id[k] = r;
            // k移动到父节点
            k = j;
        }
        return r;
    }

    /**
     * 递归路径压缩
     * {#find(int p)}
     * @param p
     * @return
     */
    private int findF(int p) {
        while (p != id[p]) {
            // 从p节点搜索到根节点经过的所有节点都指向根节点
            id[p] = findF(id[p]);
        }
        return id[p];
    }
}
