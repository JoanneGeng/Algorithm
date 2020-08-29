# 两数相加

- [content](#content)
- [solution 链表相加](#solution-链表相加)

## content
<p>给出两个&nbsp;<strong>非空</strong> 的链表用来表示两个非负的整数。其中，它们各自的位数是按照&nbsp;<strong>逆序</strong>&nbsp;的方式存储的，并且它们的每个节点只能存储&nbsp;<strong>一位</strong>&nbsp;数字。</p>

<p>如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。</p>

<p>您可以假设除了数字 0 之外，这两个数都不会以 0&nbsp;开头。</p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong>(2 -&gt; 4 -&gt; 3) + (5 -&gt; 6 -&gt; 4)
<strong>输出：</strong>7 -&gt; 0 -&gt; 8
<strong>原因：</strong>342 + 465 = 807
</pre>
<div><div>Related Topics</div><div><li>链表</li><li>数学</li></div></div>\n<div><li>👍 4812</li><li>👎 0</li></div>

## solution 链表相加 

1，初始化带头指针新链表，游标指向头接点，进位标识位初始化位0

<pre>
ListNode resultList = new ListNode(0);
ListNode p = resultList
int carry = 0;</pre>

2，遍历两个链表

- a, 对应结点依次相加，如果大于10则向前进位
    <pre>
    sum = (x + y + carry)%10;
    carry = (x + y + carry)/10;</pre>

- b, 生产新结点
    <pre>
    ListNode newNode = new ListNode(sum);</pre>
    
- c, 带头指针尾节点插入，游标指向新插入结点
    <pre>
    p.next = newNode;
    p = cur.p;</pre>
    
3，循环结束，判断carry > 0，再插入进位结点
<pre>
 if(carry>0) p.next = new ListNode(0);</pre>
 
4, 返回除掉头结点链表
<pre>
return resultList.next;</pre>
