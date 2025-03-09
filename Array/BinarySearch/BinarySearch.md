# 704.二分查找
## 题目特征
* 数组为有序数组
* 数组中无重复元素（如果有的话应该是连续的）
* 时间复杂度为$O(\log N)$
* 空间复杂度为$O(1)$

## 题目解法

### 方法一（我最常用）

定义 target 是在一个在左闭右闭的区间里，也就是`[left, right]`

* `while (left <= right)` 要使用 <= ，因为`left == right`是有意义的，所以使用 <=
* `if (nums[middle] > target)` `right` 要赋值为 middle - 1，因为当前这个`nums[middle]`一定不是`target`，那么接下来要查找的左区间结束下标位置就是 middle - 1

## 延伸题目

### 34. 在排序数组中查找元素的第一个和最后一个位置 

searchRange.java

寻找target在数组里的左右边界，有如下三种情况：

- 情况一：target 在数组范围的右边或者左边，例如数组{3,4,5}，target为2或者数组{3, 4, 5},target为6，此时应该返回{-1, -1}
- 情况二：target 在数组范围中，且数组中不存在target，例如数组{3,6,7},target为5，此时应该返回{-1, -1}
- 情况三：target 在数组范围中，且数组中存在target，例如数组{3,6,7},target为6，此时应该返回{1, 1}

采用二分法来去寻找左右边界，为了让代码清晰，分别写两个二分来寻找左边界和右边界。

刚刚接触二分搜索的同学不建议上来就想用一个二分来查找左右边界，很容易把自己绕进去，建议扎扎实实的写两个二分分别找左边界和右边界

#### 寻找右边界

 * 使用`[left, right]`

 * 确定：计算出来的右边界不包含target的右边界

### 69.x的平方根

mySqrt.java

* **注意int类型溢出问题**，要改用long
* `left = 0`
* 多定义一个变量ans, 在`mid * mid <= x`时赋值 `ans = mid`

### 367. 有效的完全平方数

isPerfectSquare.java

* 既要防溢出，还要防丢失精度
* 参考题解：
````java
//还是一样使用防止溢出的策略
int mid=left+(right-left)/2;
           
//不丢失精度
if(num%mid==0 && mid==num/mid)
{
    return true;
}else if(mid<num/mid)
{
    //小了
left=mid+1;
}else
{
    right=mid-1;
}
````