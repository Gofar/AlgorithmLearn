package com.gofar.library.unionfind;

/**
 * 并查集
 *
 * @author lcf
 * @date 2018/7/4 15:01
 * @since 1.0
 */
public abstract class UF {
    protected int[] id;

    /**
     * 构造大小为N的并查集
     *
     * @param N 元素数量
     */
    public UF(int N) {
        id = new int[N];
        // 初始化每个节点的连通分量为自己
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     * 连接p和q的节点
     *
     * @param p 节点p
     * @param q 节点q
     */
    public abstract void union(int p, int q);

    /**
     * 查找p所在的连通分量
     *
     * @param p 节点p
     * @return p的连通分量
     */
    public abstract int find(int p);

    /**
     * 判断p和q节点是否连通
     *
     * @param p 节点p
     * @param q 节点q
     * @return True if 连通分量相同则是相同的
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}
