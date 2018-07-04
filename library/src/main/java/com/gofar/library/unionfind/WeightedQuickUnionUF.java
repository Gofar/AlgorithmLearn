package com.gofar.library.unionfind;

/**
 * 加权quick-union
 * 在quick-union上改进，将较小的树连接到较高的树上，降低树的高度。
 *
 * @author lcf
 * @date 2018/7/4 15:51
 * @since 1.0
 */
public class WeightedQuickUnionUF extends UF {
    /**
     * 保存节点的数量信息
     */
    private int[] sz;

    /**
     * 构造大小为N的并查集
     *
     * @param N 元素数量
     */
    public WeightedQuickUnionUF(int N) {
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
        return r;
    }
}