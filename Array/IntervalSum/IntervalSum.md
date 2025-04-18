# 区间和

## 题目特征

* 计算区间和

## 题目解法

**前缀和**

前缀和的思想是重复利用计算过的子数组之和，从而降低区间查询需要累加计算的次数。

```
例如，我们要统计 vec[i] 这个数组上的区间和。

我们先做累加，即 p[i] 表示 下标 0 到 i 的 vec[i] 累加 之和。

如果，我们想统计，在vec数组上 下标 2 到下标 5 之间的累加和，用 p[5] - p[1] 就可以了。
```

**特别注意**： 在使用前缀和求解的时候，要特别注意求解区间。

如果我们要求区间下标 [2, 5] 的区间和，那么应该是 p[5] - p[1]，而不是 p[5] - p[2]。

## 题目延伸

#### 开发商购买土地

```
【题目描述】
在一个城市区域内，被划分成了n * m个连续的区块，每个区块都拥有不同的权值，代表着其土地价值。目前，有两家开发公司，A 公司和 B 公司，希望购买这个城市区域的土地。 

现在，需要将这个城市区域的所有区块分配给 A 公司和 B 公司。

然而，由于城市规划的限制，只允许将区域按横向或纵向划分成两个子区域，而且每个子区域都必须包含一个或多个区块。 为了确保公平竞争，你需要找到一种分配方式，使得 A 公司和 B 公司各自的子区域内的土地总价值之差最小。 

注意：区块不可再分。

【输入描述】
第一行输入两个正整数，代表 n 和 m。 

接下来的 n 行，每行输出 m 个正整数。

【输出描述】
请输出一个整数，代表两个子区域内土地总价值之间的最小差距。
【输入示例】
3 3
1 2 3
2 1 3
1 2 3
【输出示例】
0
【提示信息】
如果将区域按照如下方式划分：

1 2 | 3
2 1 | 3
1 2 | 3 

两个子区域内土地总价值之间的最小差距可以达到 0。

数据范围：

1 <= n, m <= 100；
n 和 m 不同时为 1。
```
本题也可以使用 前缀和的思路来求解，先将 行方向，和 列方向的和求出来，这样可以方便知道 划分的两个区间的和。

先统计好，前n行的和 q[n]，如果要求矩阵 a行 到 b行 之间的总和，那么就 q[b] - q[a - 1]就好。

时间复杂度： $O(n^2)$
