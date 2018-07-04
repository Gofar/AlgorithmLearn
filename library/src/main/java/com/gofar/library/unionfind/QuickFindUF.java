package com.gofar.library.unionfind;

/**
 * quick-find
 * 可以快速进行find操作
 * union操作代价很高，需要将一个连通分量下的所有节点的连通分量改为另一个连通分量
 *
 * @author lcf
 * @date 2018/7/4 15:12
 * @since 1.0
 */
public class QuickFindUF extends UF {
    /**
     * 构造大小为N的并查集
     *
     * @param N 元素数量
     */
    public QuickFindUF(int N) {
        super(N);
    }

    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            // 已经连通，不用再连通
            return;
        }
        // 将与p有相同的连通分量的节点改为q的连通分量实现p与q连接
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }

    @Override
    public int find(int p) {
        return id[p];
    }
}
