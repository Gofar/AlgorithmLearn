package com.gofar.library.unionfind;

/**
 * quick-union
 * 可以快速进行union操作，只需将一个节点的连通分量改为另一个连通分量
 * find操作开销较大，需要一直向上查找直到找到最上层节点
 *
 * @author lcf
 * @date 2018/7/4 15:23
 * @since 1.0
 */
public class QuickUnionUF extends UF {
    /**
     * 构造大小为N的并查集
     *
     * @param N 元素数量
     */
    public QuickUnionUF(int N) {
        super(N);
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot != qRoot) {
            // 直接将pRoot的上级节点改为qRoot
            id[pRoot] = qRoot;
        }
    }

    @Override
    public int find(int p) {
        int r = p;
        // 如果r的上级节点不是自己，就接着找上级直到找到根节点
        while (id[r] != r) {
            r = id[r];
        }
        return r;
    }
}
