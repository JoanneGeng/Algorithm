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


## Solution
les
竖向4，斜线4-2
val lastColumn = (lens%4)
val all = (lens/4)
0,6,12,1,5,7,11,13,2,4,8,10,14,3,9,15
<pre>
0         6         12  i(n-1)
1      5  7     11  13  i(n-1) + 1 
2  4      8  10     14  
3         9         15
</pre>

竖向n，斜线n-2
<pre>
0               2n-2                4n-4  2n-2
1         2n-3  2n-1          4n-3  4n-3  2n-2 + 1 ，2(2n-2)+1
...     ...     ...         ...     ...
n-2  n          3n-3  3n-1          5n-3 (2n-2 + n-1),(2n-2 + n-1)-
n-1             3n-2                5n-2 (2n-2 + n) 
</pre>

找规律
每一列都要先取
(2 * num_rows - 2)*i+row
除第一列和最后一列，还有一个
(2 * num_rows - 2)*i+(2 * num_rows - 2)-i



