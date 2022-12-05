### 2492. 两个城市间路径的最小分数
给你一个正整数 n ，表示总共有 n 个城市，城市从 1 到 n 编号。给你一个二维数组 roads ，其中 roads[i] = [ai, bi, distancei] 表示城市 ai 和 bi 之间有一条 双向 道路，道路距离为 distancei 。城市构成的图不一定是连通的。

两个城市之间一条路径的 分数 定义为这条路径中道路的 最小 距离。

城市 1 和城市 n 之间的所有路径的 最小 分数。
注意：

1. 一条路径指的是两个城市之间的道路序列。
2. 一条路径可以 多次 包含同一条道路，你也可以沿着路径多次到达城市 1 和城市 n 。
3. 测试数据保证城市 1 和城市n 之间 至少 有一条路径。

示例 1：

[![图1](/picture/1.png)](https://github.com/justinSmileDate/LanQiaoCup/blob/master/LeetCodeTopics/GraphTheory/picture/1.png)

输入：n = 4, roads = [ [1,2,9],[2,3,6],[2,4,5],[1,4,7]]
输出：5
解释：城市 1 到城市 4 的路径中，分数最小的一条为：1 -> 2 -> 4 。这条路径的分数是 min(9,5) = 5 。
不存在分数更小的路径。

//DFS 注意建图 用`List<int[]>[] graph = new ArrayList[n + 1]` 首先这是一个数组，其次数组中放的元素是一个链表，最后链表中的数据以数组的形式存在。
```java
class Solution {
    public int minScore(int n, int[][] roads) {
        boolean[] vis = new boolean[n + 1];
        //建立数组，数组中存放Arraylist()，每个Arraylist中又存数组
        List<int[]>[] graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i ++) graph[i] = new ArrayList<>();
        //建图源节点里存放 目的节点 和 权重 组成的二维数组，同时也在目的中放
        for(int[] road : roads) {
            graph[road[0]].add(new int[]{road[1], road[2]});
            graph[road[1]].add(new int[]{road[0], road[2]});
        }
        return dfs(graph, 1, vis);
    }

    public int dfs(List<int[]>[] graph, int star, boolean[] vis) {
        int min = Integer.MAX_VALUE;
        vis[star] = true;
        for(int[] to : graph[star]) {
            min = Math.min(min, to[1]);
            if(!vis[to[0]]) {
                min = Math.min(min, dfs(graph, to[0], vis));
            }
        }
        return min;
    }
}

```

//UnionFind 
