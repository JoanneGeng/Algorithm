[TOC]
# 寻找两个正序数组的中位数
> 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 假设 nums1 和 nums2 不会同时为空。

## Solution1 合并两个数组

使用哨兵合并两个有序数组，生成新数组L，计算单个数组中位数。

奇数
k=(m+n)/2
偶数
k1=(m+n)/2
k2=(m+n)/2-1

```java
if (totalLength % 2 != 0) { // 奇数
    return newNums[totalLength / 2];
} else { // 偶数
    return (newNums[totalLength / 2] + newNums[totalLength / 2 - 1]) / 2.0;
}
```
时间复杂度：O(N)

```java
info
    Success:
    Runtime:3 ms, faster than 61.65% of Java online submissions.
    Memory Usage:41 MB, less than 19.64% of Java online submissions.
```

## Solution2 二分查找

n和m是有限数组，且数组长度可知。由此，此题可以理解成找出```k=(m+n)/2;k2=(m+n)/2-1```即可;
```
info
    Success:
    Runtime:2 ms, faster than 100.00% of Java online submissions.
    Memory Usage:40.8 MB, less than 49.84% of Java online submissions.
```




