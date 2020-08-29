# leetcode No6 Z 字形变换
<p>将一个给定字符串根据给定的行数，以从上往下、从左到右进行&nbsp;Z 字形排列。</p>

<p>比如输入字符串为 <code>&quot;LEETCODEISHIRING&quot;</code>&nbsp;行数为 3 时，排列如下：</p>

<pre>L   C   I   R
E T O E S I I G
E   D   H   N
</pre>

<p>之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如：<code>&quot;LCIRETOESIIGEDHN&quot;</code>。</p>

<p>请你实现这个将字符串进行指定行数变换的函数：</p>

<pre>string convert(string s, int numRows);</pre>

<p><strong>示例&nbsp;1:</strong></p>

<pre><strong>输入:</strong> s = &quot;LEETCODEISHIRING&quot;, numRows = 3
<strong>输出:</strong> &quot;LCIRETOESIIGEDHN&quot;
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong> s = &quot;LEETCODEISHIRING&quot;, numRows =&nbsp;4
<strong>输出:</strong>&nbsp;&quot;LDREOEIIECIHNTSG&quot;
<strong>解释:</strong>

L     D     R
E   O E   I I
E C   I H   N
T     S     G</pre>
<div><div>Related Topics</div><div><li>字符串</li></div></div>


## Solution1
行数为numRows行，设置一个长度为numRows的数组
以4行为例子`ArrayList<StringBuilder> arrayList = new ArrayList<>(numRows);`
```java
for(int i = 0; i < s.length(); i++){

}
```
j表示arrayList下标
<pre>
L     D     R  arrayList[0]
E   O E   I I  arrayList[1]
E C   I H   N  arrayList[2]
T     S     G  arrayList[3]
</pre>

第一趟：i=0，j=0
<pre>
L     D     R  arrayList[0]：L
E   O E   I I  arrayList[1]
E C   I H   N  arrayList[2]
T     S     G  arrayList[3]
</pre>

第二趟：i=1，j=1
<pre>
L     D     R  arrayList[0]：L
E   O E   I I  arrayList[1]：E
E C   I H   N  arrayList[2]
T     S     G  arrayList[3]
</pre>

第三趟：i=2，j=2
<pre>
L     D     R  arrayList[0]：L
E   O E   I I  arrayList[1]：E
E C   I H   N  arrayList[2]：E
T     S     G  arrayList[3]
</pre>

第四趟：i=3，j=3
<pre>
L     D     R  arrayList[0]：L
E   O E   I I  arrayList[1]：E
E C   I H   N  arrayList[2]：E
T     S     G  arrayList[3]：T
</pre>

第五趟：i=4，j=2，**关键点，如何实现j++，变j--**
<pre>
L     D     R  arrayList[0]：L
E   O E   I I  arrayList[1]：E
E C   I H   N  arrayList[2]：EC
T     S     G  arrayList[3]：T
</pre>
此处设计一个flag=-1，当j==0orj==n-1时，flag=-flag;
即每次循环
i++,j=j+flag，最后把arrayList链接起来输出即可。

时间复杂度：O(N)
空间复杂度：O(N)


## Solution2 转换为一个数学题

